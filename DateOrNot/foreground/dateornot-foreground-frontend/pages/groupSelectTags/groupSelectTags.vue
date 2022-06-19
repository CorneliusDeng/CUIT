<template>
	<view>
		<view class="title-wrapper">
			<text class="title">选择群标签</text>
			<image src="../../static/refresh.png" class="refresh" @click="getRandomTags()"></image>
		</view>
		<view class="charts-box">
			<qiun-data-charts type="word" @getIndex="selectTag" :chartData="wordCloudData" :animation="true" />
		</view>
		<view class="small-wrapper">
			<text class="small-title">已选标签：({{selectedTags.length}}/10)</text>
		</view>
		<view class="tag-wrapper">
			<uni-tag v-for="tag in selectedTags" class="group-tag" :text="tag.content" size="small" type="success" @click="removeTag(tag.tagId)"></uni-tag>
		</view>
		<view class="button-wrapper">
			<button type="primary" @click="confirm">确认</button>
		</view>
		<text class="exit-link" @click="exit">返回</text>
	</view>
</template>

<script>
	import Config from '../config.js'
	export default {
		data() {
			return {
				selectedTags: [],
				wordCloudData: {
					categories: [],
					series: []
				}
			}
		},
		onLoad(option){
			this.selectedTags = JSON.parse(option.groupTags)
			
		},
		mounted() {
			this.selectedTags = JSON.parse(uni.getStorageSync("groupTags"))
			console.log(this.selectedTags)
			this.getRandomTags()
		},
		methods: {
			getRandomTags(){
				let _this = this
				uni.request({
					url:Config.baseUrl + '/tag/random',
					method:'GET',
					data:{
						limit: 20
					},
					success: (res)=>{
						_this.wordCloudData.series = []
						for(let i = 0; i < res.data.length; i++){
							_this.wordCloudData.series.push({
								tagId: res.data[i].tag_id,
								name: res.data[i].content,
								textSize: 20
							})
						}
					}
				})
			},
			selectTag(e){
				let index = e.currentIndex
				let tag = {
					tagId: this.wordCloudData.series[e.currentIndex].tagId,
					content: this.wordCloudData.series[e.currentIndex].name
				}
				if(this.selectedTags.length < 10){
					let flag = false
					for(let i = 0; i < this.selectedTags.length; i++){
						if(this.selectedTags[i].tagId===tag.tagId){
							flag = true
							break
						}
					}
					if(flag == false){
						this.selectedTags.push(tag)
					}
				}
			},
			removeTag(tagId){
				for(let i = 0; i < this.selectedTags.length; i++){
					if(this.selectedTags[i].tagId==tagId){
						this.selectedTags.splice(i, 1)
						break
					}
				}
			},
			confirm(){
				uni.setStorageSync("groupTags", JSON.stringify(this.selectedTags))
				uni.navigateBack({
					
				})
			},
			
			exit(){
				uni.navigateBack({
					
				})
			}
		}
	}
</script>
<style src="./groupTags.css"></style>
<style>

</style>
