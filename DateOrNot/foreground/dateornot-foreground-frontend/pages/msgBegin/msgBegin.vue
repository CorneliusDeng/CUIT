<template>
	<view class="content">
		<image class="logo" :src="'https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/'+shortUrl+'.jpg'" 
		@tap="msgBegin('/pages/message/friendChat?id='+uid)"></image>
		<view class="text-area">
			<view class="title">id: <input type="text" v-model="uid"/></view>
			<view class="title">name: <input type="text" v-model="uname"/></view>
			<view class="title" style="width: 280rpx;">headUrl: <input type="text" v-model="shortUrl"/></view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				uid: '666',
				uname:'阿彪',
				shortUrl:'abiao',
				groupChat:false,
			}
		},
		watch:{
			uid(newValue){
				this.groupChat = newValue>=1000000?true:false;
			}
		},
		methods: {
			//页面跳转
			goToPage(url) {
				if (!url) return;
				uni.navigateTo({url});
			},
			msgBegin(url){
				var accepter = {
					id : this.uid,
					name : this.uname,
					url : 'https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/'+this.shortUrl+'.jpg'
				};
				this.$websocket.dispatch('init');
				this.$websocket.dispatch('webSocketInit');
				this.$websocket.dispatch('setAccepter',accepter);
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
