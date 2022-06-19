<template>
	<view>
		<view class="status_bar">
		    <!-- 状态栏 -->
		</view>
		 
		<!-- 自定义导航栏 -->
		<view class="status_title">
		    <view class="status_left">消息</view>
		    <!-- <image class="status_right" src="@/static/images/message/addmore.png" mode="widthFix" @tap="goToPage('/pages/msgBegin/msgBegin')"></image> -->
		</view>
		
		<scroll-view class="main">
			
			<view class="message_list" @tap="goToPage('/pages/message/notice')">
				<view class="message_list_l">
					<image src="@/static/images/message/icon_systemNotice.png"></image>
				</view>
				<view class="message_list_r">
					<view class="top">
						<view class="name">系统通知</view>
						<view class="time">22:14</view>
					</view>
					<view class="news">点击查看最新通知！</view>
					<text class="tip"></text>
				</view>
			</view>
			<view class="message_list" v-for="item in messages" :key="item.id" @tap="goToPage('/pages/message/friendChat?id='+item.id)" @longtap="deleteMsg(item)">
				<view class="message_list_l">
					<image :src="item.url"></image>
				</view>
				<view class="message_list_r">
					<view class="top">
						<view class="name">{{item.name}}</view>
						<view class="time">{{changeTime(item.time)}}</view>
					</view>
					<view class="news">{{item.news}}</view>
					<text v-show="item.tip!=0" class="tip">{{item.tip}}</text>
				</view>
			</view>
		</scroll-view>
	</view>
</template>

<script>
	import { localStorage } from '@/commons/mp-storage/mp-storage/index.js';
	import datas from '@/commons/js/datas.js';
	import myfun from '@/commons/js/time.js';
	export default {
		data() {
			return {
				messages:'',
			}
		},
		onLoad() {
			if(!this.$websocket.getters.uid){
				this.goToPage("/pages/user/login/login");
			}
			this.$websocket.dispatch('init');
			this.$websocket.dispatch('webSocketInit');
			this.$websocket.state.talkOnVideo = 'param';
			this.getMessages();
		},
		computed: {
		    //监听接收到的消息
			socketMsgs:{
				get:function () {
					return JSON.stringify(this.$websocket.state);
				}
			},
			talkVideo:{
				get:function () {
					return this.$websocket.state.talkOnVideo;
				}
			},
			fileOnline:{
				get:function () {
					return this.$websocket.state.fileOnlineParam;
				}
			}
		},
		watch:{
			//监听新消息
			socketMsgs:{
				handler(newValue){
					this.messages = JSON.parse(newValue).userMsg.msgList;
				},
				deep:true
			},
			//监听视频通话请求
			talkVideo:{
				handler(newValue){
					console.log("跳转到通话页面"+newValue);
					let that = this;
					if(newValue!='param'){
						console.log('/pages/message/p2pTalking?' + newValue);
						let permission = true;
						if(uni.getSystemInfoSync().platform == 'android'){
							plus.android.requestPermissions(['android.permission.CAMERA','android.permission.RECORD_AUDIO'], function(e){
							    permission = false;
								if(e.deniedAlways.length>0){    //权限被永久拒绝
							        // 弹出提示框解释为何需要权限，引导用户打开设置页面开启
							        console.log('权限被永久拒绝'+e.deniedAlways.toString());      
							    }  
							    if(e.deniedPresent.length>0){   //权限被临时拒绝
							        // 弹出提示框解释为何需要权限，可再次调用plus.android.requestPermissions申请权限  
							        console.log('权限被临时拒绝'+e.deniedPresent.toString());  
							    }  
							    if(e.granted.length>0){ //权限被允许  
									that.goToPage('/pages/message/p2pTalking?' + newValue);
							        console.log('权限被允许'+e.granted.toString());  
							    }      
							}, function(e){
							         console.log('Request Permissions error:'+JSON.stringify(e));  
							});  
						}
						if(permission){
							that.goToPage('/pages/message/p2pTalking?' + newValue);
						}
						
					}
				},
				deep:true
			},
			//监听文件传输请求
			fileOnline:{
				handler(newValue){
					console.log("跳转到文件页面"+newValue);
					if(newValue!='param'){
						console.log('/pages/message/fileTransform?' + newValue);
						this.goToPage('/pages/message/fileTransform?' + newValue);
					}
				},
				deep:true
			}
		},
		methods: {	
			//页面跳转
			goToPage(url) {
				if (!url) return;
				uni.navigateTo({url});
			},
			//获取消息
			getMessages: function() {
				this.messages = JSON.parse(this.$websocket.getters.socketMsgs).msgList;
				// console.log(this.messages);
			},
			//时间格式设置
			changeTime: function(date) {
				return myfun.datetime(date);
			},
			//删除消息
			deleteMsg:function(e){
				uni.showModal({
					title: '删除消息',
					content: '是否删除与'+e.name+'的消息记录',
					cancelText: '取消',
					confirmText: '确定',
					success: res=>{
						if(res.confirm){
							console.log("删除消息记录");
							this.$websocket.dispatch('deleteMsgList',e.id);
						}else{
							console.log('取消删除');
						}
					},
				});
			}
		}
	}
</script>

<style lang="scss">
	
/* 自定义状态栏 */
.status_bar {
    height: var(--status-bar-height);
    width: 100%;      
}
 
/* 自定义导航栏 */
.status_title {
	background: rgba(255, 255, 255, $alpha: 0.96);
	border-bottom: 1rpx solid $uni-border-color;
    box-sizing: border-box;
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;
    height: 52px;
    padding: 0 16px;
}
.status_left {
	font-size: 1.5em;
	font-weight: 700;
}
.status_right {
    width: 25px;
}

.main {
		padding-top: 10rpx;
		padding-bottom: $uni-spacing-col-base;
}

.message_list {
		height: 96rpx;
		padding: 16rpx $uni-spacing-col-base;

		&:active {
			background-color: $uni-bg-color-grey;
		}

		.message_list_l {
			position: relative;
			float: left;

			image {
				width: 96rpx;
				height: 96rpx;
				border-radius: $uni-border-radius-base;
				// background-color: $uni-color-primary;
			}
		}

		.message_list_r {
			position: relative;
			padding-left: 128rpx;

			.top {
				height: 50rpx;

				.name {
					float: left;
					font-size: 36rpx;
					font-weight: 400;
					color: $uni-text-color;
					line-height: 50rpx;
				}

				.time {
					float: right;
					font-size: $uni-font-size-sm;
					color: $uni-text-color-disable;
					line-height: 50rpx;
				}
			}

			.news {
				font-size: $uni-font-size-base;
				color: $uni-text-color-grey;
				line-height: 40rpx;
				width: 100%;
				display: -webkit-box;
				-webkit-box-orient: vertical;
				-webkit-line-clamp: 1;
				overflow: hidden;
			}
			
			.tip {
				position: absolute;
				z-index: 10;
				top: 48rpx;
				right: 8rpx;
				min-width: 20rpx;
				padding: 0 8rpx;
				height: 36rpx;
				background: $uni-color-warning;
				border-radius: 18rpx;
				font-size: $uni-font-size-sm;
				color: $uni-text-color-inverse;
				line-height: 36rpx;
				text-align: center;
			}
		}
	}	
</style>
