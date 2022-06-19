<template name="submit">
	<view>
		<view class="submit">
			<view class="submit-chat">
				<view class="bt-img" @tap="records">
					<image :src="toc"></image>
				</view>
				<textarea auto-height="true" class="chat-send btn" :class="{displaynone:isrecord} " @input="myInputs" v-model="msg" @focus="myFocus" @blur="losFocus"></textarea>
				<view id="recordBtn" @touchstart="recordAction(this)" @touchend="recordEnd(this)" class="record btn" :class="{displaynone:!isrecord}" :style="{'background-color':recordBtnBackground}">按住说话</view>
				<view class="bt-emoji" @click="myEmoji">
					<image src="../../static/images/message/emoji1.png"></image>
				</view>
				<view class="bt-img" :class="{displaynone:isInput} " @tap="outMore">
					<image src="../../static/images/message/patch.png"></image>
				</view>
				<view class="bt-img" :class="{displaynone:!isInput} " @tap="send(msg,'text')">
					<image src="../../static/images/message/send.png"></image>
				</view>
			</view>
			<view class="emoji" :class="{displaynone:ismeoji}">
				<emoji @emotion="emotion" :height="260"></emoji>
			</view>
			<view class="more" :class="{displaynone:ismore}">
				<view class="more-list">
					<image @click="picUp('album')" src="../../static/images/chatroom/photo.png"></image>
					<view class="more-list-title">图片</view>
				</view>
				<view class="more-list">
					<image @click="picUp('camera')" src="../../static/images/chatroom/pz.png"></image>
					<view class="more-list-title">拍照</view>
				</view>
				<!-- <view class="more-list">
					<image src="../../static/images/chatroom/dw.png"></image>
					<view class="more-list-title">定位</view>
				</view> -->
				<view class="more-list">
					<image @click="videoUp" src="../../static/images/chatroom/sp.png"></image>
					<view class="more-list-title">视频</view>
				</view>
				<view class="more-list">
					<image @click="fileUp" src="../../static/images/chatroom/file.png"></image>
					<view class="more-list-title">文件</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import emoji from '../emoji/emoji.vue'
	import {pickFile} from '../../commons/js/pickFile.js' 
	export default {
		name:"submit",
		data() {
			return {
				isrecord:false,	//录音判断
				isInput:false, //输入判断
				recordManager:'',	//录音管理器
				toc:"../../static/images/message/voice.png",	//输入框左侧logo
				recordBtnBackground:'#ffffff',
				ismeoji:true,
				ismore:true,
				msg:'',
				url:'https://biaoweb.online:4443',		//服务器链接
			};
		},
		components:{
			emoji,
		},
		mounted() {
			// 录音管理器初始化
			this.recordManager = uni.getRecorderManager();
			console.log("录音管理器初始化成功");
			// 绑定回调方法
			this.recordManager.onStart((e) => this.onStart(e));
			this.recordManager.onError((e) => this.onError(e));
			
		},
		methods:{
			//获取模块数据
			getElementHeight: function() {
				const query = uni.createSelectorQuery().in(this);
				query.select('.submit').boundingClientRect(data => {
					this.$emit('heights',data.height);
				}).exec();
			},
			//点击切换音频
			records:function(){
				this.ismeoji=true;
				this.ismore=true;
				setTimeout(()=>{
					this.getElementHeight();
				},10)
				if(this.isrecord){
					this.isrecord=false;
					this.toc="../../static/images/message/voice.png"
				}else{
					this.isrecord=true;
					this.toc="../../static/images/message/keyboard.png";
				}
			},
			//语音录制操作
			recordAction:function() {
			    if (this.isrecord) {
					this.recordBtnBackground = '#aaaaff';
					// 设置格式为MP3，最长60S
					this.recordManager.start({
						duration: 60000,
						format: 'mp3',					
					})
					// 开始录音后绑定停止录音的回调方法
					this.recordManager.onStop((e) => this.onStop(e))  
			    }
			},
			//语音录制结束操作
			recordEnd:function(){
				this.recordManager.stop();
				this.recordBtnBackground = '#ffffff';
			},
			//录音开始事件
			onStart:function(e){
				console.log("开始录音");
			},
			//录音结束事件
			onStop:function(e){
				console.log("录音结束,file:",e.tempFilePath);
				let that = this;
				let audioTime = 3.55;
				let innerAudioContext = uni.createInnerAudioContext();
				innerAudioContext.autoplay =true;
				innerAudioContext.src = e.tempFilePath;
				// innerAudioContext.play();
				innerAudioContext.onCanplay(()=>{
					innerAudioContext.duration;
					setTimeout(()=>{
						audioTime = innerAudioContext.duration;
						console.log(audioTime);
						//文件上传并发送
						if(e.tempFilePath!=null){
							//上传
							const uper=uni.uploadFile({
								url: that.url+'/upload/audio',
								filePath:e.tempFilePath,
								name:'audio',
								formData:{
									'audioTime':audioTime
								}, 
								sslVerify: false,
								success:function(e){	//上传完毕就发送
									let result = JSON.parse(e.data);
									that.send(result.response,"audio");
								},
								fail: res =>{
									console.log(JSON.stringify(res) );
									uni.showToast({
										icon: 'none',
										mask: true,
										title: '发送失败,请检查网络',
									});
								}
							})
						}
					},10)
				})
				console.log(audioTime);
				
			},
			//展开表情
			myEmoji:function(){
				this.ismeoji=!this.ismeoji;
				this.ismore=true;
				this.isInput=false;
				setTimeout(()=>{
					this.getElementHeight();
				},10)
			},
			//接收表情
			emotion:function(e){
				this.msg=this.msg+e;
				this.isInput=true;
			},
			//文字发送
			myInputs:function(e){
				var chatm=e.detail.value;
				var pos=chatm.indexOf('\n');
				var pos1=chatm.lastIndexOf('\n',1);
				if(pos!=-1 && chatm.length>1 &&pos1==-1){
					this.send(this.msg,"text");
				}
			},
			//聚焦
			myFocus:function(){
				this.isInput=true;
				this.ismeoji=true;
				setTimeout(()=>{
					this.getElementHeight();
				},10)
			},
			//失去聚焦
			losFocus:function(){
				setTimeout(()=>{
					this.isInput=false;
				},10)
			},
			//弹出功能框
			outMore:function(){
				this.ismeoji=true;
				this.ismore=!this.ismore;
				setTimeout(()=>{
					this.getElementHeight();
				},10)
			},
			//文件发送
			fileUp:function(){
				let that = this;
				if(uni.getSystemInfoSync().platform == 'android'){
					let fileUrl;
					//打开android文件管理器
					pickFile.PickFile(function(src){
						if(src!=null){
							that.fileUrl = src; 
						}
					});
					//上传
					const uper=uni.uploadFile({
						url: that.url+'/upload/file',
						filePath:that.fileUrl,
						name:'file',
						sslVerify: false,
						success:function(e){	//上传完毕就发送
							console.log(e)
							let result = JSON.parse(e.data);
							that.send(result.response,"file");
							uni.showToast({
								mask: true,
								title: '发送成功',
							});
						},
						fail: res =>{
							console.log(res.message);
							uni.showToast({
								icon: 'none',
								mask: true,
								title: '发送失败，请检查网络连接',
							});
						}
					})
				}else{
					console.log("uni.chooseFile");
					//换种方式选择文件
					uni.chooseFile({
						count: 1,
						success: res => {
							console.log(res);
							//获取到的文件路径
							const filePaths = res.tempFilePaths;
							//上传
							const uper=uni.uploadFile({
								url: that.url+'/upload/file',
								filePath:filePaths[0],
								name:'file',
								success:function(e){	//上传完毕就发送
									let result = JSON.parse(e.data);
									that.send(result.response,"file");
									uni.showToast({
										mask: true,
										title: '发送成功',
									});
								},
								fail: res =>{
									console.log(JSON.stringify(res) );
									uni.showToast({
										icon: 'none',
										mask: true,
										title: '发送失败，请检查网络连接',
									});
								}
							})
						},
					})
				}
				 
			},
			//图片发送
			picUp:function(type){
				let that = this;
				 //选择照片
				uni.chooseImage({
					count:1,
					sizeType:'compressed',	//压缩图片
					sourceType: [type], //从相册选择
					success: res => {
						const imgsFile=res.tempFilePaths;
						console.log(imgsFile);
						//上传
						const uper=uni.uploadFile({
							url: that.url+'/upload/msgPicture',
							filePath:imgsFile[0],
							name:'picture',
							success:function(e){	//上传完毕就发送
								let result = JSON.parse(e.data);
								that.send(result.response,"picture");
								uni.showToast({
									mask: true,
									title: '发送成功',
								});
							},
							fail: res =>{
								console.log(res.errMsg);
								uni.showToast({
									icon: 'none',
									mask: true,
									title: '发送失败，请检查网络连接',
								});
							}
						})
					}
				})
			},
			//视频发送
			videoUp:function(){
				let that = this;
				 //选择视频
				uni.chooseVideo({
					count:1,
					compressed:true,	//压缩视频
					sourceType: ['album'], //从相册选择
					success: res => {
						const videoFile=res.tempFilePath
						//上传
						const uper=uni.uploadFile({
							url: that.url+'/upload/video',
							filePath:videoFile,
							name:'video',
							success:function(e){	//上传完毕就发送
								let result = JSON.parse(e.data);
								that.send(result.response,"video");
								uni.showToast({
									mask: true,
									title: '发送成功',
								});
							},
							fail: res =>{
								console.log(res.errMsg);
								uni.showToast({
									icon: 'none',
									mask: true,
									title: '发送失败，请检查网络连接',
								});
							}
						})
					}
				})
			},
			//消息发送
			send:function(msg,type){
				let data={
					msg:msg,
					type:type,
				};
				this.$emit('inputs',data);
				setTimeout(()=>{
					this.msg='';
					// this.isInput=false;
				},0)
			}
		},
		props:{},
	}
</script>

<style lang="scss">
	.submit{
		background: rgba(244,244,244,0.96);
		width: 100%;
		position: fixed;
		bottom: 0;
		z-index: 100;
		padding-bottom: env(safe-area-inset-bottom);
	}
	.displaynone{
		display: none;
	}
	.submit-chat{
		width: 100%;
		display: flex;
		align-items: flex-end;
		box-sizing: border-box;
		padding: 14rpx 14rpx;
		image{
			width: 70rpx ;
			height: 70rpx;
			margin: 0 10rpx;
			flex: auto;
		}
		.bt-emoji{
			position: absolute;
			margin-left: 72%;
			opacity: 0.7 ;
			z-index: 100;
		}
		.btn{
			flex:auto;
			background-color: #fff;
			border-radius: 50rpx;
			padding: 20rpx;
			max-height: 160rpx;
			margin: 0 10rpx;
			}
		.chat-send{
			line-height: 44rpx;
			height: 10rpx;
		}
		.record{
			line-height: 44rpx;
			text-align: center;
			font-size: $uni-font-size-lg;
			color: $uni-text-color-grey;
		}
	}
	.emoji{
		width: 100%;
		height: 460rpx;
		background: rgba(236,237,238,1);
		box-shadow: 0px -1rpx 0px 0px rgba(0,0,0,0.1);
		.emoji-send{
			width: 280rpx;
			height: 104rpx;
			padding-top: 24rpx;
			background-color: #999;
			background-color: rgba(236,237,238,0.9);
			position: fixed;
			bottom:50rpx;
			right: 0;
			display: flex;
		}
	}
	.more{
		width: 100%;
		height: 436rpx;
		background: rgba(236,237,238,1);
		box-shadow: 0px -1rpx 0px 0px rgba(0,0,0,0.1);
		bottom:env(safe-area-inset-bottom);
		padding: 40rpx 20rpx;
		box-sizing: border-box;                                                                                                                                              
		.more-list{
			width: 25%;
			text-align: center;
			float: left;
			padding-bottom: 32rpx;
			image{
				width: 72rpx;
				height: 72rpx;
				padding: 24rpx;
				border-radius: 24rpx;
			}
			.more-list-title{
				font-size: 24rpx;
				color: rgba(39,40,50,0.50);
				line-height: 34rpx;
			}
		}
	}
</style>
