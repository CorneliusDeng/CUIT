<template>
	<view class="card">
		<!-- 个人信息 -->
		<view class="card-head">
			<view class="card-head-img" @click="toPagePerson(userID)">
				<image :src="userHeadImage"
				style="width: 36px;height: 36px;border-radius: 50%;"></image>
			</view>
			<view class="card-head-info">
				<view style="font-size: 0.85em;'color: #1f1f1f;">
					{{userName}} 
				</view>
				<view style="font-size: 0.6em;color: #8F8F94;">
					<text>{{postTime}}</text>
				</view>
			</view>
			<view type="default" class="options" @click="optionClick()"></view>
		</view>
		<!-- 动态文字内容 -->
		<image-shower :visible="photoVisible" :url="imgShowing" 
					  :height="showerHeight" :width="showerWidth" @close="()=>{photoVisible=false}"></image-shower>
		<view class="card-body">
			<view v-if="imgLinks.length > 0" class="body-imgarea">
				<block v-for="(img,index) in imgLinks" :id="index">
					<!-- <image class="img-item" :src="img" :style="{'width': imgWidth+'px','height': imgWidth+'px', 
					'margin-left':index%3===0?'0':'1px'}" @click="openImage(img)"></image> -->
					<view class="img-box" :style="{'width': imgWidth+'px','height': imgWidth+'px','margin-left':index%3===0?'0':'1px'}" 
						@click="openImage(img)">
						<image class="img-item" :src="img"></image>
					</view>
				</block>
			</view>
			<view class="body-textarea" @click="toBlogDetail(blogID)">
				{{textContent}}
			</view>
		</view>
		
		<!-- 操作栏 -->
		<view class="card-foot">
			<view class="foot-likes" @click="commitLike(blogID)">
				<image :src="likedImgSrc" class="icon" s></image>
				<view class="icon-text" :style="{color:tempLikeState===1?'#FF3A3A':'#b0b0b0'}">{{tempLikeNum}}</view>
			</view>
			<view class="foot-comments" @click="toBlogDetail(blogID)">
				<image src="../../static/base_icons/comment.svg" class="icon"></image>
				<view class="icon-text">{{commentNum}}</view> 
			</view>
			
			<view class="foot-location"> 
				<image src="../../static/base_icons/location.svg" class="icon" style="width: 10px;height: 10px;"></image> 
				<!-- <view style="font-size: 0.7em;color: #8F8F94">{{school}}</view> -->
				<view style="font-size: 0.6em;color: #00aaff">{{school}}</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		name:"blog-card",
		props:[
			'blogID',
			'userID',
			'userHeadImage',
			'userName',
			'releaseTime',
			'textContent',
			'imgLinks',
			'school',
			'likeNum',
			'commentNum',
			'liked',
			'flag'
		],
		data() {
			return {
				tempLikeState: this.liked,
				tempLikeNum: this.likeNum,
				photoVisible:false,
				imgShowing:'',
				showerHeight:0,
				showerWidth:0
			};
		},
		computed:{
			imgWidth: function(){
				let len = this.imgLinks.length;
				let winWidth = getApp().globalData.systemInfo.windowWidth - 16;
				if(len === 0){ 
					return 0;
				}else if(len<3){
					return (winWidth-(len-1))/len;
				}else{
					return (winWidth-2)/3;
				}
			},
			
			postTime: function(){
				let releaseTime = new Date(this.releaseTime)
				let now = new Date();
				let res = now.getTime() - releaseTime.getTime();
				
				res = Math.floor(res/1000)
				
				if(res <= 60){
					res = "刚刚";
				}else if(res <= 60*60){
					res = Math.floor(res/60) + "分钟前";
				}else if(res <= 60*60*24){
					res = Math.floor(res/(60*60)) + "小时前";
				}else if(res <= 60*60*24*2){
					res = "昨天";
				}else if(res <= 60*60*24*3){
					res = "前天";
				}else{
					res = (releaseTime.getMonth()+1) + "-" + releaseTime.getDate();
				}
				
				return res;
			},
			
			likedImgSrc:function(){
				return this.tempLikeState===1?"../../static/base_icons/like2.svg":"../../static/base_icons/like.svg";
			}
			
			
		},
		
		methods:{
			toBlogDetail(blogID){
				uni.navigateTo({
					url:"../../pages/blog-detail/blog-detail?id="+blogID
				})
			},
			toPagePerson(userID){
				uni.navigateTo({
					url:"../../pages/person/person?userid="+userID
				})
			},
			commitLike(blogID){
				let _this = this;
				let userInfo = getApp().globalData.userInfo;
				let domain = getApp().globalData.domain;
				if(this.tempLikeState != 1){
					uni.request({
						// url:"http://192.168.31.221:8081/likeblog",
						url: domain+"/likeblog",
						data:{
							userID: userInfo.userID,
							blogID: blogID
						},
						success() {
							_this.tempLikeNum += 1;
							_this.tempLikeState = 1;
							console.log("点赞成功")
						},
						fail() {
							console.log("点赞失败")
						}
					})
				}else{
					uni.request({
						// url:"http://192.168.31.221:8081/dislikeblog",
						url:domain+"/dislikeblog",
						data:{
							userID: userInfo.userID,
							blogID: blogID
						},
						success() {
							_this.tempLikeNum -= 1;
							_this.tempLikeState = 0;
							console.log("取消点赞成功")
						},
						fail() {
							console.log("取消点赞失败")
						}
					})
				}
				
			},
			
			// 点击查看大图
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
			optionClick(){
				let domain = getApp().globalData.domain;
				let _this = this;
				if(this.flag === 'index'){
					uni.showActionSheet({
					    itemList: ['举报'],
					    success: function (res) {
					        console.log('选中了举报按钮');
							uni.navigateTo({
								url:"../../pages/report/report?id=" + _this.blogID
							})
					    },
					    fail: function (res) {
					        console.log(res.errMsg);
					    }
					});
				}else if(this.flag === 'self'){
					let _this = this;
					// 弹出底部选项
					uni.showActionSheet({
					    itemList: ['修改动态', '删除动态'],
					    success: function (res) {
							switch(res.tapIndex){
								// 选择修改动态
								case 0:
									uni.navigateTo({
										url:'../../pages/write-blog/write-blog?mode=edit&blogid='+_this.blogID
									})
									break;
								// 选择删除动态
								case 1:
									// 弹出提示框
									uni.showModal({
									    title: '提示',
									    content: '确定删除该条动态吗?',
										// 确认删除
									    success: function (res) {
									        if (res.confirm) {
									            console.log('用户点击确定');
												// 发送删除请求
												uni.request({
													// url:"http://192.168.31.221:8081/deleteblog",
													url:domain + "/deleteblog",
													data:{
														blogID:_this.blogID
													},
													success() {
														// 删除请求响应成功
														uni.showToast({
															title: "删除成功",
															duration:1500,
														})
														console.log("删除动态成功！")
														// 刷新
													},
													fail() {
														console.log("删除动态失败！")
													}
												})
									        } else if (res.cancel) {
									            console.log('用户点击取消');
												return;
									        }
									    }
									});
									break;
							}
					        
					    },
					    fail: function (res) {
					        console.log(res.errMsg);
					    }
					});
				}
				
			}
		}
	}
</script>

<style>
	.icon-text{
		font-size: 0.88em;
		margin-left: 2px;
		font-weight: bold;
		color: #b0b0b0;
	}
	.icon{
		width: 24px;
		height: 24px;
	}
	.card{
		display: flex;
		flex-direction: column;
		box-shadow: 0 2px 2px #F8F8F8;
		margin-bottom: 4px;
		background-color: #FFFFFF;
	}
	
	/* 
	  card-head 
	*/
	.card-head{
		display: flex;
		position: relative;
		padding: 16px 16px 0 16px;
	}
	
	.card-head-img{
		display: flex;
		justify-content: center;
		align-items: center;
		width: 40px;
		height: 40px;
	}
	.card-head-info{
		display: flex;
		flex-direction: column;
		justify-content: space-evenly;
		margin-left: 8px;
	}
	
	.card-head .options{
		position: absolute;
		top: 16px;
		right: 16px;
		background-image: url(../../static/base_icons/options.svg);
		width: 32px;
		height: 32px;
	}
	
	/* 
	  card-body 
	*/
	.card-body{
		padding-top: 8px;
		font-size: 1em;
	}
	
	.body-imgarea{
		margin: 0;
		display: flex;
		flex-wrap: wrap;
		margin-bottom: 8px;
		padding: 0 8px;
	}
	
	.body-textarea{
		padding: 0 16px;
	}
	
	.img-box{
		margin-bottom: 1px;
		overflow: hidden;
	}
	
	.img-item{
		height: 100%;
		width: 100%;
	}
	
	/* .img-item{
		margin-bottom: 1px;
	} */
	
	
	/* 
	  card-foot 
	*/
	.card-foot{
		margin: 4px 0;
		padding: 0 8px;
		display: flex;
		flex-direction: row-reverse;
		height: 36px;
		position: relative;
	}
	
	.foot-comments{
		display: flex;
		align-items: center;
		margin-right: 12px;
		width: 42px;
	} 
	.foot-likes{
		display: flex;
		align-items: center;
		width: 48px;
	}
	
	.foot-location{
		display: flex;
		align-items: center;
		position: absolute;
		top: 12px;
		left: 16px;
	}
</style>
