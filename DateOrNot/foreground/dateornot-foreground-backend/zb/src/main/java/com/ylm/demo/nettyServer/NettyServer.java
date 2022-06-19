package com.ylm.demo.nettyServer;


import com.ylm.demo.service.GroupUserService;
import com.ylm.demo.service.OfMsgService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * 服务端
 */
@Slf4j
@Component
public class NettyServer {

    @Autowired
    @Qualifier("GroupUserServiceImpl")
    private GroupUserService groupUserService;
    @Autowired
    @Qualifier("OfMsgServiceImpl")
    private OfMsgService msgService;
    //NioEventLoopGroup是用来处理IO操作的多线程事件循环器
    //boss用来接收进来的连接
    private final EventLoopGroup bossGroup = new NioEventLoopGroup();

    //用来处理已经被接收的连接;
    private final EventLoopGroup workerGroup = new NioEventLoopGroup();

    private Channel channel;

    /**
     * 启动服务端
     * @param hostname
     * @param port
     * @return
     * @throws Exception
     */
    public ChannelFuture start(String hostname, int port) throws Exception{
        ChannelFuture future = null;
        try{
            //启动NIO服务的辅助启动类
            ServerBootstrap sBootstrap = new ServerBootstrap();
            //These EventLoopGroup's are used to handle all the events and IO for ServerChannel and Channel's.
            //为bootstrap设置acceptor的EventLoopGroup和client的EventLoopGroup
            //这些EventLoopGroups用于处理所有的IO事件
            sBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(hostname,port))
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();

                            //websocket协议本身是基于http协议的，使用http解编码器
                            ch.pipeline().addLast("http-codec",new HttpServerCodec());

                            //是以块方式写，添加ChunkedWriteHandler处理器
                            ch.pipeline().addLast("http-chunked",new ChunkedWriteHandler());//用于大数据的分区传输

                            //聚合器，http数据在传输过程中是分段, HttpObjectAggregator可以将多个段聚合
                            ch.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));

                            //自定义业务handler，处理业务逻辑
                            ch.pipeline().addLast("my-handler", new MyWebSocketHandler(msgService,groupUserService));

                            //WebSocketServerProtocolHandler 核心功能是将 http协议升级为 ws协议 , 保持长连接
                            //浏览器请求时 ws://xxxx:8081/ws+表示请求的uri
                            ch.pipeline().addLast(new WebSocketServerProtocolHandler("/ws", null, true, 65536 * 10));

                            log.info("SimpleChatClient:" + ch.remoteAddress()+"连接上服务器");
                        }
                    });

            log.info("SimpleChatServer 启动了");

            //绑定端口,开始接收进来的连接
            future = sBootstrap.bind().sync();
            //future.channel().closeFuture().sync();
            channel = future.channel();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (future != null && future.isSuccess()) {
                log.info("Netty server listening " + hostname + " on port " + port + " and ready for connections...");
            } else {
                log.error("Netty server start up Error!");
            }
        }
        return future;
    }

    /**
     * 关闭服务端
     */
    public void destroy(){
        log.info("Shutdown Server...");
        if(channel != null) { channel.close();}
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
        log.info("Shutdown GroupChat Server Success!");
    }

}