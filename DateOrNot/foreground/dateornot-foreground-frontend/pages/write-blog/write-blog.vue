<template>
	<view>
		<view :style="{height:gData.statusBarHeight+'px', width:gData.windowWidth+'px',backgroundColor:'#f0f0f0'}"></view>
		<!-- 导航栏 -->
		<view class="title">
			<image src="../../static/base_icons/back.svg" class="icon-back" @click="goBack()"></image>
			<view>{{mode==='write'?'写动态':'修改动态'}}</view>
			<view :class="[(textContent || chosenImgs.length>0)?'post-clickbtn':'post-clickbtn-disabled']" @click="postBlog()">发布</view>
		</view>
		<!-- 个人信息 -->
		<view class="resume">
			<view class="head-img">
				<!-- <image :src="personalInfo.head_img" style="width: 40px; height: 40px; border-radius: 50%;"></image> -->
				<image :src="personalInfo.headImageUrl" style="width: 40px; height: 40px; border-radius: 50%;"></image>
				
			</view>
			<view class="nickname">{{personalInfo.userName}}</view> 
		</view>
		<!-- 输入区域 -->
		<image-shower :visible="photoVisible" :url="imgShowing" 
					  :height="showerHeight" :width="showerWidth" @close="()=>{photoVisible=false}"></image-shower>
		<view class="inputarea">
			<textarea class="text-area" placeholder="分享新鲜事..." v-model="textContent"></textarea>
			<view style="display: flex;flex-wrap: wrap;">
				<block v-for="(img,index) in chosenImgs">
					<view @click="openImage(img)" :style="{width: imgWidth+'px',height: imgWidth+'px',margin: '1px'}" class="img-box">
						<!-- <image :src="img" style="{height: 100%,width:100%}"></image> -->
						<image :src="img"  class="img-item" ></image>
					</view>
				</block>
				<view class="add-img" :style="{width: imgWidth+'px',height: imgWidth+'px', backgroundColor: '#f0f0f0',margin: '1px'}" @click="chooseImg()">
					<image src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.danji100.com%2Fupload%2F2021-3%2F20213221635475691.png&refer=http%3A%2F%2Fpic.danji100.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622691037&t=80eb8b4d5371beb67b7a0e8c0eb5c9ff"
					 style="width: 80px;height: 80px;border-radius: 100%;"></image>
				</view>
			</view>
			
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				textContent: '',
				chosenImgs: [],
				photoVisible:false,
				imgShowing:'',
				showerHeight:0,
				showerWidth:0
			}
		},
		
		computed:{
			imgWidth: function(){
				return Math.floor((this.gData.windowWidth-32-6)/3);
			}
		},
		
		onLoad(params) {
			this.domain = getApp().globalData.domain;
			this.gData = getApp().globalData.systemInfo;
			this.personalInfo = getApp().globalData.userInfo;
			let mode = params.mode;
			this.mode = mode;
			switch(mode){
				case 'write':
					break;
				case 'edit':
					let blogID = params.blogid;
					this.blogID = blogID;
					let _this = this;
					uni.request({
						// url:"http://192.168.31.221:8081/blogdetail",
						url:_this.domain + "/blogdetail",
						data:{
							blogID: blogID,
							userID: _this.personalInfo.userID
						},
						success(res) {
							console.log("blogDetail请求成功");
							let data = res.data.blogCard;
							_this.textContent = data["textContent"];
							let imgs = [];
							if(data["imgLinks"] === null){
								imgs = [];
							}else{
								imgs = data["imgLinks"].split(";");
								_this.chosenImgs = imgs;
							}
						},
						fail() {
							console.log("blogDetail请求失败")
						}
					})
					break;
			}
		},
		
		methods: {
			goBack(){
				uni.navigateBack({})
			},
			
			openImage(src){
				this.photoVisible = true;
				this.imgShowing = src;
				let _this = this;
				uni.getImageInfo({
					src:src,
					success(img) {
						// console.log("w:" + img.width +",h:" + img.height);
						_this.showerHeight = img.height;
						_this.showerWidth = img.width;
					}
				})
			},
			  
			// 选择图片 
			chooseImg(){
				uni.chooseImage({
					sourceType:['album'],
				    success: (chooseImageRes) => {
				        const tempFilePaths = chooseImageRes.tempFilePaths;
						this.chosenImgs = [...this.chosenImgs, ...tempFilePaths];
						console.log("图片选择成功！")
				    },
					fail: (err) => {
						console.log("图片选择失败！")
					}
				});
			},
		postBlog(){
			/* 内容图片均为空 */
			if(this.chosenImgs.length<1 && this.textContent === ''){
				uni.showToast({
					title:"内容不能为空！",
					duration: 1000
				})
				return;
			}
			
			// 修改模式
			if(this.mode === 'edit'){
				if(this.chosenImgs.length < 1){
					let blogID = this.blogID;
					uni.showLoading({
						title:"修改中..."
					})
					uni.request({
						// url: 'http://192.168.31.221:8081/editblog',
						url:this.domain + "/editblog",
						data:{
							blogID: blogID, 
							textContent: this.textContent
						},
						success() {
							uni.hideLoading()
							uni.showToast({
								title: "修改成功",
								duration:1500,
							})
							setTimeout(()=>{
								uni.navigateBack({})
							},1000)
							console.log("动态修改成功！");
							return;
						},
						fail() {
							console.log("动态修改失败！");
							return;
						} 
					})
				}
			}else if(this.mode === 'write'){
				/* 有图片 */
				let userID = this.personalInfo.userID;
				if(this.chosenImgs.length > 0){
					// 构造图片对象数组
					let fileArr = [];
					for(let i in this.chosenImgs){
						fileArr.push({"name":"file" + i, "uri":this.chosenImgs[i]});
					}
					// 发送请求
					uni.showLoading({
						title:"上传中..."
					})
					uni.uploadFile({
						// url: 'http://192.168.31.221:8081/postblogwithimg', 
						url: this.domain + "/postblogwithimg",
						files: fileArr,
						formData:{
							userID: userID,
							textContent: this.textContent
						
						},
						success() {
							uni.hideLoading()
							uni.showToast({
								title: "发布成功",
								duration:1500,
							})
							setTimeout(()=>{
								uni.navigateBack({})
							},1000)
							console.log("动态发送成功！")
						},
						fail() {
							console.log("动态发布失败！");
						} 
					});
				// 只有文字
				}else{
					uni.showLoading({
						title:"上传中..."
					})
					uni.request({
						// url: 'http://192.168.31.221:8081/postblog',
						url: this.domain + "/postblog",
						data:{
							userID: userID, 
							textContent: this.textContent
							
						},
						success() {
							uni.hideLoading()
							uni.showToast({
								title: "发布成功",
								duration:1500,
							})
							setTimeout(()=>{
								uni.navigateBack({})
							},1000)
							console.log("动态发送成功！")
						},
						fail() {
							console.log("动态发布失败！");
						} 
					})
				}
			}
			
		}
			
		}
	}
</script>

<style>
	
	.img-box{
		overflow: hidden;
	}
	
	.img-item{
		min-height: 100%;
		min-width: 100%;
	}
	
	.icon-back{
		width: 24px;
		height: 24px;
	}
	
	.title{
		display: flex;
		align-items: center;
		justify-content: space-between;
		padding: 0 16px;
		box-sizing: border-box;
		height: 52px;
	}
	
	.post-clickbtn{
		display: flex;
		justify-content: center;
		align-items: center;
		box-shadow: 0 2px 2px #F0F0F0;
		background-color: #007AFF;
		color: #FFFFFF;
		width: 40px;
		border-radius: 10%;
		font-weight: 700;
	}
	
	.post-clickbtn-disabled{
		display: flex;
		justify-content: center;
		align-items: center;
		box-shadow: 0 2px 2px #F0F0F0;
		background-color: #F0F0F0;
		color: #FFFFFF;
		width: 40px;
		border-radius: 10%;
		font-weight: 700;
	}
	
	.resume{
		box-sizing: border-box;
		display: flex;
		align-items: center;
		margin-top: 16px;
		width: 100%;
		padding: 0 16px;
	}
	
	.resume .head-img{
		margin-right: 16px;
	}
	
	.resume .nickname{
		font-size: 0.95em; 
	}
	
	.inputarea{
		box-sizing: border-box;
		width: 100%;
		margin-top: 16px;
		padding: 0 16px;
	}
	
	.inputarea .text-area{
		width: 100%;
	}
	
	.inputarea .add-img{
		width: 100%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.chosen-img{
		
	}
</style>
