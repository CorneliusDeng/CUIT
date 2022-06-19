package com.ylm.demo.nettyServer;

import com.alibaba.fastjson.JSON;
import com.ylm.demo.pojo.AttributeKeys;
import com.ylm.demo.pojo.MsgPacket;
import com.ylm.demo.pojo.RequestUriUtils;
import com.ylm.demo.pojo.UserChannelUtil;
import com.ylm.demo.service.GroupUserService;
import com.ylm.demo.service.OfMsgService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
public class MyWebSocketHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
    private static final int PHONE_AGENT_NUM = 7000000;
    private static final int File_AGENT_NUM = 8000000;

    private final GroupUserService groupService;    //群用户查询服务
    private final OfMsgService msgService;      //离线消息查询服务
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public MyWebSocketHandler(OfMsgService dao,GroupUserService groupService) {
        this.msgService = dao;
        this.groupService = groupService;
    }
    Boolean firstMsg = true;

    /**
     * 客户端连接的时候触发
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //有客户端连接就打印出channel的id
        log.info("handlerAdded：" + ctx.channel().id());
        channels.add(ctx.channel());
    }

    /**
     * 客户端连接的时候触发
     * @param ctx
     * @throws Exception
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //有客户端连接就打印出channel的id
        ctx.channel().writeAndFlush(new TextWebSocketFrame("123"));
    }
    /**
     * 客户端断开连接的时候触发
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        UserChannelUtil.removeChannel(ctx.channel().attr(AttributeKeys.USER_ID).get());
        //打印出断开连接的channel的id
        log.info("handlerRemoved：" + ctx.channel().id());
        //从服务端的channelGroup中移除当前离开的客户端
        channels.remove(ctx.channel());

    }

    /**
     * 服务器监听消息函数，有新消息就进行分发
     * @param ctx
     * @param frame
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
        // 根据请求数据类型进行分发处理
        if (frame instanceof PingWebSocketFrame) {
            pingWebSocketFrameHandler(ctx, (PingWebSocketFrame) frame);
        } else if (frame instanceof TextWebSocketFrame) {
            textWebSocketFrameHandler(ctx, (TextWebSocketFrame) frame);
        } else if (frame instanceof CloseWebSocketFrame) {
            closeWebSocketFrameHandler(ctx, (CloseWebSocketFrame) frame);
        }
    }

    /**
     * 对客户端的每次请求都检验数据类型，若是握手请求
     * 则跳转至fullHttpRequestHandler进行uri处理
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            log.info("客户端请求数据类型：{}", msg.getClass());
            fullHttpRequestHandler(ctx, (FullHttpRequest) msg);
        }
        super.channelRead(ctx, msg);
    }

    /**
     * 握手时对uri的获取，并改变为初始值
     * @param ctx
     * @param request
     */
    private void fullHttpRequestHandler(ChannelHandlerContext ctx, FullHttpRequest request) {
        String uri = request.uri();
        Map<String,String> params = RequestUriUtils.getParams(uri);
        if (RequestUriUtils.isNumber(params.get("uid"))){
            int userID = Integer.parseInt(params.get("uid"));
            ctx.channel().attr(AttributeKeys.USER_ID).set(userID);  //为信道添加userID属性
            UserChannelUtil.saveChannel(userID,ctx.channel());      //保存id与信道的映射
            System.out.println("用户(id="+params.get("uid")+ ")连接服务器成功");
        }else {
//            ctx.close();
        }
        request.setUri(RequestUriUtils.getBasePath(uri));
//        System.out.println(params);
    }

    /**
     * 客户端断开请求处理
     * @param ctx
     * @param frame
     */
    private void closeWebSocketFrameHandler(ChannelHandlerContext ctx, CloseWebSocketFrame frame) {
        ctx.close();
    }

    /**
     * 客户端消息处理
     * @param ctx
     * @param frame
     */
    private void textWebSocketFrameHandler(ChannelHandlerContext ctx, TextWebSocketFrame frame) {
        try {
            Integer userID = ctx.channel().attr(AttributeKeys.USER_ID).get();
            MsgPacket packet = JSON.parseObject(frame.text(),MsgPacket.class);
            if (packet.getType().equals("0")){
                //心跳包
//                log.info("ping");
            }else{
                //打印接收的消息
                System.out.println("服务器时间: " + LocalDateTime.now() + "  ： " + frame.text());
                if(!packet.isGroupChat()){   //私聊
                    if(packet.getAccepterId()!=userID){ //发给自己的消息不处理
                        Channel channel = UserChannelUtil.getChannel(packet.getAccepterId());
                        //消息处理与转发
                        this.ChatHandle(packet,channel,ctx);
                    }

                }else {     //群聊
                    log.info("转发群消息到："+packet.getAccepterId());
                    List<Integer> uidList = groupService.findById(packet.getAccepterId());
                    for(Integer uid:uidList){
                        if (!uid.equals(userID)){
                            Channel channel = UserChannelUtil.getChannel(uid);
                            if(channel!=null){
                                //转发
                                channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(packet)));
                            }
                        }
                    }
                }
            }

            if(firstMsg){
                //获取离线消息
                List<MsgPacket> offlineMsg = msgService.findById(userID);
                for (MsgPacket offlineM:offlineMsg){
                    //逐条发给客户端
                    ctx.channel().writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(offlineM)));
                    System.out.println("用户(id="+userID+ ")加载离线消息："+JSON.toJSONString(offlineM));
                }
                //消息取出后删除数据库记录
                msgService.deleteMsg(ctx.channel().attr(AttributeKeys.USER_ID).get());
                firstMsg=false;
            }

        }catch (Exception e){
            //不是规定报文，json转化出错则返回
            ctx.channel().writeAndFlush(new TextWebSocketFrame(frame.text()));
        }
    }

    /**
     * 好友消息处理
     */
    private void ChatHandle(MsgPacket packet,Channel channel,ChannelHandlerContext ctx){
        if (channel==null){
            if(packet.getAccepterId()<= PHONE_AGENT_NUM){
                System.out.println(packet.getAccepterId()+"不在线,消息已存入数据库");
                //离线消息暂存
                if(packet.getMsg().equals("📞 视频通话")){
                    packet.setSenderId(packet.getSenderId()- PHONE_AGENT_NUM);
                    packet.setMsg("📞 未接电话");
                }
                if(packet.getMsg().equals("【请求发送文件】")){
                    packet.setSenderId(packet.getSenderId()- File_AGENT_NUM);
                    packet.setMsg("【文件发送请求】未接收");
                }
                if (packet.getAccepterId()<=1000000){
                    msgService.insertMsg(packet);
                }
            }
        }else {
            //检查是否正在通话中
            if(packet.getMsg().equals("📞 视频通话")&&UserChannelUtil.getChannel(packet.getAccepterId()+ PHONE_AGENT_NUM)!=null){
                packet.setMsg("📞 拒绝通话");
                ctx.channel().writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(packet)));
                packet.setSenderId(packet.getSenderId()- PHONE_AGENT_NUM);
                packet.setMsg("📞 未接电话");
            }
            //检查是否正在传输中
            if(packet.getMsg().equals("【请求发送文件】")&&UserChannelUtil.getChannel(packet.getAccepterId()+ File_AGENT_NUM)!=null){
                packet.setMsg("【拒绝文件请求】");
                ctx.channel().writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(packet)));
                packet.setSenderId(packet.getSenderId()- File_AGENT_NUM);
                packet.setMsg("【文件发送请求】未接收");
            }
            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(packet)));
        }
    }
    /**
     * 心跳包处理，实现心跳检测
     * @param ctx
     * @param frame
     */
    private void pingWebSocketFrameHandler(ChannelHandlerContext ctx, PingWebSocketFrame frame) {
        ctx.channel().writeAndFlush(new PongWebSocketFrame(frame.content().retain()));
    }

    /**
     * 异常捕获
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常发生了...");
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 握手时打印出握手包相关信息
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            log.info("web socket 握手成功。");
            WebSocketServerProtocolHandler.HandshakeComplete handshakeComplete = (WebSocketServerProtocolHandler.HandshakeComplete) evt;
            String requestUri = handshakeComplete.requestUri();
            log.info("requestUri:[{}]", requestUri);
            String subproTocol = handshakeComplete.selectedSubprotocol();
            log.info("subproTocol:[{}]", subproTocol);
            handshakeComplete.requestHeaders().forEach(entry -> log.info("header key:[{}] value:[{}]", entry.getKey(), entry.getValue()));
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

}
