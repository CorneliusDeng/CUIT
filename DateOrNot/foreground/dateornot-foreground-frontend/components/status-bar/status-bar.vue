<template>
	<view>
		<!-- <view :style="{height: height+'px', width:'100%',backgroundColor:'#f0f0f0'}"></view> -->
		<view :style="{height: height+'px', width:'100%'}"></view>
	</view>
</template>

<script>
	export default {
		name:"status-bar",
		props:[
			'height'
		],
		data() {
			return {
				
			};
		}
	}
</script>

<style>

</style>
