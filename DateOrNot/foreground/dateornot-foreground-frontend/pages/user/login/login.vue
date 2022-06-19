<template>
	<view>
		<cmd-nav-bar back title="用户登录" rightText="注册" @rightText="fnRegisterWin"></cmd-nav-bar>
		<cmd-page-body type="top">
			<view class="login">
				<!-- <img src="http://localhost:8080/img/profile.jpg" alt="" /> -->
				<!-- 上部分 start -->
				<view class="login-title">{{ '使用账号密码登录'}}</view>
				<view class="login-explain">{{ '未注册用户可通过点击右上角进行注册'}}</view>
				<!-- 上部分 end -->

				<!-- 账号表单登录 start -->
				<cmd-transition name="fade-up">
					<view v-if="status">
						<view class="login-account">
							<cmd-input v-model="account.account" type="text" focus maxlength="26" placeholder="请输入账号">
							</cmd-input>
						</view>
						<view class="login-password">
							<cmd-input v-model="account.password" type="password" displayable maxlength="26"
								placeholder="请输入密码"></cmd-input>
						</view>
						<button class="btn-login" :class="loginAccount ? 'btn-login-active':''"
							:disabled="!loginAccount" hover-class="btn-login-hover" @tap="fnLogin">登录</button>
					</view>
				</cmd-transition>
				<!-- 账号表单登录 end -->
			</view>
		</cmd-page-body>
	</view>
</template>
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

<script>
	import cmdNavBar from "../../../components/cmd-nav-bar/cmd-nav-bar.vue"
	import cmdPageBody from "../../../components/cmd-page-body/cmd-page-body.vue"
	import cmdTransition from "../../../components/cmd-transition/cmd-transition.vue"
	import cmdInput from "../../../components/cmd-input/cmd-input.vue"
	import axios from "../../axios.min.js"
	import { localStorage,sessionStorage } from '@/commons/mp-storage/mp-storage/index.js'
	import datas from '@/commons/js/datas.js';

	// import axios from 'axios';
	// Vue.prototype.$axios = axios;
	
	export default {
		components: {
			cmdNavBar,
			cmdPageBody,
			cmdTransition,
			cmdInput
		},

		data() {
			return {
				// 请求的地址
				baseUrl01: "http://1.14.43.96:8080",
				// 账号登录部分数据
				// id:"",
				account: {
					account: '',
					password: ''
				},
				
				accountReg: /^[A-Za-z0-9]+$/,
				passwordReg: /^\w+$/,
				loginAccount: false,
				safety: {
					time: 60,
					state: false,
					interval: ''
				},
				asdf:"asdf",
				
				status: true ,// true账号登录 TODO 这个没有作用了
				
			};
		},

		watch: {
			/**
			 * 监听账号登录数值
			 */
			account: {
				handler(newValue) {
					if ((this.accountReg.test(newValue.account) && newValue.account.length >= 3) && (this.passwordReg
							.test(
								newValue.password) && newValue.password.length >= 8)) {
						this.loginAccount = true;
					} else {
						this.loginAccount = false
					}
				},
				deep: true
			}
		},
		// onShow() {
		// 	this.getUserInfo();
		// },
		methods: {
			/*
			返回json解析
			
			*/ 
		   resAnysis(resp){
			   console.log(resp);
			   console.log(resp.login_status);
		   },
		  
			// inputAccount(e){
			// 	id = e.target.value
			// },
		   
			/**
			 * 登录按钮点击执行 [向后台api发送 this.account]
			 */
			fnLogin() {
				let that = this;
				console.log(JSON.stringify(this.account));
				// var navData = JSON.stringify(that.$data.account.account); // 这里转换成 字符串
				var route = "/user/login";
				if (this.status) { // this.status,没有作用了
					
					uni.request({
						url:this.baseUrl01 + route,
						method:'POST',
						data:{
							account: this.account.account,
							password: this.account.password
						},
						success(response) {
							if(response.data.login_status==300){
								let user = response.data.user
								console.log(response.data)
								// 获取完整信息，存入globalData
								let globalDataUserInfo = {
									userID: user.user_id,
									account: user.account,
									username: user.user_name,
									sex: user.sex,
									headImageUrl: user.head_image_url,
									birthday: user.birthday,
									introduction: user.introduction,
									school: user.school
								}
								getApp().globalData.userInfo = globalDataUserInfo
								
								var user2 = {
									uid : user.user_id,
									uname : user.user_name,
									headUrl : user.head_image_url
								};
								
								sessionStorage.setItem('user',JSON.stringify(user2));
								console.log(sessionStorage.getItem("user"))
								sessionStorage.setItem('uid',user.user_id);
								localStorage.setItem('uid',user.user_id);
								console.log(sessionStorage.getItem('uid'));
								
								that.$websocket.commit('setUid',user.user_id);
								
								that.$websocket.dispatch('init');
								// storage
								uni.setStorageSync("userInfo", user)
								uni.switchTab({
									url:'../../self/self'
								})
								// uni.navigateTo({
								// 	url:'../../bottom-nav/index?account='+that.$data.account.account
								// });
								// uni.$emit("fnLogin",{data:account});
							} else{
								uni.showToast({
									title: '账号或密码错误！',
									icon:'none',
									duration: 2000
								});
							}
						}
					})
					// axios.post(that.$data.baseUrl01+route, { //get|post可选，用对象{ }传递数据，如果不传递数据，可缺省{ }。get方式参数也可以拼接在url中
					// 	account: that.$data.account.account, //通常是获取表单数据，$('#xxx').val
					// 	password: that.$data.account.password
					// }).then(function(response) { //处理后台返回的数据。 // 根据返回的数据进行处理
						
					// 	// uni.setStorageSync("account",that.$data.account.account);
						
						
						
					// 	if(response.data.login_status==300){
					// 		let user = response.data.user
					// 		// 获取完整信息，存入globalData
					// 		let globalDataUserInfo = {
					// 			userID: user.user_id,
					// 			account: user.account,
					// 			username: user.username,
					// 			sex: user.sex,
					// 			headImageUrl: user.head_image_url,
					// 			birthday: user.birthday,
					// 			introduction: user.introduction,
					// 			school: user.school
					// 		}
					// 		getApp().globalData.userInfo = globalDataUserInfo
					// 		// storage
					// 		uni.setStorageSync("user", user)
					// 		uni.switchTab({
					// 			url:'../../self/self'
					// 		})
					// 		// uni.navigateTo({
					// 		// 	url:'../../bottom-nav/index?account='+that.$data.account.account
					// 		// });
					// 		// uni.$emit("fnLogin",{data:account});
					// 	} else{
					// 		uni.showToast({
					// 			title: '账号或密码错误！',
					// 			icon:'none',
					// 			duration: 2000
					// 		});
					// 	}
						
					// })
					// .catch(function(error) { //发生错误时的处理
					// 	console.log("found error: " + error);
					// });

				}
			},
			
			/**
			 * 跳转注册页面
			 */
			fnRegisterWin() {
				uni.navigateTo({
					url: "/pages/user/register/register"
				})
				/**
				 * 改变状态重置，跳转不会摧毁实例
				 */
				// this.fnChangeStatus(true);
			}
		},
		

		beforeDestroy() {
			/**
			 * 关闭页面清除轮询器
			 */
			clearInterval(this.safety.interval);
		}
	}
</script>

<style>
	.login {
		margin-top: 56upx;
		margin-right: 72upx;
		margin-left: 72upx;
	}

	.login-title {
		font-size: 56upx;
		font-weight: 500;
	}

	.login-explain {
		font-size: 28upx;
		color: #9E9E9E;
	}

	.login-phone {
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
		border-bottom: 2upx #dedede solid;
		margin-top: 56upx;
		margin-bottom: 40upx;
	}

	.login-phone-getcode {
		color: #3F51B5;
		text-align: center;
		min-width: 140upx;
	}

	.login-code {
		border-bottom: 2upx #dedede solid;
	}

	.login-account {
		margin-top: 56upx;
		margin-bottom: 40upx;
		border-bottom: 2upx #dedede solid;
	}

	.login-password {
		border-bottom: 2upx #dedede solid;
	}

	.btn-login {
		margin-top: 100upx;
		border-radius: 50upx;
		font-size: 16px;
		color: #fff;
		background: linear-gradient(to right, #88a1f9, #9ac6ff);
	}

	.btn-login-active {
		background: linear-gradient(to right, #365fff, #36bbff);
	}

	.btn-login-hover {
		background: linear-gradient(to right, #365fdd, #36bbfa);
	}

	button[disabled] {
		color: #fff;
	}

	.login-mode {
		text-align: center;
		margin-top: 32upx;
	}
</style>
