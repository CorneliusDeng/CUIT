<template>
	<view>
		<view class="search-wrapper">
			<input class="search-input" type="text" v-model="searchText" @keyup.enter="search()" placeholder="🔍搜索群名称"/>
			<navigator class="add-group-button" url="../addGroup/addGroup">
				<image src="../../static/addGroup.png" style="width: 25px; height: 25px;"></image>
			</navigator>
		</view>

		<scroll-view scroll-y="true" class="recommend-wrapper" v-if="groups!=null&&groups.length>0">
			<view class="group-card" v-for="group, index in groups">
				<navigator :url="'../matchedGroupInfo/matchedGroupInfo?group=' + JSON.stringify(group)">
					<view class="avatar-wrapper">
						<image :src="group.headImageUrl==null||group.headImageUrl==''?'../../static/logo.png':group.headImageUrl" class="group-avatar"></image>
					</view>
					<view class="group-name-wrapper">
						<text class="group-name-text">{{group.groupName}}</text>
					</view>
				</navigator>
				<view class="hot-wrapper">
					<image v-for="i in getFireCount(group.memberCount)" src="../../static/fire.png" class="fire"></image>
				</view>
				<view class="group-tag-wrapper">
					<uni-tag class="group-tag" v-for="tag in group.tags" :text="tag" type="primary" size="small" :type="randomColor()"></uni-tag>
				</view>
				<view class="group-description-wrapper">
					<text class="group-description">{{group.description}}</text>
				</view>
			</view>
		</scroll-view>
		<view class="recommend-wrapper" v-else>
			<text style="position: absolute; left: 30%; width: 40%; font-size: 20px; color: #A6A9AD;">没有合适的群聊</text>
		</view>
	</view>
</template>

<script>
	import Config from '../config.js'
	import UniTag from '../../components/uni-tag/uni-tag.vue'
	export default {
		components:{UniTag},
		data() {
			return {
				searchText: null,
				host: Config.baseUrl,
				groups: null,
				recommends: null,
				currentUser:{
					userId: 1
				}
			}
		},
		mounted() {
			let _this = this
			let user = uni.getStorageSync("userInfo")
			if(user == null){
				uni.navigateTo({
					url:'../user/login/login'
				})
			}
			this.currentUser.userId = user.user_id
			uni.request({
				url: _this.host + '/group/recommend',
				data:{
					userId: this.currentUser.userId,
					limit: 20
				},
				method:'GET',
				success: (res) => {
					_this.recommends = res.data
					_this.groups = _this.recommends
				}
			})
		},
		watch: {
			searchText: function(val){
				if(val == null || val == ''){
					this.groups = this.recommends
				}
				else{
					this.search()
				}	
			}
		},
		methods: {
			randomColor(){
				let colors = ['primary', 'warning', 'error', 'success']
				return colors[this.randomNum(0, 3)]
			},
			randomNum(minNum,maxNum){ 
			    switch(arguments.length){ 
			        case 1: 
			            return parseInt(Math.random()*minNum+1,10); 
			        break; 
			        case 2: 
			            return parseInt(Math.random()*(maxNum-minNum+1)+minNum,10); 
			        break; 
			            default: 
			                return 0; 
			            break; 
			    } 
			},
			/**
			 * 搜索群聊
			 */
			search(){
				let _this = this
				uni.request({
					url: _this.host + '/group/search',
					data:{
						text: _this.searchText,
						limit: 20
					},
					method:'GET',
					success: (res) => {
						_this.groups = res.data
					}
				})
			},
			joinGroup(groupId){
				uni.request({
					url:Config.baseUrl + "/group/join",
					method:'POST',
					data:{
						groupId: groupId,
						userId: this.currentUser.userId
					},
					success: (res)=>{
						if(res.data==true){
							// 进入群聊页面
						}
						else{
							console.log("无法加入群聊")
						}
					}
				})
			},
			getFireCount(memberCount){
				if(memberCount < 10){
					return 1
				} 
				else if(memberCount < 20){
					return 2
				}
				else if(memberCount < 50){
					return 3
				}
				else if(memberCount < 80){
					return 4
				}
				else{
					return 5
				}
			}
		}
	}
</script>

<style scoped src="./findGroup.css"></style>
<style>

</style>
