import Vue from 'vue'
import Vuex from 'vuex'
import { localStorage, sessionStorage} from '@/commons/mp-storage/mp-storage/index.js'
 
Vue.use(Vuex)
 
export default new Vuex.Store({
	state: {
		socketTask: null, // ws对象
		webSocketPingTimer: null, // 心跳定时器
		webSocketPingTime: 1000, // 心跳的间隔ms，当前为 1秒,
		webSocketReconnectCount: 0, // 重连次数  
		webSocketIsReconnect: true, // 是否重连
		webSocketIsOpen: false,	
		url:"ws://119.23.49.121:8081/ws?uid=",	//服务器url+uri
		uid: null,	//ws登录userId
		userMsg: null, //用户的信息缓存
		accepter:null,	//聊天对象
		talkOnVideo:'param',
		fileOnlineParam:'param',
	},
	getters: {
		// 获取接收的信息
		socketMsgs: state => {
			return JSON.stringify(state.userMsg)
		},
		//获取连接状况
		webSocketIsOpen: state => {
			return state.webSocketIsOpen
		},
		//获取用户id
		uid:state => {
			return state.uid!=null?state.uid:sessionStorage.getItem('uid')
		}
	},
	mutations: {
		init(state){
			let that = this;
			state.talkOnVideo='param';
			state.socketTask= null; // ws对象
			state.fileOnlineParam='param';
			state.webSocketPingTimer= null; // 心跳定时器
			state.webSocketPingTime= 1000; // 心跳的间隔ms，当前为 1秒,
			state.webSocketReconnectCount= 0; // 重连次数  
			state.webSocketIsReconnect= true;// 是否重连
			state.webSocketIsOpen= false;
			state.uid= sessionStorage.getItem('uid')||null;	//ws登录userId
			state.accepter=sessionStorage.getItem('accepter')!=null ? JSON.parse(sessionStorage.getItem('accepter')):null;	//聊天对象
		
			let temp = sessionStorage.getItem('uid')||null;
			temp = localStorage.getItem(temp)||null;
			state.userMsg = temp==null?null:JSON.parse(temp); //用户的信息缓存
			
			// if(!state.webSocketIsOpen){
			// 	that.commit('webSocketInit');
			// }
			
		},
		
		//设置用户id 用于ws登录和获取缓存数据
		setUid(state, uid) {
			state.uid = uid;
			let temp = localStorage.getItem(uid.toString())||null;
			if(temp!=null){
				var user = JSON.parse(sessionStorage.getItem('user'));
				state.userMsg = JSON.parse(localStorage.getItem(uid.toString()))||null;
				state.userMsg.name = user.uname;
				state.userMsg.url = user.headUrl;
				localStorage.setItem(state.uid.toString(),JSON.stringify(state.userMsg));
			}else{//首次登陆
				var user = JSON.parse(sessionStorage.getItem('user'));
				console.log("登录用户：" + JSON.stringify(user));
				state.userMsg = {
					"userID": user.uid,
					"name": user.uname,
					"url": user.headUrl,
					"msgList": {},
					"msgDetail": {}
				};
				localStorage.setItem(state.uid.toString(),JSON.stringify(state.userMsg));
			}
			
		},
		
		//设置聊天对象状态并新增消息记录
		setAccepter(state, accepter){
			state.accepter = accepter;
			sessionStorage.setItem('accepter',JSON.stringify(accepter));
			if(state.userMsg.msgList[accepter.id]!=null){
				return;
			}else{
				let helloMsg={
					senderId: this.state.userMsg.userID, //用户id
					senderName: this.state.userMsg.name,
					senderUrl: this.state.userMsg.url,
					accepterId: this.state.accepter.id,
					msg: "你好,我是"+this.state.userMsg.name,
					isGroupChat: this.state.accepter.id>1000000? true:false,
					type: "text",
					time: new Date(),
				}
				console.log(helloMsg);
				this.commit('webSocketSend', helloMsg);
			}
		},
		
		//更新用户消息
		setUserMsg(state,userMsg){
			state.userMsg = userMsg;
			localStorage.setItem(state.uid,JSON.stringify(state.userMsg));
		},
		
		//消息记录小红点清零
		clearTip(state,id){
			state.userMsg.msgList[id].tip = 0;
			localStorage.setItem(state.uid.toString(),JSON.stringify(state.userMsg));
		},
		
		//初始化ws 用户登录后调用
		webSocketInit(state) {
			let that = this
			if(!state.webSocketIsOpen){
				that.state.webSocketIsOpen = true;
				console.log("申请websocket连接...");
				// 创建一个this.socketTask对象,后续工作都由该对象操作
				state.socketTask = uni.connectSocket({
					url: state.url+state.uid,
					success(data) {
						// console.log("websocket连接成功");
					},
					fail:res=>{
						that.state.webSocketIsOpen = false;
					}
				});
			}
			// ws连接开启后调用
			state.socketTask.onOpen((res) => {
				// uni.showToast({
				// 	icon:'none',
				// 	mask: true,
				// 	title: "服务器已连接"
				// });
				console.log("WebSocket连接成功！");
				console.log("WebSocket连接正常打开中...！");
				that.state.webSocketIsOpen = true;
				// 接收消息处理
				state.socketTask.onMessage((res) => {
					console.log("收到服务器内容：" + res.data);
					let msg = JSON.parse(res.data);
					if(msg.accepterId==state.uid){
						//好友消息
						that.commit('friendChatMesIn',msg);
					}else{
						//群消息
						that.commit('groupChatMesIn',msg);
					}
				});
				// that.commit('webSocketLogin')	//调用登录验证
				that.commit('webSocketPing')	//开始心跳
			});
 
			// 错误监听
			state.socketTask.onError((errMsg) => {
				console.log(errMsg.data)
				console.log("ws连接异常")
				that.commit('webSocketClose')
			});
 
			// 关闭监听
			state.socketTask.onClose(() => {
				console.log("ws连接关闭")
				that.commit('webSocketClose')	//调用连接断开处理，重连
			});
 
		}, 
		//在线文件发送
		fileOnline(state, pos){
			let msg = JSON.parse(pos);
			
			uni.showModal({
				title: '文件传输申请',
				content: msg.senderName+'请求向你发送文件',
				cancelText: '拒绝',
				confirmText: '接收',
				success: res=>{
					if(res.confirm){
						console.log("接通文件发送路径");
						let rtcId = Number(state.userMsg.userID)+8000000;
						let param = 'type=offer&accepter='+msg.senderId+'&uid='+rtcId+'&uname='+msg.senderName+'&headUrl='+msg.senderUrl;						
						state.fileOnlineParam = param;
					}else{
						let data = {
							senderId: state.userMsg.userID, //用户id
							senderName: state.userMsg.name,
							senderUrl: state.userMsg.url,
							accepterId: msg.senderId,
							msg: "【拒绝文件请求】",
							isChat: false,
							type: msg.type,
							time: new Date(),
						};
						state.socketTask.send({data: JSON.stringify(data)});
						console.log(JSON.stringify(data));
					}
				},
			});
		},
		//视频通话处理
		viewTalk(state, pos){
			let msg = JSON.parse(pos);
			
			uni.showModal({
				title: '通话申请',
				content: msg.senderName+'请求与你开启视频通话',
				cancelText: '拒绝',
				confirmText: '接听',
				success: res=>{
					if(res.confirm){
						console.log("接通电话");
						let rtcId = Number(state.userMsg.userID)+7000000;
						let param = 'type=offer&accepter='+msg.senderId+'&uid='+rtcId+'&uname='+msg.senderName+'&headUrl='+msg.senderUrl;						
						state.talkOnVideo = param;
					}else{
						let data = {
							senderId: state.userMsg.userID, //用户id
							senderName: state.userMsg.name,
							senderUrl: state.userMsg.url,
							accepterId: msg.senderId,
							msg: "📞 拒绝通话",
							isChat: false,
							type: msg.type,
							time: new Date(),
						};
						state.socketTask.send({data: JSON.stringify(data)});
						console.log(JSON.stringify(data));
					}
				},
			});
			
		},
		
		//好友消息接收处理
		friendChatMesIn(state, msg){
			console.log("接收到新消息");
			let that = this;
			const flagP = 7000000;
			if(msg.type=='phone'&&Number(msg.senderId)>=flagP&&msg.msg=="📞 视频通话"){
				var newMsg = JSON.stringify(msg);
				that.commit('viewTalk',newMsg);
				msg.senderId = Number(msg.senderId)-flagP;
			}
			const flagF = 8000000;
			if(msg.type=='fileOnline'&&Number(msg.senderId)>=flagF&&msg.msg=="【请求发送文件】"){
				var newMsg = JSON.stringify(msg);
				that.commit('fileOnline',newMsg);
				msg.senderId = Number(msg.senderId)-flagF;
				return;
			}
			let data = {	//消息格式转化
				uid: msg.senderId,
				uname: msg.senderName,
				url: msg.senderUrl,
				msg: msg.msg,
				time: msg.time,
				type: msg.type,
			};
			if(msg.senderId in state.userMsg.msgDetail){
				//已存在消息记录则加入消息记录
				state.userMsg.msgDetail[msg.senderId].msgs.unshift(data);
			}else{
				//没有则新增记录
				let detail = {
					"id": msg.senderId,
					"name": msg.senderName,
					"url": msg.senderUrl,
					"msgs":[]
				};
				state.userMsg.msgDetail[msg.senderId] = detail;
				state.userMsg.msgDetail[msg.senderId].msgs.unshift(data);
			}
			//修改消息列表
			if(msg.senderId in state.userMsg.msgList){
				//已存在与列表中就更新记录
				state.userMsg.msgList[msg.senderId].news = msg.type=='text'? msg.msg:'['+msg.type+']';
				state.userMsg.msgList[msg.senderId].time = msg.time;
				state.userMsg.msgList[msg.senderId].tip++;
			}else{
				console.log("接收到陌生人新消息");
				//列表中没有则新增
				let msgL = {
					"id": msg.senderId,
					"name": msg.senderName,
					"url": msg.senderUrl,
					"news": msg.type=='text'? msg.msg:'['+msg.type+']',
					"time": msg.time,
					"tip": 1
				};
				state.userMsg.msgList[msg.senderId] = msgL;
			}
			localStorage.setItem(state.uid.toString(),JSON.stringify(state.userMsg));
			console.log("消息记录缓存已更新");
		},
		
		//群消息接收处理
		groupChatMesIn(state, msg){
			let data = {	//消息格式转化
				uid: msg.senderId,
				uname: msg.senderName,
				url: msg.senderUrl,
				msg: msg.msg,
				time: msg.time,
				type: msg.type,
			};
			if(msg.accepterId in state.userMsg.msgDetail){
				//已存在消息记录则加入消息记录
				state.userMsg.msgDetail[msg.accepterId].msgs.unshift(data);
			}
			//修改消息列表
			if(msg.accepterId in state.userMsg.msgList){
				//已存在与列表中就更新记录
				state.userMsg.msgList[msg.accepterId].news = msg.senderName+':'+ (msg.type=='text'? msg.msg:'['+msg.type+']');
				state.userMsg.msgList[msg.accepterId].time = msg.time;
				state.userMsg.msgList[msg.accepterId].tip++;
				//更新缓存
				localStorage.setItem(state.uid.toString(),JSON.stringify(state.userMsg));
				console.log("消息记录缓存已更新");
			}
		},
		
		//列表消息记录删除
		deleteMsgList(state, id){
			delete state.userMsg.msgList[id];
			delete state.userMsg.msgDetail[id];
			//更新缓存
			localStorage.setItem(state.uid.toString(),JSON.stringify(state.userMsg));
			console.log("消息记录缓存已更新");
		},
		//用户登录
		webSocketLogin() {
			let that = this
			
			console.log("ws登录");
			const payload = {
				uid: that.state.uid,
				type: 1
			};
			that.commit('webSocketSend', payload);
			that.state.webSocketIsOpen = true
		},
		
		// 连接断开处理（重连）
		webSocketClose(state) {
			let that = this
			// 修改状态为未连接
			state.webSocketIsOpen = false;
			state.webSocket = null;
			// 判断是否重连
			if (
				state.webSocketIsReconnect &&
				state.webSocketReconnectCount === 0
			) {
				// 第一次直接尝试重连
				that.commit('webSocketReconnect');
			}
		},
		
		// 定时发送心跳包
		webSocketPing() {
			let that = this
			if (!that.state.webSocketIsOpen) {
				return false;
			}
			const payload = {
				type: 0
			};
			// that.state.socketTask.send({data: JSON.stringify(payload)});
			that.commit('webSocketSend', payload);
			that.state.webSocketPingTimer = setTimeout(() => {
				clearTimeout(that.state.webSocketPingTimer);
				// 重新执行
				that.commit('webSocketPing');
			}, that.state.webSocketPingTime);
		},
		
		// WebSocket 重连
		webSocketReconnect(state) {
			let that = this
			if (state.webSocketIsOpen) {
				return false;
			}
			console.log("第"+state.webSocketReconnectCount+"次重连")
			state.webSocketReconnectCount += 1;
			// 判断是否到了最大重连次数 
			if (state.webSocketReconnectCount >= 10) {
				console.log("重连次数超限,重连失败！！");
			    return false;
			}
			// 初始化
			console.log("开始重连")
			that.commit('webSocketInit');
 
			// 每过 5 秒尝试一次，检查是否连接成功，直到超过最大重连次数
			let timer = setTimeout(() => {
				that.commit('webSocketReconnect');
				clearTimeout(timer);
			}, 5000);
		}, 
		
		// 发送ws消息
		webSocketSend(state, payload) {
			let that = this
			that.state.socketTask.send({
				data: JSON.stringify(payload),
				fail: function(res){
					// console.log("发送失败")
				},
				success: function(res){
					// console.log("发送成功")
				}
			});
			let msg = payload;
			if(payload.type==0){//心跳包
				return;
			}
			let data = {	//消息格式转化
				uid: msg.senderId,
				uname: msg.senderName,
				url: msg.senderUrl,
				msg: msg.msg,
				time: msg.time,
				type: msg.type,
			};
			if(msg.accepterId in state.userMsg.msgDetail){
				//已存在消息记录则加入消息记录
				state.userMsg.msgDetail[msg.accepterId].msgs.unshift(data);
			}else{
				//没有则新建消息记录
				let detail = {
					"id": state.accepter.id,
					"name": state.accepter.name,
					"url": state.accepter.url,
					"msgs":[]
				};
				state.userMsg.msgDetail[detail.id] = detail;
				state.userMsg.msgDetail[detail.id].msgs.unshift(data);
			}
			//修改消息列表
			if(msg.accepterId in state.userMsg.msgList){
				//已存在与列表中就更新记录
				state.userMsg.msgList[msg.accepterId].news = msg.type=='text'? msg.msg:'['+msg.type+']';
				state.userMsg.msgList[msg.accepterId].time = msg.time;
				state.userMsg.msgList[msg.accepterId].tip++;
			}else{
				//列表中没有则新增
				let msgL = {
					"id": state.accepter.id,
					"name": state.accepter.name,
					"url": state.accepter.url,
					"news": msg.type=='text'? msg.msg:'['+msg.type+']',
					"time": msg.time,
					"tip": 1
				};
				state.userMsg.msgList[msgL.id] = msgL;
			}
			localStorage.setItem(state.uid.toString(),JSON.stringify(state.userMsg));
			console.log("消息记录缓存已更新");
		}
	},
 
 
	actions: {
		webSocketInit({commit}) {
			commit('webSocketInit')
		},
		webSocketSend({commit}, p) {
			commit('webSocketSend', p)
		},
		userMsgChange({commit}, msg) {
			commit('setUserMsg', msg)
		},
		setAccepter({commit}, accepter){
			commit('setAccepter', accepter)
		},
		clearTip({commit},id){
			commit('clearTip',id)
		},
		init({commit}){
			commit('init')
		},
		deleteMsgList({commit},id){
			commit('deleteMsgList',id)
		}
	}
})
