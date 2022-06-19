<template>
	<view>
		<cmd-nav-bar back title="用户注册"></cmd-nav-bar>
		<cmd-page-body type="top">
			<view class="register">
				<view class="register-title">{{'注册'}}</view>
				<!-- 账号表单注册 start -->
				<!-- #ifdef H5 -->
				<cmd-transition name="fade-up">
					<view v-if="status">
						<view class="register-account">
							<cmd-input v-model="account.account" type="text" focus maxlength="26" placeholder="请输入账号">
							</cmd-input>
						</view>
						<view class="register-password">
							<cmd-input v-model="account.password" type="password" displayable maxlength="26"
								placeholder="请输入密码"></cmd-input>
						</view>
						<button class="btn-register" :class="registerAccount ? 'btn-register-active':''"
							:disabled="!registerAccount" hover-class="btn-register-hover" @tap="fnRegister">注册</button>
					</view>
				</cmd-transition>
				<!-- #endif -->
				<!-- #ifndef H5 -->
				<cmd-transition name="fade-up" v-if="status">
					<view class="register-account">
						<cmd-input v-model="account.account" type="text" focus maxlength="26" placeholder="请输入账号">
						</cmd-input>
					</view>
					<view class="register-password">
						<cmd-input v-model="account.password" type="password" displayable maxlength="26"
							placeholder="请输入密码"></cmd-input>
					</view>
					<button class="btn-register" :class="registerAccount ? 'btn-register-active':''"
						:disabled="!registerAccount" hover-class="btn-register-hover" @tap="fnRegister">注册</button>
				</cmd-transition>
				<!-- #endif -->
				<!-- 账号表单注册 end -->
			</view>
		</cmd-page-body>
	</view>

</template>
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
	import cmdNavBar from "@/components/cmd-nav-bar/cmd-nav-bar.vue"
	import cmdPageBody from "@/components/cmd-page-body/cmd-page-body.vue"
	import cmdTransition from "@/components/cmd-transition/cmd-transition.vue"
	import cmdInput from "@/components/cmd-input/cmd-input.vue"
	import axios from "../../axios.min.js"
	
	
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
				account: {
					account: '',
					password: ''
				},
				accountReg: /^[A-Za-z0-9]+$/,
				passwordReg: /^\w+$/,
				registerAccount: false,
				registerMobile: false,
				safety: {
					time: 60,
					state: false,
					interval: ''
				},
				status: true // true账号注册
			};
		},

		watch: {
			/**
			 * 监听账号注册数值
			 */
			account: {
				handler(newValue) {
					if ((this.accountReg.test(newValue.account) && newValue.account.length >= 8) && (this.passwordReg
							.test(
								newValue
								.password) && newValue.password.length >= 8)) {
						this.registerAccount = true;
					} else {
						this.registerAccount = false
					}
				},
				deep: true
			}
		},

		methods: {
			/**
			 * 注册按钮点击执行[向后台api发送 this.account]
			 */
			fnRegister() {
				// if (this.status) {
				// 	// console.log(JSON.stringify(this.$data.account));


				// 	console.log(response); //response是后台返回的整个响应
				// 	console.log(response.data); //.data才是后台返回的数据
				// 	console.log(response.data.login_status);


				// }
				// console.log(JSON.stringify(this.account));
				var route = "/user/register";
			
				if (this.status) { // this.status,没有作用了
					
					uni.request({
						url: this.$data.baseUrl01 + route,
						method:'POST',
						data:{
							account: this.$data.account.account, //通常是获取表单数据，$('#xxx').val
							password: this.$data.account.password
						},
						success(response){
							console.log(response); //response是后台返回的整个响应
							console.log(response.data); //.data才是后台返回的数据
							console.log(response.data.register_status);
							if(response.data.register_status == 302){
								uni.showToast({
									title:'注册成功!正在返回登录页面',
									duration:1000
								});
								
								setTimeout(function() {
										uni.navigateTo({
											url:'../login/login'
										})
									}, 1000);
							} else {
								uni.showToast({
									title:'用户已存在！',
									duration:1000,
									icon:'none'
								})
							}
						}
					})
				
					// axios.post(this.$data.baseUrl01 + route, { //get|post可选，用对象{ }传递数据，如果不传递数据，可缺省{ }。get方式参数也可以拼接在url中
					// 	account: this.$data.account.account, //通常是获取表单数据，$('#xxx').val
					// 	password: this.$data.account.password
					
					// }).then(function(response) { //处理后台返回的数据。 // 根据返回的数据进行处理
					

					// 	console.log(response); //response是后台返回的整个响应
					// 	console.log(response.data); //.data才是后台返回的数据
					// 	console.log(response.data.login_status);
					// 	if(response.data.login_status == 302){
					// 		uni.showToast({
					// 			title:'注册成功!正在返回登录页面',
					// 			duration:1000
					// 		});
							
					// 		setTimeout(function() {
					// 				uni.navigateTo({
					// 					url:'../login/login'
					// 				})
					// 			}, 1000);
					// 	} else {
					// 		uni.showToast({
					// 			title:'用户已存在！',
					// 			duration:1000,
					// 			icon:'none'
					// 		})
					// 	}


					// }).catch(function(error) { //发生错误时的处理
					// 	console.log(error);
					// });



				}
			},
			beforeDestroy() {
				/**
				 * 关闭页面清除轮询器
				 */
				clearInterval(this.safety.interval);
			}
		}
	}
</script>

<style>
	.register {
		margin-top: 56upx;
		margin-right: 72upx;
		margin-left: 72upx;
	}

	.register-title {
		font-size: 56upx;
		font-weight: 500;
	}

	.register-explain {
		font-size: 28upx;
		color: #9E9E9E;
	}

	.register-phone {
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
		border-bottom: 2upx #dedede solid;
		margin-top: 56upx;
		margin-bottom: 40upx;
	}

	.register-phone-getcode {
		color: #3F51B5;
		text-align: center;
		min-width: 140upx;
	}

	.register-code {
		border-bottom: 2upx #dedede solid;
	}

	.register-account {
		margin-top: 56upx;
		margin-bottom: 40upx;
		border-bottom: 2upx #dedede solid;
	}

	.register-password {
		border-bottom: 2upx #dedede solid;
	}

	.btn-register {
		margin-top: 100upx;
		border-radius: 50upx;
		font-size: 16px;
		color: #fff;
		background: linear-gradient(to right, #88a1f9, #9ac6ff);
	}

	.btn-register-active {
		background: linear-gradient(to right, #365fff, #36bbff);
	}

	.btn-register-hover {
		background: linear-gradient(to right, #365fdd, #36bbfa);
	}

	button[disabled] {
		color: #fff;
	}

	.register-mode {
		text-align: center;
		margin-top: 32upx;
	}
</style>
