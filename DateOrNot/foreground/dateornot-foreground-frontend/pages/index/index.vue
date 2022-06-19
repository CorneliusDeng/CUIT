<template>
	<view class="content">
		<image class="logo" :src="'https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/'+shortUrl+'.jpg'" 
		@tap="loginTest('/pages/blog/blog')"></image>
		<view class="text-area">
			<view class="title">uid: <input type="text" v-model="uid"/></view>
			<view class="title">uname: <input type="text" v-model="uname"/></view>
			<view class="title" style="width: 280rpx;">headUrl: <input type="text" v-model="shortUrl"/></view>
		</view>
	</view>
</template>

<script>
	import { localStorage,sessionStorage } from '@/commons/mp-storage/mp-storage/index.js'
	import datas from '@/commons/js/datas.js';
	export default {
		data() {
			return {
				uid: '666',
				uname:'阿彪',
				shortUrl:'abiao',
			}
		},
		onLoad() {
		},
		methods: {
			//页面跳转
			goToPage(url) {
				
				if (!url) return;
				console.log(url)
				uni.switchTab({
					url:url
				});
			},
			loginTest(url){
				var user = {
					uid : this.uid,
					uname : this.uname,
					headUrl : 'https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/'+this.shortUrl+'.jpg'
				};
				
				sessionStorage.setItem('user',JSON.stringify(user));
				
				sessionStorage.setItem('uid',this.uid);
				localStorage.setItem('uid',this.uid);
				console.log(sessionStorage.getItem('uid'));
				
				this.$websocket.commit('setUid',this.uid);

				this.$websocket.dispatch('init');
				// this.$websocket.dispatch('webSocketInit');
				// this.message=datas.userData().msgDetail[this.uid];
				// console.log(this.message.msgs[0].uid);
				// for(var ite in this.message.msgList){
				// 	console.log(this.message.msgList[ite].url);
				// }
				this.goToPage(url);
				},
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		/* display: flex; */
		justify-content: center;
		width: 200rpx;
	}

	.title {
		display: flex;
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
