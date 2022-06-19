<template>
	<view style="height: 100vh;">
		<view class="matching-wrapper">
			<!--外圈-->
			<view class="border-outter" v-if="matched==false&&timeout==false"></view>
			<view class="border-outter-static" v-else></view>
			<!--内圈-->
			<view class="border-inner" v-if="matched==false&&timeout==false"></view>
			<view class="border-inner-static" v-else></view>
			<!--状态-->
			<view class="matching-state" v-if="matched==false&&timeout==false">
				<text>匹配中</text>
			</view>
			<view class="matching-state-static" v-if="timeout==true">
				<text>匹配超时</text>
			</view>
			<view class="matching-state-static" v-if="matched==true">
				<text>匹配成功</text>
			</view>
			<!--计时-->
			<view class="matching-time" v-if="matched==false&&timeout==false">
				<text>{{seconds}}s</text>
			</view>
		</view>

		<view class="result" v-if="matched==false&&timeout==false">
			<text class="result-text">没有找到合适的结果</text>
		</view>
		<view class="result" v-if="matched==false&&timeout==true">
			<text class="result-text">匹配已超时，请稍后重试</text>
		</view>
		<view class="result" v-if="matched==true">
			<navigator :url="'../matchedUserInfo/matchedUserInfo?matchedUser=' + JSON.stringify(matchedUser)">
				<image :src="matchedUser.head_image_url==''?'../../static/avatar.png':matchedUser.head_image_url" class="user-avatar"></image>
			</navigator>
			<text class="user-info-text" style="top: 20%;">{{matchedUser.user_name}}</text>
			<text class="user-info-text" style="top: 30%; font-size: 15px;">{{matchedUser.sex==0?'男':'女'}}</text>
		</view>
		<button class="start-chat-button" type="primary" v-if="matchedUser!=null" @click="startChat()">开聊</button>
		<text class="exit-link" v-if="matchedUser==null" @click="giveup()">放弃</text>
		<text class="exit-link" v-else @click="continueMatching()">继续探索</text>
	</view>
</template>

<script>
	import Config from '../config.js'
	import { localStorage, sessionStorage} from '@/commons/mp-storage/mp-storage/index.js'
	export default {
		data() {
			return {
				seconds: 0,        // 匹配时间
				matchedUser: null, //匹配到的用户
				socketTask: null, // 匹配服务器socket
				matched: false,
				timeout: false,
				currentUser:{
					userId: 12,
					tags: [1,2,3,4,5,6,7],
					birthday: '1999-01-01'
				}
			}
		},
		mounted() {
			let _this = this
			// let userMsg = JSON.parse(sessionStorage.getItem('user'))
			// this.currentUser.userId = userMsg.uid
			let user = uni.getStorageSync("userInfo")
			console.log(user)
			this.currentUser.userId = user.user_id
			this.currentUser.birthday = user.birthday
			this.getUserTags()
			// 与匹配服务器建立连接
			this.socketTask = uni.connectSocket({
				url: Config.matchSocketUrl,
				complete: () => {
					
				}
			})
			this.socketTask.onMessage(function(event){
				_this.onMessage(event)
			})
			// 匹配计时器
			setInterval(function() {
				_this.seconds = _this.seconds + 1
				if(_this.seconds == 5){
					_this.sendRequest()
				}
				if(_this.seconds > 60){
					_this.matched = false
					_this.timeout = true
					_this.matchedUser = null
				}
			}, 1000)
		},
		methods: {
			giveup() {
				uni.showModal({
					title: '提示',
					content: '确定放弃本次匹配？',
					success: function (res) {
						if (res.confirm) {
							// uni.navigateTo({
							// 	url:'/pages/discover/discover'
							// })
							uni.navigateBack({
								
							})
						}
					}
				});
			},
			/**
			 * 放弃匹配结果，继续匹配
			 */
			continueMatching() {
				let _this = this
				uni.showModal({
					title:'提示',
					content:'确定重新匹配？',
					success(res) {
						if(res.confirm){
							_this.seconds = 0
							_this.matchedUser = null
							_this.matched = false
							_this.timeout = false
							_this.getUserTags()
						}
					}
				})
			},
			/**
			 * 接收到匹配服务器反馈
			 * @param {Object} event 反馈信息
			 */
			onMessage(event){
				let response = JSON.parse(event.data)
				console.log(response)
				// 匹配成功
				if(response.code == 2){
					this.matched = true
					this.matchedUser = response.data
				}
				// 匹配超时
				else{
					this.matched = false
					this.timeout = true
					this.matchedUser = null
					console.log(this.timeout)
				}
			},
			/**
			 * 发送匹配请求
			 */
			sendRequest(){
				this.socketTask.send({
					data:JSON.stringify(this.currentUser)
				})
			},
			startChat(){
				var accepter = {
					id : this.matchedUser.user_id,
					name : this.matchedUser.user_name,
					url : this.matchedUser.head_image_url
				};
				console.log(accepter)
				this.$websocket.dispatch('webSocketInit');
				this.$websocket.dispatch('setAccepter',accepter);
				this.$websocket.dispatch('init');
				
				uni.navigateTo({
					url: '../message/friendChat?id=' + this.matchedUser.user_id
				})
			},
			getUserTags(){
				let _this = this
				uni.request({
					url:Config.baseUrl + '/tag/user/id',
					method:'GET',
					data:{
						userId: this.currentUser.userId
					},
					success(res){
						_this.currentUser.tags = res.data
					}
				})
			}
		}
	}
</script>
<style src="./matching.css"></style>
<style>
	body {
		height: 100vh;
		overflow: hidden;
	}
</style>
