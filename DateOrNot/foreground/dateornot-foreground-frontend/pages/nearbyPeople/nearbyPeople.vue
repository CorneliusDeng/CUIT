<template>
	<view>
		<view class="map-wrapper">
			<map style="width: 100%; height: 100%;" :latitude="userLocation.latitude"
				:longitude="userLocation.longitude" :markers="markers" :circles="circles" scale="14" min-scale="14"
				max-scale="20" show-location="true"></map>
		</view>
		<scroll-view scroll-y="true" v-if="nearby.length != 0" class="people-list-wrapper">
			<view class="user-info-wrapper" v-for="user, index in nearby" @click="jumpTo(user)">
				<view class="avatar-wrapper">
					<image :src="user.head_image_url==''?'../../static/avatar.png':user.head_image_url" class="avatar"></image>
				</view>
				<view class="username-wrapper">
					<text class="username">{{user.user_name}}</text>
				</view>
				<view class="distance-wrapper">
					<text class="distance">{{formatDistance(user.distance)}}</text>
				</view>

				<view class="user-status-wrapper">
					<text style="color: #6aff94;">在线</text>
				</view>
				<view class="tag-wrapper">
					<uni-tag :text="(user.sex==0?'♂  ':'♀  ') + getUserAge(user)" :type="user.sex==0?'primary':'error'"
						size="small"></uni-tag>
				</view>

				<view class="description-wrapper">
					<text class="description">{{user.introduction}}</text>
				</view>
			</view>
		</scroll-view>
		<scroll-view v-else class="people-list-wrapper" scroll-y="true">
			<text class="hint">附近没有其他用户</text>
		</scroll-view>
	</view>
</template>

<script>
	import Config from '../config.js'
	import UniTag from '../../components/uni-tag/uni-tag.vue'
	export default {
		components: {
			UniTag,
		},
		data() {
			return {
				currentUserId: 1,
				host: Config.baseUrl,
				userLocation: {
				},
				/**
				 * 附近的用户
				 */
				nearby: [],
				markers: [],
				circles: [{
					radius: 1000,
					fillColor: '#f0f5f532',
					color: '#1ac6ff'
				}],
			}
		},
		mounted() {
			let _this = this
			this.currentUserId = uni.getStorageSync("userInfo").user_id
			// this.currentUserId = uni.getStorageSync("userId")
			// 进入页面后获取一次用户位置
			uni.getLocation({
				type: 'gcj02',
				geocode:true, // 包含地址（用于记录群成员省份分布）
				success: (res) => {
					_this.onGetLocationSuccess(res)
				}
			})
		},
		methods: {
			onGetLocationSuccess(res) {
				console.log(res)
				this.userLocation.latitude = res.latitude
				this.userLocation.longitude = res.longitude
				this.userLocation.address = res.address
				this.circles[0].latitude = this.userLocation.latitude
				this.circles[0].longitude = this.userLocation.longitude
				this.markers.push({
					latitude: res.latitude,
					longitude: res.longitude,
					callout: {
						content: "您的位置"
					},
					iconPath: '../../static/marker3.png',
					width: 35,
					height: 40
				})
				this.saveLocation()
			},

			formatDistance(distance) {
				if (distance < 0.1) {
					return '<100m'
				} else {
					return Math.round(distance * 10) / 10 + 'km'
				}
			},
			/**
			 * 获取附近的人
			 */
			listNearbyPeople() {
				let _this = this
				uni.request({
					url: this.host + '/location/nearby',
					method: 'GET',
					data: {
						latitude: this.userLocation.latitude,
						longitude: this.userLocation.longitude,
						limit: 20
					},
					success: (response) => {
						console.log(response)
						_this.nearby = []
						for (let i = 1; i < response.data.length; i++) {
							_this.nearby.push(response.data[i])
						}
						_this.addMarkers()

					}
				})
			},
			addMarkers() {
				let i = 0
				for (i = 0; i < this.nearby.length; i++) {
					let marker = {
						latitude: this.nearby[i].latitude,
						longitude: this.nearby[i].longitude,
						callout: {
							content: this.nearby[i].user_name + '\n' + this.formatDistance(this.nearby[i].distance)
						},
						iconPath: this.nearby[i].sex == 0 ? '../../static/marker1.png' : '../../static/marker2.png',
						width: 35,
						height: 40
					}
					this.markers.push(marker)
				}
			},
			saveLocation() {
				let _this = this
				uni.request({
					url: this.host + '/location',
					method: 'POST',
					data:{
						userId: this.currentUserId,
						latitude: this.userLocation.latitude,
						longitude: this.userLocation.longitude
					},
					success: (res) => {
						_this.listNearbyPeople()
					}
				})
				uni.request({
					url:this.host + '/location/address?userId='+this.currentUserId+'&address='+this.userLocation.address.province,
					method:'POST',
					success: (res)=>{
						console.log(res.data)
					}
				})
				
			},
			/**
			 * 定时更新用户位置
			 */
			updateLocation(){
				let _this = this
				uni.getLocation({
					type: 'gcj02',
					isHighAccuracy: true,
					success: (res) => {
						console.log("更新位置")
						_this.onGetLocationSuccess(res)
					}
				})
			},
			getUserAge(user){
				let date = user.birthday.split('-')
				let currentDate = new Date()
				let year = currentDate.getFullYear()
				let month = currentDate.getMonth();
				return new String(year - date[0] - (date[1] > month ? 1 : 0))
			},
			jumpTo(user){
				uni.navigateTo({
					url :'../matchedUserInfo/matchedUserInfo?matchedUser=' + JSON.stringify(user)
				})
			}
		}
	}
</script>

<style scoped src="./nearbyPeople.css"></style>

<style>

</style>
