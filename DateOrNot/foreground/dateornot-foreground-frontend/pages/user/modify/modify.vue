<template>
	<view>
		<cmd-nav-bar back title="修改密码"></cmd-nav-bar>
		<cmd-page-body type="top">
			<cmd-transition name="fade-up">
				<view class="modify">
					<view class="modify-password">
						<cmd-input v-model="account.passwordOne" type="password" displayable maxlength="26"
							placeholder="请输入新密码"></cmd-input>
					</view>
					<view class="modify-password">
						<cmd-input v-model="account.passwordTwo" type="password" displayable maxlength="26"
							placeholder="请再次确认新密码"></cmd-input>
					</view>
					<view class="password-compare" style="color: red;" v-show="passwordCompare">
						{{'两次密码不一致'}}
					</view>
					<button class="btn-modify" :class="modifyPwd ? 'btn-modify-active':''" :disabled="!modifyPwd"
						hover-class="btn-modify-hover" @tap="fnModify">提交</button>
				</view>
			</cmd-transition>
		</cmd-page-body>
	</view>
</template>

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
				baseUrl01: "http://1.14.43.96:8080",
				account: {
					passwordOne: '',
					passwordTwo: '',
				},
				passwordReg: /^\w+$/,
				safety: {
					time: 60,
					state: false,
					interval: ''
				},
				modifyPwd: false,
				passwordCompare: false, // false，“两次密码不一致”，不显示；true，“两次密码不一致”，显示；
				userId: null
			};
		},
		onShow() {
			this.userId = uni.getStorageSync("userInfo").user_id
			console.log(uni.getStorageSync("userinfo") + "userinfo");
		},

		watch: {
			/**
			 * 监听表单数值
			 */
			account: {
				handler(newValue) {
					if ((this.passwordReg.test(newValue.passwordOne) && newValue.passwordOne.length >= 8) && (this
							.passwordReg.test(
								newValue
								.passwordTwo) && newValue.passwordTwo.length >= 8)) {
						this.modifyPwd = true;

					} else {
						this.modifyPwd = false
					}
				},


				deep: true
			}
		},

		methods: {
			/**
			 * 提交按钮点击执行
			 */
			fnModify() {
				var route = "/user/pwdremodify";
				// if (this.status) { // this.status,没有作用了
				// 密码两次确认只在app端，上传数据是明码，app没有验证转义，没有限制特殊符号【@#￥%/】，后台程序没有验证密码是否一致。故存在安全问题。
				if (this.$data.account.passwordTwo != this.$data.account.passwordOne) { // 密码不一致，“两次密码不一致”，显示
					this.$data.passwordCompare = true;
					return;
				} else {
					this.$data.passwordCompare = false; // 密码一致，“两次密码不一致”，不显示
					console.log(uni.getStorageSync("userinfo"));
					
					uni.request({
						url: this.$data.baseUrl01 + route,
						method:'POST',
						data:{
							account: this.$data.userId, // account=”11111111“，写死。account, 应该走app的缓存等等
							password: this.$data.account.passwordTwo
						},
						success(response){
							console.log(response)
							if (response.data.modify_status == 309) {
								uni.showToast({
									title: '修改失败，请重试！',
									icon: 'none',
									duration: 2000
								})
							} else {
								uni.showToast({
									title: '修改成功，记住密码哦(#^.^#)',
									icon: 'success',
									duration: 1000
								});
								setTimeout(function() {
									uni.navigateTo({
										url: '../info/info'
									})
								}, 1000);
							}
						}
					})
					// axios.post(this.$data.baseUrl01 + route, { //get|post可选，用对象{ }传递数据，如果不传递数据，可缺省{ }。get方式参数也可以拼接在url中

					// 	account: this.$data.account, // account=”11111111“，写死。account, 应该走app的缓存等等
					// 	password: this.$data.account.passwordTwo, // passwordOne = passwordTwo


					// }).then(function(response) { //处理后台返回的数据。 // 根据返回的数据进行处理
					// 	console.log(response); //response是后台返回的整个响应
					// 	console.log(response.data); //.data才是后台返回的数据
					// 	console.log(response.data.modify_status);
					// 	if (response.data.modify_status == 309) {
					// 		uni.showToast({
					// 			title: '修改失败，请重试！',
					// 			icon: 'none',
					// 			duration: 2000
					// 		})
					// 	} else {
					// 		uni.showToast({
					// 			title: '修改成功，记住密码哦(#^.^#)',
					// 			icon: 'success',
					// 			duration: 1000
					// 		});
					// 		setTimeout(function() {
					// 			uni.navigateTo({
					// 				url: '../info/info'
					// 			})
					// 		}, 1000);
					// 	}

					// }).catch(function(error) { //发生错误时的处理
					// 	console.log(error);
					// });
				}

			},
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
	.modify {
		margin-top: 118upx;
		margin-right: 72upx;
		margin-left: 72upx;
	}

	.modify-password,
	.modify-code {
		margin-bottom: 40upx;
		border-bottom: 2upx #dedede solid;
	}

	.btn-modify {
		margin-top: 100upx;
		border-radius: 50upx;
		font-size: 16px;
		color: #fff;
		background: linear-gradient(to right, #88a1f9, #9ac6ff);
	}

	.btn-modify-active {
		background: linear-gradient(to right, #365fff, #36bbff);
	}

	.btn-modify-hover {
		background: linear-gradient(to right, #365fdd, #36bbfa);
	}

	button[disabled] {
		color: #fff;
	}
</style>
