<template>
	<view>
		<web-view :src="url" @message="getMessage"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				url:'/hybrid/html/fileTransform.html'
			}
		},
		onLoad(options) {
		    if (options) {
				let param = 'type='+options.type+'&accepter='+options.accepter+'&uid='+options.uid+'&uname='+options.uname+'&headUrl='+options.headUrl;
		        this.url = this.url + '?'+encodeURIComponent(param);
				console.log(this.url);
		    }
		},
		methods: {
			getMessage(evt) {
			    console.log('接收到的消息：' + JSON.stringify(evt.detail.data));  
			} 
		}
	}
</script>

<style>

</style>
