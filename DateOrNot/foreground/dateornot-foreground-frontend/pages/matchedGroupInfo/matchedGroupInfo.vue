<template>
	<view>
		<view class="avatar-wrapper">
			<image class="avatar"
				:src="group.headImageUrl==null||group.headImageUrl==''?'../../static/avatar.png':group.headImageUrl">
			</image>
		</view>
		<view class="group-name-wrapper">
			<text class="group-name">{{group.groupName}}</text>
		</view>

		<view class="tag-wrapper">
			<uni-tag class="tag" :text="tag" v-for="tag in group.tags" type="primary" size="small"></uni-tag>
		</view>
		<scroll-view scroll-y="true" class="description-wrapper">
			<text class="description">{{group.description}}</text>
		</scroll-view>
		<scroll-view scroll-x="true" scroll-with-animation="true" class="chart-wrapper">
			<!--年龄分布-->
			<view class="charts-box">
				<qiun-data-charts :animation="false" type="ring" :chartData="ageChartData"></qiun-data-charts>
			</view>
			<view class="charts-box">
				<qiun-data-charts :animation="false" type="pie" :chartData="genderChartData"></qiun-data-charts>
			</view>
			
			<view class="charts-box">
				<qiun-data-charts :animation="false" @complete="complete" type="map" :chartData="mapChartData" tooltipFormat='tooltipMap' :inScrollView="true"></qiun-data-charts>
			</view>
		</scroll-view>
		<view class="button-wrapper">
			<button type="primary" @click="joinGroupChat()">进群</button>
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
		data() {
			return {
				host: Config.baseUrl,
				group: null,
				members: null,
				ageChartData: {
					series: [{
						data: [{
							name: '<18',
							value: 0
						}, {
							name: '18~20',
							value: 0
						}, {
							name: '20~25',
							value: 0
						}, {
							name: '>25',
							value: 0
						}]
					}]
				},
				genderChartData: {
					series:[{
						data: [{
							name: '男',
							value: 0
						},
						{
							name: '女',
							value: 0
						},]
					}]
				},
				mapChartData:{
					series: [
						
					]
				},
				currentUser:{
					
				}
			}
		},
		onLoad(option) {
			let _this = this
			if (option.group != null && option.group != '') {
				this.group = JSON.parse(option.group)
				uni.request({
					url: _this.host + '/group/member/chart',
					method: 'GET',
					data: {
						groupId: _this.group.groupId
					},
					success: (res) => {
						_this.members = res.data
						_this.getChartData()
					}
				})
			} else {
				uni.navigateTo({
					url: '../findGroup/findGroup'
				})
			}
		},
		mounted(){
			let user = uni.getStorageSync("userInfo")
			if(user == null){
				uni.navigateTo({
					url:'../user/login/login'
				})
			}
			this.currentUser.userId = user.user_id
			this.getMapData()
		},
		methods: {
			quit() {
				uni.navigateBack({
					
				})
			},
			/**
			 * 根据年龄绘制群成员年龄分布图表
			 */
			getChartData(){
				let i = 0
				for(i = 0; i < this.members.length; i++){
					let age = this.getUserAge(this.members[i].birthday)
					if(age < 18){
						this.ageChartData.series[0].data[0].value += 1
					}
					else if(age < 20){
						this.ageChartData.series[0].data[1].value += 1
					}
					else if(age < 25){
						this.ageChartData.series[0].data[2].value += 1
					}
					else{
						this.ageChartData.series[0].data[3].value += 1
					}
					
					let sex = this.members[i].sex
					this.genderChartData.series[0].data[sex].value += 1
				}
			},
			/**
			 * 通过用户生日换算出年龄
			 * @param {Object} birthday 生日 格式 yyyy-mm-dd
			 */
			getUserAge(birthday){
				let date = birthday.split('-')
				let currentDate = new Date()
				let year = currentDate.getFullYear()
				let month = currentDate.getMonth();
				return year - date[0] - (date[1] > month ? 1 : 0)
			},
			/**
			 * 加载中国地图GeoJSON数据
			 */
			getMapData(){
				let _this = this
				uni.request({
					url:'https://geo.datav.aliyun.com/areas_v2/bound/100000_full.json',
					method:'GET',
					success: (res)=>{
						// 绑定数据
						_this.mapChartData.series = res.data.features
						// 地图加载后，获取省份人数
						_this.getMemberProvince()
					}
				})
			},
			/**
			 * 加载各省份群成员人数
			 * 从后端获取后加载到图表组件
			 */
			getMemberProvince(){
				let _this = this
				
				uni.request({
					url:Config.baseUrl + '/group/member/province',
					method:'GET',
					data:{
						groupId: this.group.groupId
					},
					success: (res)=>{
						let i = 0
						// 从结果中筛选出有人的省份
						for(i = 0; i < _this.mapChartData.series.length; i++){
							let item = _this.mapChartData.series[i]
							let hasMember = false
							for(let key in res.data){
								// 渲染地图
								if(item.properties.name == key){
									// 记录省份人数
									_this.mapChartData.series[i].properties.childrenNum = res.data[key]
									// 更换颜色
									_this.mapChartData.series[i].color = "#acff7f"
									hasMember = true
									break;
								}
							}
							if(!hasMember){
								item.properties.childrenNum = 0
							}
						}
					}
				})
			},
			joinGroupChat(){
				let _this = this
				uni.request({
					url:Config.baseUrl + "/group/join",
					method:'POST',
					data:{
						groupId: this.group.groupId,
						userId: this.currentUser.userId
					},
					success: (res)=>{
						if(res.data==true){
							console.log(_this.group)
							var accepter = {
								id : _this.group.groupId,
								name : _this.group.groupName,
								url : _this.group.headImageUrl
							};
							console.log(accepter)
							this.$websocket.dispatch('webSocketInit');
							this.$websocket.dispatch('setAccepter',accepter);
							this.$websocket.dispatch('init');
							
							
							uni.navigateTo({
								url: '../message/friendChat?id=' + this.group.groupId
							})
						}
						else{
							uni.showToast({
								title:'无法加入群聊'
							})
						}
					}
				})
				
			}
		}
	}
</script>

<style src="./matchedGroupInfo.css">

</style>
