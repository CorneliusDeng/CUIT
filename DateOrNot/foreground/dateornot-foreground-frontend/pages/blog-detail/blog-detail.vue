<template>
	<view>
		<status-bar v-bind:height="statusBarheight"></status-bar>
		<view class="page-title">
			<image src="../../static/base_icons/back.svg" class="icon-back" @click="goBack()"></image>
			<view class="resume-bar" @click="toPagePerson()">
				<image :src="blogCard.userHeadImage" class="head-img"></image>
				<view class="info-des">
					<view class="nickname" style="font-size: 0.9em;">{{blogCard.userName}}</view>
					<view class="timestamp" style="font-size: 0.6em;">{{transformTime(blogCard.releaseTime)}}</view>
				</view>
			</view>
			<view class="option-bar">
				<image src="../../static/base_icons/options.svg" class="icon-option"></image>
			</view>
		</view>
		
		<!-- 详细内容 -->
		<scroll-view scroll-y="true" 
				     :style="{height:scrollViewHeight+'px', width:'100%', 'padding-top':'52px'}">  
			<view class="card-body">
				<!-- <view v-if="blogCard.imgLinks.length > 0" class="body-imgarea"> -->
				<view class="body-imgarea">
					<block v-for="(img,index) in blogCard.imgLinks" :id="index">
						<image class="img-item" :src="img" :style="{width: imgWidth+'px',height: imgWidth+'px', 
						'margin-left':index%3===0?'0':'1px'}"></image>
					</block>
				</view>
				<view class="body-textarea">
					{{blogCard.textContent}}
				</view>
			</view>
			
			<view class="card-foot">
				<view class="foot-likes" @click="commitLike(blogCard.blogID)">
					<image :src="blogCard.liked===0?'../../static/base_icons/like.svg':'../../static/base_icons/like2.svg'" class="icon"></image>
					<view class="icon-text" :style="{color:blogCard.liked===0?'#b0b0b0':'#ff3a3a'}">{{blogCard.likeNum}}</view>
				</view>
				<view class="foot-comments" style="margin-right: 8px;">
					<image src="../../static/base_icons/comment.svg" class="icon"></image>
					<view class="icon-text">{{blogCard.commentNum}}</view>
				</view>
				<view class="foot-location">
					<image src="../../static/base_icons/location.svg" class="icon" style="width: 10px;height: 10px;"></image> 
					<view style="font-size: 0.6em;color: #00aaff">{{blogCard.school}}</view>
				</view>
			</view>
		
			<view class="comment-area">
				<block v-for="(comment,index) in comments">
				<view class="card-comment" style="margin-bottom: 8px;">
					<view class="comment-header" style="display: flex;">
						<image :src="comment.headImage" style="height: 30px;width: 30px;border-radius: 50%;"></image>
						<view style="padding-left: 8px;">
							<view style="font-size: 0.8em;color: #5f5f5f;">{{comment.userName}}</view>
							<view style="font-size: 0.4em;color: #8f8f8f;">{{transformTime(comment.time)}}</view>
						</view>
					</view>
					<view class="comment-content">
						{{comment.commentContent}}
					</view>
				</view>
				</block>
			</view>
		</scroll-view>
		
		<view class="footer">
			<input class="input-comment" placeholder="说点什么吧..." v-model="commentText" :style="">
			</input>
			<button v-if="typing" class="send-btn" @click="commitComment()">发送</button>
			<view v-if="!typing" class="foot-comments">
				<image src="../../static/base_icons/comment.svg" class="icon2"></image>
				<view class="icon-text2">{{blogCard.commentNum}}</view>
			</view>
			<view v-if="!typing" class="foot-likes" @click="commitLike(blogCard.blogID)">
				<image :src="blogCard.liked===0?'../../static/base_icons/like.svg':'../../static/base_icons/like2.svg'" class="icon2"></image>
				<view class="icon-text2" :style="{color:blogCard.liked===0?'#b0b0b0':'#ff3a3a'}">{{blogCard.likeNum}}</view>
			</view>
			
		</view>
	</view>
</template>

<script>
	export default {
		onLoad(params) {
			let gData = getApp().globalData.systemInfo;
			this.domain = getApp().globalData.domain;
			this.transformTime = getApp().globalData.transformTime;
			this.userInfo = getApp().globalData.userInfo;
			this.statusBarheight = gData.statusBarHeight;
			this.windowHeight = gData.windowHeight;
			
			let blogId = params.id;
			let _this = this;
			/* 请求获取Blog信息 */
			uni.request({
				// url:"http://192.168.31.221:8081/blogdetail",
				url: _this.domain + "/blogdetail",
				data:{
					blogID:blogId,
					userID: _this.userInfo.userID
				},
				success(res) {
					console.log("BlogDetail请求成功")
					let blogCard = res.data.blogCard;
					let comments = res.data.comments;
					if(blogCard.imgLinks === null){
						blogCard.imgLinks = [];
					}else{
						blogCard.imgLinks = blogCard.imgLinks.split(";");
					}
					_this.blogCard = blogCard;
					_this.comments = comments;
				},
				fail() { 
					console.log("BlogDetail请求失败")
				}
			})
		},
		
		data() {
			return {
				blogCard:{},
				commentText:'',
				comments:[]
			}
		}, 
		methods: { 
			goBack(){
				uni.navigateBack({}) 
			},
			 
			toPagePerson(){
				uni.navigateTo({
					url:"../person/person"
				})
			},
			
			commitComment(){
				let _this = this;
				// 提交评论请求
				uni.request({
					// url:"http://192.168.31.221:8081/remarkblog",
					url:_this.domain + "/remarkblog",
					data:{
						userID: _this.userInfo.userID,
						blogID: _this.blogCard.blogID,
						content: _this.commentText
					},
					success() {
						console.log("评论成功");
						/* 请求获取Blog信息 */
						uni.request({
							// url:"http://192.168.31.221:8081/blogdetail",
							url: _this.domain + "/blogdetail",
							data:{
								blogID:_this.blogCard.blogID,
								userID:_this.userInfo.userID
							},
							success(res) {
								console.log("BlogDetail请求成功")
								let blogCard = res.data.blogCard;
								let comments = res.data.comments;
								if(blogCard.imgLinks === null){
									blogCard.imgLinks = [];
								}else{
									blogCard.imgLinks = blogCard.imgLinks.split(";");
								}
								_this.blogCard = blogCard;
								_this.comments = comments;
							},
							fail() { 
								console.log("BlogDetail请求失败")
							}
						})
						_this.commentText = '';
					},
					fail() {
						console.log("评论失败")
					}
				})
			},
			
			commitLike(blogID){
				let _this = this;
				if(this.blogCard.liked != 1){
					uni.request({
						// url:"http://192.168.31.221:8081/likeblog",
						url: _this.domain + "/likeblog",
						data:{
							userID: _this.userInfo.userID,
							blogID: blogID
						},
						success() {
							_this.blogCard.likeNum += 1;
							_this.blogCard.liked = 1;
							console.log("点赞成功")
						},
						fail() {
							console.log("点赞失败")
						}
					})
				}else{
					uni.request({
						// url:"http://192.168.31.221:8081/dislikeblog",
						url: _this.domain + "/dislikeblog",
						data:{
							userID: _this.userInfo.userID,
							blogID: blogID
						},
						success() {
							_this.blogCard.likeNum -= 1;
							_this.blogCard.liked = 0;
							console.log("取消点赞成功")
						},
						fail() {
							console.log("取消点赞失败")
						}
					})
				}
				
			}
		
		},
		
		computed:{
			scrollViewHeight: function(){
				return this.windowHeight-this.statusBarheight-52-52 /* 52标题栏高度 52底部栏高度*/
			},
			
			typing: function(){
				return this.commentText != '';
			},
			
			imgWidth: function(){
				let len = this.blogCard.imgLinks.length;
				let winWidth = getApp().globalData.systemInfo.windowWidth;
				if(len === 0){ 
					return 0;
				}else if(len<3){
					return (winWidth-(len-1))/len;
				}else{
					return (winWidth-2)/3;
				}
			}
		}
	}
</script>

<style>
	.icon-back{
		width: 32px;
		height: 32px;
		margin-left: 8px; 
	}
	
	.option-bar{
		position: absolute;
		top: 8px;
		right: 0;
		margin-right: 16px;
	}
	
	.icon-option{
		width: 36px;
		height: 36px;
	}
	.icon{
		width: 26px;
		height: 26px;
	}
	.icon2{
		width: 30px;
		height: 30px;
	}
	.icon-text{
		margin-left: 2px;
		font-size: 0.9em;
		font-weight: bold;
		color: #b0b0b0;
	}
	.icon-text2{
		margin-left: 2px;
		font-size: 1em;
		font-weight: bold;
		color: #b0b0b0;
	}
	
	.page-title{
		height: 52px;
		background-color: #F8F8F8;
		position: fixed;
		width: 100%;
		display: flex;
		align-items: center;
	}
	
	.head-img{
		width: 36px;
		height: 36px;
		border-radius: 50%;
	}
	
	.resume-bar{
		display: flex;
		align-items: center;
		margin-left: 4px;
	}
	
	.info-des{
		display: flex;
		flex-direction: column;
		margin-left: 8px;
	}
	
	
	.card-body{
		font-size: 1em;
	}
	
	.body-imgarea{
		margin: 0;
		display: flex;
		flex-wrap: wrap;
		margin-bottom: 8px;
	}
	
	.body-textarea{
		padding: 0 16px;
	}
	
	.img-item{
		margin-bottom: 1px;
	}
	
	.card-foot{
		margin: 4px 0;
		display: flex;
		flex-direction: row-reverse;
		height: 36px;
		position: relative;
	}
	
	.foot-location{
		display: flex;
		align-items: center;
		position: absolute;
		top: 12px;
		left: 16px;
	}
	
	.comment-content{
		margin-left: 38px;
		margin-right: 16px;
		padding-bottom: 8px;
		font-size: 0.85em;
		border-bottom: 1px solid #F8F8F8;
	}
	
	
	.footer{
		height: 52px;
		width: 100%;
		position: fixed;
		bottom: 0;
		display: flex;
		align-items: center;
		justify-content: space-between;
		border-top: 1px solid #FAFAFA;
		/* padding-right: 8px; */
	}
	
	.input-comment{
		height: 32px;
		width: 230px;
		background-color: #F8F8F8;
		padding-left: 4px;
		font-size: 0.9em;
		margin-left: 16px;
	}
	
	.foot-likes{
		height: 36px;
		display: flex;
		align-items: center;
		margin-right: 8px;
		width: 48px;
	}
	.foot-comments{
		height: 36px;
		display: flex;
		align-items: center;
		margin-right: 12px;
		width: 42px;
	}
	
	.footer .foot-likes{
		height: 36px;
		display: flex;
		align-items: center;
		margin-right: 12px;
		width: 48px;
	}
	.footer .foot-comments{
		height: 36px;
		display: flex;
		align-items: center;
		/* margin-right: 12px; */
		width: 42px;
	}
	
	.send-btn{
		height: 30px;
		width: 78px;
		background-color: #007AFF;
		color: #FFFFFF;
		display: flex;
		align-items: center;
		justify-content: center;
		font-size: 0.9em;
		margin-right: 24px;
	}
	
	.comment-area{
		padding: 16px;
	}
</style>
