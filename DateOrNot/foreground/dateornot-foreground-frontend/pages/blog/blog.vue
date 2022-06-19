<template>
	<view>
		<status-bar :height="statusBarHeight"></status-bar>
		<view class="page-title">
			<text>动态</text>
			<view class="icon-plus" @click="toWritePage()">
				<image src="../../static/base_icons/plus_white.svg" style="width: 16px;height: 16px;"></image>
			</view>
		</view>
		<scroll-view class="sv" scroll-y="true" @scrolltolower="scrolltolower" 
			:style="{height: windowHeight + 'px'}">
			<block v-for="(blog,index) in blogs">
				<blog-card v-bind="blog" :key="index"></blog-card>
			</block>
		</scroll-view>
	</view>
</template>

<script>
	export default {
		onLoad() {
			let gData = getApp().globalData.systemInfo;
			this.domain = getApp().globalData.domain;
			this.userInfo = getApp().globalData.userInfo;
			this.statusBarHeight = gData.statusBarHeight;
			this.windowHeight = gData.windowHeight-gData.statusBarHeight-52-50; 
			console.log(this.userInfo)
			let _this = this;
			// 获取全部blog
			uni.request({
				// url:"http://192.168.31.221:8081/allblogs",
				url:_this.domain + "/allblogs",
				data:{
					userID: _this.userInfo.userID
				},
				success(res) {
					console.log("全部动态请求成功")
					let data = res.data;
					for(let item of data){
						if(item.imgLinks === null){
							item.imgLinks = []
						}else{
							item.imgLinks = item.imgLinks.split(";");
						}
						item.flag = 'index';
					}
					_this.blogs = data;
				},
				fail() { 
					console.log("动态请求失败") 
				}
			})
		},
		
		onPullDownRefresh() {
			let _this = this;
			_this.blogs = [];
			console.log("下拉刷新")
			console.log(this.userInfo)
			// 获取全部blog
			uni.request({
				// url:"http://192.168.31.221:8081/allblogs",
				url:_this.domain + "/allblogs",
				data:{
					userID: _this.userInfo.userID
				},
				success(res) {
					console.log("全部动态请求成功")
					let data = res.data;
					for(let item of data){
						if(item.imgLinks === null){
							item.imgLinks = []
						}else{
							item.imgLinks = item.imgLinks.split(";");
						}
						item['flag'] = "index";
					}
					_this.blogs = data;
					uni.stopPullDownRefresh();
				},
				fail() { 
					console.log("动态请求失败") ;
					uni.stopPullDownRefresh();
				}
			})
		},
		
		data() {
			return {
				blogs: []
			}
		},
		
		computed:{
			
		},
		
		methods: {
			scrolltolower(){
				console.log("滑动到底部");  
			},
			
			/* 跳转到写动态页面 */
			toWritePage(){
				uni.navigateTo({
					url: "../write-blog/write-blog?mode=write"
				})
			}
		}
	}
</script>

<style>
	.post-card{
		margin-left: 16px;
		width: 300px;
		height: 300px;
		border: 1px solid #007AFF;
	}
	
	.sv{
		background-color: #f8f8f8;
		width: 100%;
		padding-top: 52px;
	}
	
	.page-title{
		width: 100%;
		box-sizing: border-box;
		background-color: #F8F8F8;
		position: fixed;
		display: flex;
		height: 52px;
		padding-left: 16px;
		padding-right: 16px;
		align-items: center;
		justify-content: space-between;
		letter-spacing: 0.05em;
		font-size: 1.5em;
		font-weight: 700;
	}
	
	.icon-plus{
		width: 26px;
		height: 26px;
		border-radius: 50%;
		background-color: #007AFF;
		display: flex;
		align-items: center;
		justify-content: center;
	}
</style>
