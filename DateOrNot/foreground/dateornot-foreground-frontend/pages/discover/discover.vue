<template>
	<view>
		<view class="status_bar">
		    <!-- 状态栏 -->
		</view>
		 
		<!-- 自定义导航栏 -->
		<view class="status_title">
		    <view class="status_left">匹配</view>
		    <!-- <image class="status_right" src="@/static/images/message/addmore.png" mode="widthFix" @tap="goToPage('/pages/msgBegin/msgBegin')"></image> -->
		</view>
		<view style="height: 88vh; background-color: #F1F1F1;">
			<view class="selection-box"
				@click="navigateTo('../matching/matching')"
				style="flex-direction: row;">
				<image src="../../static/discover_chat.png" class="selection-image"></image>
				<text class="selection-text">聊天匹配</text>
			</view>
			<view class="selection-box" 
				@click="navigateTo('../nearbyPeople/nearbyPeople')" 
				style="flex-direction: row;">
				<image src="../../static/location.png" class="selection-image"></image>
				<text class="selection-text">附近的人</text>
			</view>
			<view class="selection-box"
				@click="navigateTo('../findGroup/findGroup')"
				style="flex-direction: row;">
				<image src="../../static/discover_group.png" class="selection-image"></image>
				<text class="selection-text">寻找群聊</text>
			</view>
		</view>
	</view>
	
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			navigateTo(url){
				console.log(url)
				uni.navigateTo({
					url:url
				})
			}
		}
	}
</script>

<style src="./discover.css"></style>

<style>
.status_bar {
    height: var(--status-bar-height);
    width: 100%;      
}
 
/* 自定义导航栏 */
.status_title {
	background: rgba(255, 255, 255, $alpha: 0.96);
	border-bottom: 1px solid $uni-border-color;
    box-sizing: border-box;
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;
    height: 52px;
    padding: 0 16px;
}
.status_left {
	font-size: 1.5em;
	font-weight: 700;
}
</style>
