<template>
	<view>
		<!-- <status-bar :height="statusBarHeight"></status-bar> -->
		<view class="container">
		<image :style="{top:statusBarHeight+8+'px'}" @click="openOptions()" class="icon-option" src="../../static/base_icons/options_white.svg"></image>
		<view class="header" :style="{'padding-top':statusBarHeight+'px'}">
			<image class="head-img" :src="profile.headImage"></image>
			<view class="nickname">
				{{profile.nickname}}
			</view>
			<view class="location">
				{{profile.school}}
			</view>
			<view class="des-bar">
				<view class="bar-item">
					<view class="num">{{profile.totalBlogs}}</view>
					<view class="des">动态数</view>
				</view>
				<view class="bar-item">
					<view class="num">{{profile.totalLikes}}</view>
					<view class="des">获得的赞</view>
				</view>
			</view>
		</view>
		</view>
		<view class="second-bar">
			<view class="bar-item" @click="clickTab(1)" :style="{'font-weight':tab===1?'700':'600',color:tab===1?'#ff3a3a':'#8F8F94'}">
				我的动态
			</view>
			<view class="bar-item" @click="clickTab(2)" :style="{'font-weight':tab===2?'700':'600',color:tab===2?'#ff3a3a':'#8F8F94'}">
				我赞过的
			</view>
		</view>
		<scroll-view scroll-y="true" :style="{height: scrollViewHeight+'px', 'background-color':'#f8f8f8'}">
			<block v-if="tab===1" v-for="(blog,index) in blogs">
				<blog-card v-bind="blog" :key="index"></blog-card>
			</block>
			<block v-if="tab===2" v-for="(blog,index) in likes">
				<blog-card v-bind="blog" :key="index"></blog-card>
			</block>
		</scroll-view>
	</view>
</template>

<script>
	export default {
		onLoad() {
			const gData = getApp().globalData.systemInfo;
			this.domain = getApp().globalData.domain;
			this.statusBarHeight = gData.statusBarHeight;
			this.winHeight = gData.windowHeight;
			const userInfo = getApp().globalData.userInfo;
			this.userInfo = userInfo;
			
			let _this=this;
			let userID = userInfo.userID;
			// 请求用户信息
			uni.request({
				// url:"http://192.168.31.221:8081/userprofile",
				url: _this.domain + "/userprofile",
				data:{
					userID:userID
				},
				success(res) {
					console.log("用户Info请求成功");
					_this.profile = res.data;
					//请求用户的全部Blog
					uni.request({
						// url:"http://192.168.31.221:8081/allmyblogs",
						url: _this.domain + "/allmyblogs",
						data:{
							userID:userID
						},
						success(res) {
							console.log("用户全部blog请求成功");
							let data = res.data;
							for(let item of data){
								if(item.imgLinks === null){
									item.imgLinks = []
								}else{
									item.imgLinks = item.imgLinks.split(";");
								}
								item["flag"] = "self";
							}
							_this.blogs = data;
						},
						fail() {
							console.log("用户全部blog请求失败")
						}
					}) 
				},
				fail() {
					console.log("用户Info请求失败")
				}
			})
		},
		
		onShow() {
			let userID = this.userInfo.userID;
			let _this=this;
			// 请求用户信息
			uni.request({
				// url:"http://192.168.31.221:8081/userprofile",
				url:_this.domain + "/userprofile",
				data:{
					userID:userID
				},
				success(res) {
					console.log("用户Info请求成功");
					_this.profile = res.data;
					_this.blogs = [];
					// 请求用户的全部Blog
					uni.request({
						// url:"http://192.168.31.221:8081/allmyblogs",
						url:_this.domain + "/allmyblogs",
						data:{
							userID:userID,
						},
						success(res) {
							console.log("用户全部blog请求成功");
							let data = res.data;
							for(let item of data){
								if(item.imgLinks === null){
									item.imgLinks = []
								}else{
									item.imgLinks = item.imgLinks.split(";");
								}
								item["flag"] = "self";
							}
							_this.blogs = data;
						},
						fail() {
							console.log("用户全部blog请求失败")
						}
					}) 
				},
				fail() {
					console.log("用户Info请求失败")
				}
			})
		},
		
		onPullDownRefresh(){
			console.log("下拉刷新")
			// 请求用户信息
			let userID = this.userInfo.userID;
			let _this = this;
			this.blogs = [];
			uni.request({
				// url:"http://192.168.31.221:8081/userprofile",
				url:_this.domain + "/userprofile",
				data:{
					userID:userID
				},
				success(res) {
					console.log("用户Info请求成功");
					_this.profile = res.data;
					let that = _this;
					//请求用户的全部Blog
					uni.request({
						// url:"http://192.168.31.221:8081/allmyblogs",
						url:_this.domain + "/allmyblogs",
						data:{
							userID:userID
						},
						success(res) {
							console.log("用户全部blog请求成功",res.data);
							let data = res.data;
							for(let item of data){
								if(item.imgLinks === null){
									item.imgLinks = []
								}else{
									item.imgLinks = item.imgLinks.split(";");
								}
								item["flag"] = "self";
							}
							that.blogs = data;
							uni.stopPullDownRefresh();
						},
						fail() {
							console.log("用户全部blog请求失败");
							uni.stopPullDownRefresh();
						}
					})
					 
					//请求用户的全部Likes
					this.likes = [];
					uni.request({
						// url:"http://192.168.31.221:8081/allmylikes",
						url:_this.domain + "/allmylikes",
						data:{
							userID:userID
						},
						success(res) {
							console.log("用户全部likes请求成功",res.data);
							let data = res.data;
							for(let item of data){
								if(item.imgLinks === null){
									item.imgLinks = []
								}else{
									item.imgLinks = item.imgLinks.split(";");
								}
								item["flag"] = "index";
							}
							_this.likes = data;
						},
						fail() {
							console.log("用户全部likes请求失败")
						}
					}) 
				},
				fail() {
					console.log("用户Info请求失败")
				}
			})
		},
		
		data() {
			return {
				profile:{},
				blogs:[],
				likes:[],
				tab:1
			}
		},
		
		computed:{
			scrollViewHeight:function(){
				return this.winHeight - this.statusBarHeight - 256 - 36 - 50 - 8; 
			}
		},
		
		methods: {
			clickTab(i){
				this.tab = i;
				if(i === 2){
					let userID = this.userInfo.userID;
					let _this = this;
					//请求用户的全部Likes
					this.likes = [];
					uni.request({
						// url:"http://192.168.31.221:8081/allmylikes",
						url:_this.domain + "/allmylikes",
						data:{
							userID:userID
						},
						success(res) {
							console.log("用户全部likes请求成功");
							let data = res.data;
							for(let item of data){
								if(item.imgLinks === null){
									item.imgLinks = []
								}else{
									item.imgLinks = item.imgLinks.split(";");
								}
								item["flag"] = "index";
							}
							_this.likes = data;
						},
						fail() {
							console.log("用户全部likes请求失败")
						}
					}) 
				}else{
					let userID = this.userInfo.userID;
					let _this = this;
					this.blogs = []
					//请求用户的全部Blog
					uni.request({
						// url:"http://192.168.31.221:8081/allmyblogs",
						url:_this.domain + "/allmyblogs",
						data:{
							userID:userID
						},
						success(res) {
							console.log("用户全部blogs请求成功");
							let data = res.data;
							for(let item of data){
								if(item.imgLinks === null){
									item.imgLinks = []
								}else{
									item.imgLinks = item.imgLinks.split(";");
								}
								item["flag"] = "self";
							}
							_this.blogs = data;
						},
						fail() {
							console.log("用户全部blog请求失败")
						}
					}) 
				}
			}
			,
			handleClick(arg){
				console.log(arg)
			},
			openOptions(){
				uni.showActionSheet({
				    itemList: ['个人资料'],
				    success: function (res) {
				        if(res.tapIndex == 0){
							uni.navigateTo({
								url: '../user/info/info'
							})
						}
				    },
				    fail: function (res) {
				        console.log(res.errMsg);
				    }
				});
			}
		}
	}
</script>

<style>
	
	.container{
		color: #FFFFFF;
		position: relative;
	}
	
	
	.icon-option{
		position: absolute;
		right: 16px;
		top: 8px;
		height: 36px;
		width: 36px;
		z-index: 2;
	}
	
	.header::before{
		content: '';
		position: absolute;
		top: 0;bottom: 0;left: 0;right: 0;
		filter: blur(20px);
		background: url("https://tse3-mm.cn.bing.net/th/id/OIP.E1G9TN8VRm95vMpHuBil2AHaE8?pid=ImgDet&rs=1") 0 / cover fixed;
		z-index: -1;
		margin: -30px;
	}
	
	.header{
		height: 256px;
		width: 100%;
		padding: 0 16px;
		position: relative;
		overflow: hidden;
	}
	
	
	
	.head-img{
		width: 88px;
		height: 88px;
		border-radius: 50%;
		/* margin-top: 24px; */
		margin: 16px 0 8px 0;
	}
	
	.nickname{
		margin-top: 0;
		font-size: 1.5em;
		font-weight: bolder;
	}
	
	.location{
		margin-top: 16px;
		font-size: 0.8em;
	}
	
	.des-bar{
		display: flex;
		margin-top: 24px;
		margin-bottom: 8px;
		width: 50%;
		justify-content: space-between;
	}
	
	.bar-item{
		
	}
	
	.bar-item .num{
		margin:0;
		padding:0;
		font-size: 1.1em;
		font-weight: bold;
	}
	
	.bar-item .des{
		margin:0;
		padding:0;
		font-size: 0.65em;
	}
	
	.second-bar{
		display: flex;
		justify-content: space-around;
		align-items: center;
		height: 36px;
		padding: 4px 16px;
		border-bottom: 1px solid #F8F8F8;
		color: #8F8F94;
	}
	
	.second-bar .bar-item{
		/* width: 68px; */
	}
</style>
