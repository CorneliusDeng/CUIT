<template>
	<view>
		<view class="avatar-wrapper">
			<image class="avatar" :src="user.head_image_url==''?'../../static/avatar.png':user.head_image_url"></image>
		</view>
		<view class="username-wrapper">
			<text class="username">{{user.user_name}}</text>
		</view>

		<view class="gender-age-wrapper">
			<uni-tag :text="(user.sex==0?'♂ ':'♀ ') + getUserAge()" type="primary" size="small"></uni-tag>
		</view>
		<scroll-view scroll-y="true" class="description-wrapper">
			<text class="description">{{user.introduction}}</text>
		</scroll-view>
		<view class="charts-box">
			<qiun-data-charts type="word" :chartData="wordCloudData" :animation="true" />
		</view>
		<view class="button-wrapper">
			<button type="primary" @click="startChat()">发消息</button>
			<text class="exit-link" style="color: #AAAAAA;display: flex; justify-content: center;"
				@click="quit()">返回</text>
		</view>
	</view>
</template>

<script>
	import Config from '../config.js'
	import UniTag from '../../components/uni-tag/uni-tag.vue'
	import QiunDataCharts from '../../components/qiun-data-charts/qiun-data-charts.vue'
	export default {
		components: {
			UniTag,
			QiunDataCharts
		},

		onLoad: function(option) {
			if (option.matchedUser == null) {
				uni.navigateTo({
					url: "../matching/matching"
				})
			} else {
				this.user = JSON.parse(option.matchedUser)
				this.getTags()
			}
		},
		data() {
			return {
				user: null,
				wordCloudData: {
					categories: [],
					series: []
				}
			}
		},
		methods: {
			quit() {
				uni.navigateBack({

				})
			},
			getUserAge() {
				let date = this.user.birthday.split('-')
				let currentDate = new Date()
				let year = currentDate.getFullYear()
				let month = currentDate.getMonth();
				return new String(year - date[0] - (date[1] > month ? 1 : 0))
			},
			getTags() {
				let _this = this
				uni.request({
					url: Config.baseUrl + '/tag/user',
					data: {
						userId: _this.user.user_id
					},
					method: 'GET',
					success: (res) => {
						_this.user.tags = res.data
						console.log(res.data)
						_this.drawWordCloud()
						
					}
				})
			},
			drawWordCloud() {
				let i = 0
				if(this.user.tags == null || this.user.tags.length == 0){
					console.log("no tags")
					this.wordCloudData.series.push({
						name: '无标签',
						textSize: 15
					})
					return
				}
				else{
					while(this.wordCloudData.series.length < 30){
						if(i == this.user.tags.length){
							i = 0
						}
						this.wordCloudData.series.push({
							name: this.user.tags[i++],
							textSize: 15
						})
					}
				}
			},
			startChat(){
				console.log(this.user)
				var accepter = {
					id : this.user.user_id,
					name : this.user.user_name,
					url : this.user.head_image_url
				};
				console.log(accepter)
				this.$websocket.dispatch('webSocketInit');
				this.$websocket.dispatch('setAccepter',accepter);
				this.$websocket.dispatch('init');
				
				
				uni.navigateTo({
					url: '../message/friendChat?id=' + this.user.user_id
				})
			}
		}
	}
</script>

<style scoped src="./matchedUserInfo.css"></style>
<style>
	
</style>
