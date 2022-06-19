<template>
	<view style="height: 90vh;">
		<view class="title-wrapper">
			<text class="title">创建群聊</text>
		</view>
		<view class="notice-wrapper">
			<text class="notice">请勿在群聊中传播违法信息</text>
		</view>
		
		<view class="form-wrapper">
			<text class="form-text">群名称：</text>
			<input type="text" v-model="groupName" placeholder="填写群名称(4~32个字)" maxlength="32"/>
		</view>
		<view style="height: 5%;"></view>
		<view class="form-wrapper">
			<text class="form-text">群描述：</text>
			<textarea v-model="description" placeholder="填写群描述(5~50个字)" maxlength="150" style="height: 100%;"></textarea>
		</view>
		
		<view style="height: 5%;"></view>
		<view class="form-wrapper form-wrapper-tag">
			<text class="form-text">群标签：</text>
			<view class="tag-wrapper">
				<view v-for="tag in groupTags">
					<uni-tag :text="tag.content" class="group-tag" size="small"  type="success"></uni-tag>
				</view>
				<uni-tag class="group-tag" text="+" inverted="true" size="small" type="success" @click="selectTags()"></uni-tag>
			</view>
		</view>
		
		<view class="form-wrapper">
			<text class="form-text">群头像：</text>
			<view class="potrait-wrapper">
				<image :src="imageSrc" class="potrait" @click="chooseImage()"></image>
			</view>
		</view>
		
		<button class="create-button" type="primary" @click="createGroupChat()">立即创建</button>
		<text class="exit-link" @click="exit">返回</text>
	</view>
</template>
<script>
	import Config from '../config.js'
	import UniTag from '../../components/uni-tag/uni-tag.vue'
	export default {
		components:{UniTag},
		data() {
			return {
				currentUser: {
					userId: 1
				},
				groupTags:[],
				imageSrc: '../../static/uploadPotrait.png',
				groupName: null,
				description: null,
				tags: null,
				headImageUrl: null,
				imageName: null
			}
		},
		onShow() {
			let user = uni.getStorageSync("userInfo")
			this.currentUser.userId = user.user_id
			console.log(user)
			this.groupName = uni.getStorageSync("groupName")
			this.description = uni.getStorageSync("groupDescription")
			let tags = uni.getStorageSync("groupTags")
			if(tags != null){
				this.groupTags = JSON.parse(tags)
			}
		},
		onLoad(option){
			
		},
		mounted(){
			// this.currentUser.userId = uni.getStorageSync("userId")
			
		},
		methods: {
			chooseImage(){
				let _this = this
				uni.chooseImage({
					count:1,
					success: (res)=>{
						console.log(res)
						_this.imageSrc = res.tempFilePaths[0],
						_this.imageName = res.tempFiles[0].name
					}
				})
			},
			uploadImage(){
				let key = '/groupPotraits/' + this.currentUser.userId + this.groupName + new Date().getTime()
				console.log(key)
				this.headImageUrl = Config.bucketUrl + key
				uni.uploadFile({
					url:Config.bucketUrl,
					name:'file',
					filePath:this.imageSrc,
					formData:{
						'key': key
					},
					complete:(res)=>{
						console.log(res)
					}
				})
			},
			
			createGroupChat(){
				uni.removeStorageSync("groupName")
				uni.removeStorageSync("groupDescription")
				if(this.groupName == null || this.groupName.length > 32 || this.groupName.length < 4){
					uni.showToast({
						title:'请输入4~32字的群名称',
						icon:'none',
						duration:2000
					})
					return
				}
				if(this.description == null || this.description.length > 50 || this.description.length < 5){
					uni.showToast({
						title:'请输入5~50字的群描述',
						icon:'none',
						duration:2000
					})
					return
				}
				if(this.imageSrc != '../../static/uploadPotrait.png'){
					this.uploadImage()
					console.log(this.groupTags)
					uni.request({
						url:Config.baseUrl + '/group',
						method:'POST',
						data:{
							groupName: this.groupName,
							ownerId: this.currentUser.userId,
							description: this.description,
							headImageUrl: this.headImageUrl,
							groupTags: this.groupTags
						},
						success: (res)=>{
							if(res.data == true){
								uni.removeStorageSync("groupTags")
								uni.showToast({
									title:"创建群聊成功",
									duration:3000,
									complete(){
										uni.navigateTo({
											url:'../findGroup/findGroup'
										})
									}
								})
							}
							else{
								uni.showToast({
									title:"创建群聊失败",
									icon:'none',
									duration:2000
								})
							}
						},
						fail: (res)=>{
							uni.showToast({
								title:"创建群聊失败",
								icon:'none',
								duration:2000
							})
						}
					})
				}
				
			},
			selectTags(){
				let _this = this
				uni.setStorageSync("groupName", this.groupName)
				uni.setStorageSync("groupDescription", this.description)
				uni.setStorageSync("groupTags", JSON.stringify(this.groupTags))
				uni.navigateTo({
					url:'../groupSelectTags/groupSelectTags?groupTags=' + JSON.stringify(this.groupTags),
				})
				
				
			},
			exit(){
				uni.removeStorageSync("groupName")
				uni.removeStorageSync("groupDescription")
				uni.removeStorageSync("groupTags")
				uni.navigateBack({
					
				})
			}
		}
	}
</script>
<style scoped src="./addGroup.css"></style>
<style>

</style>
