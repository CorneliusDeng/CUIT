<template>
	<view class="emoji" :style="{height:height+'px'}">
		<view class="emoji-line" v-for="(line,i) in emoji" :key="i">
			<view class="emoji-line-item" v-for="(item,index) in line" :key="index" @tap="clickEmoji(item)">{{item}}</view>
		</view>
	</view>
</template>

<script>
	export default {
		props:{
			height:{
				type:Number,
				default:260
			}
		},
		data() {
			return {
				//emoji表情数组
				emoji:[
					['😀', '😁', '😂', '🤣', '😃', '😄', '😅'],
					['😆', '😉', '😊', '😋', '😎', '😍', '😘'],
					['😗', '😙', '😚', '🙂', '🤗', '🤔', '😐'],
					['😑', '😶', '🙄', '😏', '😣', '😥', '😮'],
					['🤐', '😯', '😪', '😫', '😴', '😌', '😛'],
					['😜', '😝', '🤤', '😒', '😓', '😔', '😕'],
					['🙃', '🤑', '😲', '🙁', '😖', '😞', '😟'],
					['😤', '😢', '😭', '😦', '😧', '😨', '😩'],
					['😬', '😰', '😱', '😳', '😵', '😡', '😠'],
					['😷', '🤒', '🤕', '🤢', '🤧', '😇', '🤠'],
					['🤡', '🤥', '🤓', '😈', '👿', '👹', '👺'],
					['💀', '👻', '👽', '🤖', '💩', '😺', '😸'],
					['😹', '😻', '😼', '😽', '🙀', '😿', '😾'],
					['🏻', '🏼', '🏽', '🏾', '🏿', '🗣', '👤'],
					['👥', '👫', '👬', '👭', '👂', '👂🏻', '👃'],
					['👃🏻', '👃🏼', '👃🏽', '👃🏾', '👃🏿', '👣', '👀'],
					['👁', '👅', '👄', '💋', '👓', '🕶', '👔'],
					['👕', '👖', '👗', '👘', '👙', '👚', '👛'],
					['👜', '👝', '🎒', '👞', '👟', '👠', '👡'],
					['👢', '👑', '👒', '🎩', '🎓', '⛑', '💄'], 
					['🙈', '🙉', '🙊', '🐵', '🐶', '🉑', '🏓'],
					],
			}
		},
		methods: {
			//获取表情并发送
			clickEmoji:function(e){
				this.$emit('emotion',e);
			}
		}
	}
</script>

<style lang="scss">
	.emoji{
		width: 100%;
		height: 460rpx;
		padding: 16rpx 10rpx 180rpx 10rpx;
		box-sizing: border-box;
		overflow: hidden;
		overflow-y: auto;
		.emoji-line{
			display: flex;
			padding-top: 20rpx;
			.emoji-line-item{
				flex:1;
				text-align: center;
				font-size: 50rpx;
				line-height: 68rpx;
			}
		}
	}
</style>
