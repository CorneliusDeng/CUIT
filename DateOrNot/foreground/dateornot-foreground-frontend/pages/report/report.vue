<template>
	<view>
		<textarea class="text-area" placeholder="填写举报原因..." v-model="textarea"></textarea>
		<button @click="postReport()" :disabled="textarea===''">提交举报</button>
	</view>
</template>

<script>
	export default {
		onLoad(params) {
			this.domain = getApp().globalData.domain;
			this.userID = getApp().globalData.userInfo.userID;
			this.blogID = params.id;
		},
		data() {
			return {
				textarea:''
			}
		},
		methods: {
			postReport(){
				let _this = this;
				console.log(_this.userID,_this.blogID,_this.textarea)
				uni.request({
					url: _this.domain + "/report",
					data:{
						userID: _this.userID,
						blogID: _this.blogID,
						reason: _this.textarea
					},
					success() {
						uni.showToast({
							title:"举报成功！"
						})
					},
					fail() {
						uni.showToast({
							title:"举报失败！"
						})
					}
				})
			}
		}
	}
</script>

<style>
	.text-area{
		padding: 16px;
	}
	
	button{
		margin: 0 16px;
		background-color: #007AFF;
		color: #FFFFFF;
		font-size: 1.1em;
	}
</style>
