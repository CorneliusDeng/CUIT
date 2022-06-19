<template>
	<view>
		<view class="backgroud-setting">
		</view>
		<view class="person-context">
			<view class="top-avator" >
				<view class="person-head">
					<cmd-avatar :src="avator" @click="fnInfoWin" size="lg" ></cmd-avatar>
						<view class="person-head-box">
							<view class="person-head-nickname">{{uname}}</view>
							<view class="person-head-UID">{{account}}</view>
							
						</view>
				</view>
			</view>
			<view class="person-list">
				<cmd-cell-item title="我的动态" slot-left arrow>
					<cmd-icon type="home" size="24" color="#368dff"></cmd-icon>
				</cmd-cell-item>
				<cmd-cell-item title="我赞过" slot-left arrow>
					<cmd-icon type="heart" size="24" color="#368dff"></cmd-icon>
				</cmd-cell-item>
				<cmd-cell-item title="消息通知" slot-left arrow>
					<cmd-icon type="message" size="24" color="#368dff"></cmd-icon>
				</cmd-cell-item>
				<cmd-cell-item title="信息设置" @click="fnInfoWin('fnInfo')" slot-left arrow>
					<cmd-icon type="settings" size="24" color="#368dff"></cmd-icon>
				</cmd-cell-item>
			</view>
		</view>
		
	</view>
</template>

<script>
	import cmdAvatar from "@/components/cmd-avatar/cmd-avatar.vue"
	import cmdIcon from "@/components/cmd-icon/cmd-icon.vue"
	import cmdCellItem from "@/components/cmd-cell-item/cmd-cell-item.vue"
	import axios from "../../axios.min.js" // 导入 axios


	export default {
		components: {
			cmdAvatar,
			cmdCellItem,
			cmdIcon
		},
		data() {
			return {
				baseUrl01: "http://1.14.43.96:8080", // baseUrl,route 以 “/"开头
				baseUrl02: "http://1.14.43.96:8080/img/", // baseUrl,route 以 “/"开头
				avator01: "",
				head_image_url:"",
				avator: "",
				account:"",
				
				
				uname:"",
			};
		},
		onShow() {
			// this.getUserInfo();
			this.getUserInfo();
			// account = option.account
		},
		
		methods: {
			/**
			 * 
			 * 打开用户信息页
			 */
			fnInfoWin() {
				uni.navigateTo({
					
					url: '/pages/user/info/info'
				})
			},
			getUserInfo() {
				let that = this;
				var route = "/user/getuser";
				
			
				var userinfo = uni.getStorageSync('userinfo');
				// var account = userinfo.account;
				// console.log("@#@#@$@#$@#$"+JSON.stringify(userinfo))
				var account = uni.getStorageSync("account");
				var uname = userinfo.user_name;
				var avator = userinfo.head_image_url;
				
				this.$data.uname = uname;
				this.$data.account = account;
				this.$data.avator = this.$data.baseUrl02 + avator;
				
				
				// console.log("3215632165135461354664"+account);
				// axios.post(this.$data.baseUrl01 + route, { //get|post可选，用对象{ }传递数据，如果不传递数据，可缺省{ }。get方式参数也可以拼接在url中
				// 	// account: this.$data.account, //通常是获取表单数据，$('#xxx').val
				// 	account: account, //通常是获取表单数据，$('#xxx').val
				// }).then(this.getUserData);
				axios.post(this.$data.baseUrl01 + route, { //get|post可选，用对象{ }传递数据，如果不传递数据，可缺省{ }。get方式参数也可以拼接在url中
					// account: this.$data.account, //通常是获取表单数据，$('#xxx').val
					account: account, //通常是获取表单数据，$('#xxx').val
				}).then(this.getUserData);
				

			},
			getUserData(resUser) {
				console.log("########"+JSON.stringify(resUser.data.user));
				resUser = resUser.data.user;
				this.$data.avator = this.$data.baseUrl02 + resUser.head_image_url;
				// 应当先从缓存中判断没有，clear所有，再装入缓存。// 缓存同步与异步的优缺点。异步缓存的使用方式。
				uni.setStorageSync('userinfo', resUser); // 同步存入userinfo缓存
				
			}
		},
		
	}
</script>

<style>
	.backgroud-setting {
		position: relative;
		width:100%;
		height: 100%;
		/* z-index: !important; */
		/* opacity: 0.1; */
	}
	.person-context{
		width: 100%;
		position: absolute;
		top: 0px;
		/* opacity: 0.8; */
	}
	.person-context{
		background-image: url(../../../static/backimg.png);
	}
	.person-head {
		display: flex;
		flex-direction: row;
		align-items: center;
		height: 150px;
		padding-left: 20px;
		/* background: linear-gradient(to right, #365fff, #36bbff); */
	}

	.person-head-box {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: flex-start;
		margin-left: 10px;
	}

	.person-head-nickname {
		font-size: 18px;
		font-weight: 500;
		color: #fff;
	}

	.person-head-UID {
		font-size: 14px;
		font-weight: 500;
		color: #fff;
	}

	.person-list {
		line-height: 0;
	}
</style>
