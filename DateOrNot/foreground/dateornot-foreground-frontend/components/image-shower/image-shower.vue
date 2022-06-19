<template>
	<view v-show="visible" @click="close()" class="showPhoto">
		<image class="img" :src="url" :style="{height:height/3+'px',width:width/3+'px'}"></image>
	</view>
</template>

<script>
	export default {
		name:"image-shower",
		props:[
			'url',
			'visible',
			'height',
			'width'
		],
		data() {
			return {
				
			};
		},
		methods:{
			close(){
				this.$emit("close");
			}
		}
	}
</script>

<style>
	.showPhoto{
		position: fixed;
		top:0;
		left: 0;
		width: 100%;
		height: 100%;
		background: rgba(0,0,0,0.8);
		z-index: 9999;
		display: flex;
		align-items: center;
		justify-content: center;
	}
	
	.img{
		/* display: block;
		margin: auto 0;
		max-width: 100%;
		max-height: 100%;
		text-align: center; */
	}
</style>
