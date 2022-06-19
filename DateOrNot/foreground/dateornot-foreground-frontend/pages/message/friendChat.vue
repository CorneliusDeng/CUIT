<template>
	<view class="body">
		<view class="status_bar"><!-- 状态栏 --></view>
		<!-- 自定义导航栏 -->
		<view class="status_title">
		    <image class="status_left" src="@/static/images/message/back.png" mode="widthFix" @tap="goToPage('/pages/message/messageList')"></image>
		    <view class="status_center">{{talkTo}}</view>
		    <image class="status_right" src="@/static/images/message/phone1.png" mode="widthFix" @click="viewTalk" :style="{display:this.groupChat?'none':'block'}" ></image>
			<view :style="{display:this.groupChat?'block':'none'}"></view>
			<image  class="file_icon" src="@/static/images/message/fileIcon.png" @click="onlineFileUp" :style="{display:this.groupChat?'none':'block'}"></image>	<!-- :style="{display:'none'}" -->
		</view>
		
		<!-- 可滑动滚动消息窗口 -->
		<scroll-view id="scrowV" class="chat" scroll-y="true" 
		:scroll-into-view="scrollToView" :scroll-top="scrollTop" 
		@scroll="scroll" @scrolltoupper="loadMsg"
		:scroll-anchoring="true">
			<view class="chat-main" :style="{paddingBottom:inputh+'px'}">
				<view class="chat-ls" v-for="(item,index) in msgs.slice(msgs.length-msgOutLen,msgs.length)" :key="index" :id="'msg'+index">
					<!-- 时间戳 -->
					<view class="chat-time" v-if="item.time !=''">
						{{changeTime(item.time)}}
					</view>
					<!-- 自己消息 -->
					<view class="msg-m msg-right" v-if="item.uid == selfId">
						<image :src="item.url" class="user-img"></image>
						<!-- 文字消息 -->
						<view class="massage" v-if="item.type=='text'||item.type=='phone'">
							<view class="msg-text">
								{{item.msg}}
							</view>
						</view>
						<!-- 语音消息 -->
						<view class="massage" v-if="item.type=='audio'">
							<view class="msg-audio" @click="previewAudio(item.msg)">
								<image style="transform: rotateY(180deg);" src="../../static/images/chatroom/voice4.png"></image>
								{{getAudioTime(item.msg)}}
							</view>		
						</view>
						<!-- 图片消息 -->
						<view class="massage" v-if="item.type=='picture'">
							<image :src="item.msg" class="msg-img" mode="widthFix"
								@tap="previewImg(item.msg)"></image>	
						</view>	
						<!-- 视频消息 -->
						<view class="massage" v-if="item.type=='video'">
							<a :id="'video'+index" :href='item.msg' style='text-decoration:none' class="video-img">
							<!-- {{videoPic(item.msg,'video'+index)}} -->
							<!-- <image  src="../../static/images/message/playVideo.png" class="video-icon" mode="widthFix"></image> -->
							<image src="../../static/images/message/video2.gif" class="video-img"></image>
							</a>
							<!-- <video :src="item.msg" class="video-img" ></video> -->
						</view>	
						<!-- 文件消息 -->
						<view class="massage" v-if="item.type=='file'">
							<!-- <a :href='item.msg' style='text-decoration:none'> -->
							<view class="msg-file"  @click="downloadFile(item.msg)">
								<image src="../../static/images/message/file2.png"></image>
								{{viewFile(item.msg)}}
							</view>
							<!-- </a> -->
						</view>
					</view>
					<!-- 对方消息 -->
					<view class="msg-m msg-left" v-if="item.uid != selfId">
						<image :src="item.url" class="user-img"></image>
						<view v-if="groupChat" class="group_uname">{{item.uname}}：</view>
						<!-- 文字消息 -->
						<view class="massage" v-if="item.type=='text'||item.type=='phone'">
							<view class="msg-text">
								{{item.msg}}
							</view>
						</view>
						<!-- 语音消息 -->
						<view class="massage" v-if="item.type=='audio'">
							<view class="msg-audio" @click="previewAudio(item.msg)">
								{{getAudioTime(item.msg)}}
								<image  src="../../static/images/chatroom/voice4.png"></image>
							</view>	
						</view>
						<!-- 图片消息 -->
						<view class="massage" v-if="item.type=='picture'">
							<image :src="item.msg" class="msg-img" mode="widthFix"
								@tap="previewImg(item.msg)"></image>
						</view>	
						<!-- 视频消息 -->
						<view class="massage" v-if="item.type=='video'">
							<a :id="'video'+index" :href='item.msg' style='text-decoration:none' class="video-img">
							<!-- {{videoPic(item.msg,'video'+index)}} -->
							<!-- <image :id="'icon'+index" src="../../static/images/message/playVideo.png" class="video-icon" mode="widthFix"></image> -->
							<image src="../../static/images/message/video2.gif" class="video-img"></image>
							</a>
							<!-- <video :src="item.msg" class="video-img" ></video> -->
						</view>
						<!-- 文件消息 -->
						<view class="massage" v-if="item.type=='file'">
							<!-- <a :href='item.msg' style='text-decoration:none'> -->
							<view class="msg-file" @click="downloadFile(item.msg)">
								{{viewFile(item.msg)}}
								<image src="../../static/images/message/file2.png"></image>
							</view>
							<!-- </a> -->
						</view>
					</view>
				</view>
			</view>
			<!-- 键盘弹出时上滚空出键盘显示区 -->
			<view style="height: env(safe-area-inset-bottom);width: 100%;"></view>
		</scroll-view>
		<!-- 输入框和功能栏 -->
		<submit @inputs="inputs" @heights="heights"></submit>
	</view>
</template>

<script>
	import {mapState,mapMutations} from 'vuex';
	import { localStorage } from '@/commons/mp-storage/mp-storage/index.js';
	import datas from '@/commons/js/datas.js';
	import time from '@/commons/js/time.js';
	import submit from 'components/submit/submit.vue';
	export default {
		data() {
			return {
				allMsgs:'',		//用户数据
				record:'',		//消息记录对象
				msgOutLen:20,   //显示的消息条数
				refreshing:false,	//列表是否在刷新中
				newHeight:0,	//当前滚动条高度
				scrollTop:0,	//当前滚动条离顶端距离
				oldSt:0,     	//刷新前滚动条离顶端距离
				groupChat:false,//是否是群消息
				talkTo:"张彪",	//聊天对象name
				accepterId:'',	//聊天对象id
				selfId:'',		//自己id
				selfName:'',	//自己name
				selfUrl:'',		//自己头像
				msgs:[],		//处理后用于打印的消息列表
				imgMsg: [],		//图片消息，用于预览
				scrollToView: '',	//最新消息id，用于跳转
				oldTime: new Date(),	//上一条消息时间
				inputh:'60',		//消息框上弹距离
			}
		},
		onLoad(option) {	//初始化页面数据
			if(!this.$websocket.getters.uid||!option.id){
				this.goToPage("/pages/user/login/login");
			}
			this.groupChat = option.id>=1000000?true:false;
			this.$websocket.dispatch('init');
			this.$nextTick(function(){
				this.$websocket.dispatch('webSocketInit');
			})
			this.chatInit(option);
		},
		onHide() {
			//将消息列表小红点清零
			console.log("消息列表小红点清零");
			this.$websocket.dispatch('clearTip',this.accepterId);
		},
		onBackPress(e) {
			//将消息列表小红点清零
			console.log("消息列表小红点清零");
			this.$websocket.dispatch('clearTip',this.accepterId);
			this.goToPage('/pages/message/friendChat?id='+this.selfId);
			return true
		},
		components:{
			submit,
		},
		computed:{
			msgChange:{	//监听新消息，实时刷新
				get:function(){
					return JSON.stringify(this.$websocket.state.userMsg);
				}
			} 
		},
		watch:{
			msgChange:{	//刷新消息记录
				handler(newValue){
					this.record = JSON.parse(newValue).msgDetail[this.accepterId];
					console.log("聊天界面消息记录已更新");
					this.getMsg();
				},
				deep:true
			}
		},
		methods: {
			//页面跳转
			goToPage(url) {
				if (!url) return;
				console.log("消息列表小红点清零");
				this.$websocket.dispatch('clearTip',this.accepterId);
				uni.switchTab({url});
			},
			//处理时间
			changeTime: function(date) {		
				return time.datetime1(date);
			},
			//页面初始化
			chatInit:function(option){
				this.selfId = this.$websocket.getters.uid;
				console.log(this.selfId);
				this.accepterId = option.id;
				this.allMsgs = JSON.parse(this.$websocket.getters.socketMsgs) ;
				this.selfUrl = this.allMsgs.url;
				this.selfName = this.allMsgs.name;
				if(this.accepterId in this.allMsgs.msgDetail){
					//已有聊天记录则获取
					this.record = this.allMsgs.msgDetail[this.accepterId];
				}else{
					//没有则新建
					let detail = {
						"id": this.accepterId,
						"name": this.selfName,
						"url": this.selfUrl,
						"msgs":[]
					};
					this.allMsgs.msgDetail[this.accepterId]= detail;
				}
				this.msgOutLen = 20;
				this.talkTo = this.record.name;
				console.log("talkTo:"+this.talkTo+",id:"+this.accepterId);
				this.getMsg();
			},
			//获取聊天数据
			getMsg: function() {
				this.msgs.length=0;	//本地消息数组清空
				this.imgMsg.length=0;
				let msg = JSON.parse(JSON.stringify(this.record.msgs)) ;	//深拷贝
				for (var i = 0; i < msg.length; i++) {
					//时间间隔
					if (i < msg.length - 1) {
						let t = time.spacTime(this.oldTime, msg[i].time);
						if (t) {
							this.oldTime = t;
						}
						msg[i].time = t;
					}
					//保存图片路径
					if (msg[i].type == "picture") {
						this.imgMsg.unshift(msg[i].msg);
					}
					this.msgs.unshift(msg[i]);
				}
				//实现异步跳转
				this.$nextTick(function() {
					this.scrollToView = 'msg' + (this.msgOutLen - 1);
				})
				this.oldTime=new Date();
				// console.log(this.msgs);
			},
			//预览图片
			previewImg: function(e) {
				let index = 0;
				for (let i = 0; i < this.imgMsg.length; i++) {
					if (this.imgMsg[i] == e) {
						index = i;
					}
				}
				uni.previewImage({
					current: index,
					urls: this.imgMsg,
					longPressActions: {  
						itemList: ['保存图片'],  
						success: function(ress) {
							uni.downloadFile({
						 		url: this.imgMsg,
								success: (res) =>{
									if (res.statusCode === 200){
									 	uni.saveImageToPhotosAlbum({
									 		filePath: res.tempFilePath,
									 		success: function() {
									 			//uniapp提供的消息提示框。
									 			uni.showToast({
									 				title: "保存成功",
									 				icon: "success"
									 			});
									 		},
											fail: function() {
									 			uni.showToast({
									 			title: "保存失败，请稍后重试",
									 			icon: "none"
												});
									 		}
										});
								 	}
								}
							})
								},  
								fail: function(res) {  
									console.log(res.errMsg);  
								}  
							}  
			
				});
			},
			//语音播放
			previewAudio:function(url){
				//利用uniapp自带组件完成播放
				let innerAudioContext = uni.createInnerAudioContext();
				innerAudioContext.autoplay =true;
				innerAudioContext.src = url;
				innerAudioContext.play();
				innerAudioContext.onPlay(() => {
				  console.log('播放语音');
				});
				innerAudioContext.onError((res) => {
				  console.log(res.errMsg);
				  console.log(res.errCode);
				});
			},
			//获取语音时长
			getAudioTime:function(url){
				let arr = url.split("$");
				arr = arr[1];
				if(arr!=null){
					return arr+" S";
				}else{
					return "2.355 S";
				}
				
			},
			//文件消息显示处理
			viewFile:function(e) {
				const lastFlag = e.lastIndexOf('$');
				return '[文件] '+e.substring(lastFlag+1)
			},			
			//文件下载
			downloadFile:function(e){
				console.log(e);
				if(uni.getSystemInfoSync().platform == 'android'){
					console.log(uni.getSystemInfoSync().platform)
					uni.downloadFile({
							url: e,//下载地址接口返回
							success: (data) => {
								if (data.statusCode === 200) {
									console.log(data.tempFilePath)
									//文件保存到本地
									uni.saveFile({
										tempFilePath: data.tempFilePath, //临时路径
										success: function(res) {
											// uni.showToast({
											// 	icon: 'none',
											// 	mask: true,
											// 	title: '文件已保存：' + res.savedFilePath, //保存路径
											// 	duration: 1000,
											// });
											// setTimeout(() => {
												//打开文档查看
												uni.openDocument({
													filePath: res.savedFilePath,
													success: function(res) {
														console.log('打开文档成功');
													}
												});
											// }, 1000)
										},
										fail: (err) => {
											console.log(err);
										}
									});
								}
							},
							fail: (err) => {
								console.log(err);
								uni.showToast({
									icon: 'none',
									mask: true,
									title: '下载失败请重新下载',
								});
							},
						});
				}else{
					window.open(e);
				}
			},
			//接收输入数据
			inputs: function(e) {
				let data = {
					senderId: this.selfId, //用户id
					senderName: this.selfName,
					senderUrl: this.selfUrl,
					accepterId: this.accepterId,
					msg: e.msg,
					isGroupChat: this.groupChat,
					type: e.type,
					time: new Date(),
				};
				this.goBottom();
				this.sendMessage(data);
			},
			//输入框高度
			heights: function(e) {
				this.inputh = e;
				this.goBottom();
			},
			//滚动到底部
			goBottom: function() {
				this.scrollToView = '';
				this.$nextTick(function() {
					let len = this.msgOutLen - 1;
					this.scrollToView = 'msg' + len;
				})
			},
			//消息懒加载
			loadMsg:function(e){
				if(this.refreshing){
					return;
				}else{
					let that = this;
					uni.showLoading({
					    title: '加载中'
					});
					this.refreshing = true;
					setTimeout(()=>{
						if(this.msgOutLen<this.msgs.length){
							//刷新数据
							this.msgOutLen = this.msgOutLen + 10;
						}
						if(this.msgOutLen>this.msgs.length){
							//刷新完毕
							this.msgOutLen = this.msgs.length;
						}
						this.scrollTop = this.oldSt;
						this.$nextTick(function(){
							let query = uni.createSelectorQuery();
							query.select('#scrowV').scrollOffset();
							query.exec(function(data){
								that.scrollTop = data[0].scrollHeight - that.newHeight;
							})
							this.refreshing = false;
							setTimeout(()=>{
								uni.hideLoading();
							},100)
						})
					},1000)
				}
			},
			//记录当前滚动高度
			scroll:function(e){
				this.newHeight = e.detail.scrollHeight - e.detail.scrollTop;
				this.oldSt = e.detail.scrollTop;
			},
			//建立websocket连接
			WebSocketInit(){
				//防止重复连接
				if(this.socketIsOpen){return}
				//调用函数连接websocket
				this.socketTask = uni.connectSocket({
					url:this.socketUrl,
					success(data) {}
				});
				
				this.socketTask.onOpen(()=>{
					console.log("websocket已连接");
					this.socketIsOpen = true;
				});
				
				//监听关闭
				this.socketTask.onClose(()=>{
					console.log("连接已关闭");
					this.socketIsOpen = false;
				});
				
				//监听错误
				this.socketTask.onError(()=>{
					console.log("出错了");
					this.socketIsOpen = false;
				});
				
				//监听消息
				this.socketTask.onMessage((e)=>{
					console.log("收到消息",e);
					// this.message = e.data;
					let len = this.msgs.length;
					let data = {
						id: 'xxx', //用户id
						imgurl: 'https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/abiao.jpg',
						message: e.data,
						types: "text",
						time: new Date(),
						tip: len,
					};
					this.msgs.push(data);
					this.goBottom();
				});
			},
			//发送消息
			sendMessage(mes){
				console.log("发送消息:"+JSON.stringify(mes));
				this.$websocket.dispatch('webSocketSend', mes);
			},
			//开启视频通话
			viewTalk:function(){
				let that = this;
				
				let param = 'type=answer&accepter='+this.accepterId+'&uid='+this.selfId+'&uname='+this.selfName+'&headUrl='+this.selfUrl;
				if(uni.getSystemInfoSync().platform == 'android'){
					plus.android.requestPermissions(['android.permission.CAMERA','android.permission.RECORD_AUDIO'], function(e){
						if(e.deniedAlways.length>0){    //权限被永久拒绝
					        // 弹出提示框解释为何需要权限，引导用户打开设置页面开启
					        console.log('权限被永久拒绝'+e.deniedAlways.toString());      
					    }  
					    if(e.deniedPresent.length>0){   //权限被临时拒绝
					        // 弹出提示框解释为何需要权限，可再次调用plus.android.requestPermissions申请权限  
					        console.log('权限被临时拒绝'+e.deniedPresent.toString());  
					    }  
					    if(e.granted.length>0){ //权限被允许 
							uni.navigateTo({url:'/pages/message/p2pTalking?' + param})
					        console.log('权限被允许'+e.granted.toString());  
					    }      
					}, function(e){
					         console.log('Request Permissions error:'+JSON.stringify(e));  
					});  
				}
				
				
				// var ms = {
				// 	type: 'phone',
				// 	msg:'📞 视频通话',
				// };
				// this.inputs(ms);
			},
			//在线文件传输
			onlineFileUp:function(){
				let param = 'type=answer&accepter='+this.accepterId+'&uid='+this.selfId+'&uname='+this.selfName+'&headUrl='+this.selfUrl;
				this.goToPage('/pages/message/fileTransform?' + param);
			},
			//获取视频第一帧作为封面
			// videoPic:function(url,that){
			// 	// 创建视频对象
			// 	let video = document.createElement('video');
			// 	video.setAttribute('crossOrigin','Anonymous');//跨域
			// 	video.setAttribute('controls', 'controls');	//js操作
			// 	video.setAttribute('autoplay', 'autoplay');	//自动播放
			// 	video.volume=0;	//静音
			// 	video.setAttribute('src', url); // 视频的链接
			// 	video.addEventListener('loadeddata', function(){
			// 		captureImage();
			// 	})
			// 	var captureImage = function() {
			// 		// 创建canvas画布
			// 		let canvas = document.createElement('canvas');
			// 		canvas.width = video.videoWidth*0.3;  // 设置画布的长宽也就是图片的长宽
			// 		canvas.height = video.videoHeight*0.3;
			// 		//使用画布画出图片
			// 		canvas.getContext('2d').drawImage(video, 0, 0, canvas.width, canvas.height);
			// 		let img = document.createElement('img');
			// 		img.setAttribute('crossOrigin', 'Anonymous');
			// 		img.src = canvas.toDataURL('image/png');
					
			// 		let output = document.getElementById(that);
			// 		if(output.children.length<2){
			// 			if(img.src.length<=100){
			// 				img.src = "../../static/images/message/video2.gif";
			// 				img.className='video-img';
			// 				output.removeChild(output.children[0]);
			// 			}
			// 			output.appendChild(img);
			// 			console.log(img);
			// 		}
					
			// 	};
			// 	video.load();
			// },
		}
	}
</script>

<style lang="scss">
page {
	height: 100%;
	}
//页面全局设置
.body{
	height: 100%;
	background: rgba(244, 244, 244, 1);
}
.status_bar {
    height: var(--status-bar-height);
    width: 100%;      
}
 
/* 自定义导航栏 */
.status_title {
	background: rgba(244, 244, 244, $alpha: 0.96);
	border-bottom: 1rpx solid $uni-border-color;
    box-sizing: border-box;
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;
    height: 44px;
    padding: 0 16px;
	
	.status_left {
	    width: 22px !important;
		font-size: 18px;
		font-weight: 700;
	}
	.status_center {
	    font-size: 18px;
	    font-weight: 700;
	}
	.status_right {
	    width: 22px;
	}
	.file_icon{
		position: absolute;
		width: 30px;
		height: 30px;
		margin-left: 76%;
	}
}


.chat{
	height: 90%;
	overflow-anchor: inherit;
	.chat-time {
		font-size: $uni-font-size-sm;
		color: rgba(39, 40, 50, 0.3);
		line-height: 34rpx;
		padding: 20rpx 0;
		text-align: center;
	}
	
	.chat-main {
		padding-left: $uni-spacing-col-base;
		padding-right: $uni-spacing-col-base;
		padding-top: 10rpx;
		display: flex;
		flex-direction: column;
	}
	.chat-ls {
		.msg-m {
			display: flex;
			padding: 20rpx 10rpx;
			word-break: break-all;
			
			.user-img {
				flex: none;
				width: $uni-img-size-sm;
				height: $uni-img-size-sm;
				border-radius: $uni-border-radius-base;
			}
		
			.massage {
				flex: none;
				max-width: 480rpx;
			}
		
			.msg-text {
				font-size: $uni-font-size-lg;
				color: $uni-text-color;
				line-height: 44rpx;
				padding: 18rpx 24rpx;
			}
			.msg-audio{
				font-size: $uni-font-size-lg;
				color: $uni-text-color;
				line-height: 44rpx;
				width:215rpx;
			}
		
			.msg-img {
				max-width: 400rpx;
				border-radius: $uni-border-radius-base;
			}
			
			.video-img{
				max-width: 250rpx;
				max-height: 180rpx;
			}
			
			.video-icon{
				position:absolute;
				width:10%;
				margin:18%;
				margin-top:35%;
				opacity: 0.6 ;
			}
		}
		
		.msg-left {
			flex-direction: row;
		
			.msg-text {
				margin-left: 12rpx;
				background-color: #fff;
				border-radius: 35rpx;
			}
		
			.msg-img {
				margin-left: 12rpx;
			}
			
			.video-img{
				margin-left: 12rpx;
			}
			
			.msg-file{
				display: flex;
				align-items: center;
				margin-left: 12rpx;
				background-color: #ffffff;
				color: #000000;
				border-radius: 35rpx;
				overflow:hidden;
				image{
					flex: none;
					margin: 10rpx;
					width: 80rpx; 
					height: 90rpx;
				}
			}
			.msg-audio{
				display: flex;
				align-items: center;
				margin-left: 12rpx;
				background-color: #ffffff;
				color: #000000;
				border-radius: 35rpx;
				padding-left: 20rpx;
				width:195rpx;
				image{
					flex: none;
					margin: 10rpx;
					width: 60rpx; 
					height: 60rpx;
				}
			}
			.group_uname{
				flex: none;
				color:#00aa7f;
				position: absolute;
				padding-left: 95rpx;
				margin-top: -25rpx;
				font-size: 30rpx;
				z-index: 999;
			}
		}
		
		.msg-right {
			flex-direction: row-reverse;
		
			.msg-text {
				margin-right: 12rpx;
				background-color: #aaaaff;
				color: #FFFFFF;
				border-radius: 35rpx;
			}
		
			.msg-img {
				margin-right: 12rpx;
				max-width: 300rpx;
			}
			
			.video-img{
				margin-right: 12rpx;
			}
			
			.msg-file{
				display: flex;
				align-items: center;
				margin-right: 12rpx;
				background-color: #ffffff;
				color: #000000;
				border-radius: 35rpx;
				overflow:hidden;
				image{
					flex: none;
					margin: 10rpx;
					width: 80rpx; 
					height: 90rpx;
				}
			}
			.msg-audio{
				display: flex;
				align-items: center;
				margin-right: 12rpx;
				background-color: #aaaaff;
				color: #FFFFFF;
				border-radius: 35rpx;
				image{
					flex: none;
					margin: 10rpx;
					width: 60rpx; 
					height: 60rpx;
				}
			}
		}
	}
}

</style>
 -->