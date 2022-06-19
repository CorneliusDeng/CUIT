<template>
	<view>
		<!-- TODO 头像上传的 app端功能，前端没有实现，不会。后端接口已经写好。数据库中，保存用户头像，保存文件名还是媒体资源服务器的，图片的全网络路径，待协商决定 -->
		<cmd-nav-bar back title="信息设置"></cmd-nav-bar>
		<cmd-page-body type="top">
			<cmd-transition name="fade-up">
				<view>
					<cmd-cel-item title="头像" slot-right arrow @click="fnUpimg">
						<!-- avator是用户登陆的头像也就是未更改时的头像 head_image_url是用户更改后的头像 -->
						<cmd-avatar :src="avator || head_image_url"></cmd-avatar>
					</cmd-cel-item>
					<cmd-cel-item title="昵称" :addon="uname"></cmd-cel-item>
					<cmd-cel-item title="账号" :addon="account" hover-class="cel-item-hover"></cmd-cel-item>
					<picker mode="selector" :value="setGender" :range="array" @change="bindPickerChange">
						<cmd-cel-item title="性别" :addon="gender" arrow></cmd-cel-item>
					</picker>

					<picker mode="date" :value="setBirthday" start="1930-01-01" end="endDate" @change="bindDateChange">
						<cmd-cel-item title="生日" :addon="birthday" arrow></cmd-cel-item>
					</picker>
					<cmd-cel-item title="标签" :addon="tag"></cmd-cel-item>
					<cmd-cel-item title="简介" :addon="introduction"></cmd-cel-item>
					<cmd-input placeholder="      一句话介绍" type="text" v-model="soul" focus clearable></cmd-input>
					<cmd-cel-item title="修改密码" @click="fnClick('modify')" arrow></cmd-cel-item>

					<button class="btn-save-info" @click="saveInfo()">保存修改</button>

					<button class="btn-logout" @click="fnClick('logout')">退出登录</button>
				</view>
			</cmd-transition>
		</cmd-page-body>
	</view>
</template>

<script>
	import cmdNavBar from "@/components/cmd-nav-bar/cmd-nav-bar.vue"
	import cmdPageBody from "@/components/cmd-page-body/cmd-page-body.vue"

	import cmdTransition from "@/components/cmd-transition/cmd-transition.vue"
	import cmdCelItem from "@/components/cmd-cell-item/cmd-cell-item.vue"
	import cmdAvatar from "@/components/cmd-avatar/cmd-avatar.vue"
	import axios from "../../axios.min.js"
	export default {
		components: {
			cmdNavBar,
			cmdPageBody,
			cmdTransition,
			cmdCelItem,
			cmdAvatar
		},

		data() {
			return {
				baseUrl01: "http://1.14.43.96:8080",
				baseUrl02: "http://1.14.43.96:8080/img/",
				head_image_url:"",
				avator: "",
				uname: "",
				account: "",
				setGender: "",
				tag: "普通用户",// 外联查询，我不会。
				setBirthday: "",
				birthday: "",
				introduction: "",
				gender: "", //0女性 1 男性
				array: [
					"男","女"
				],

				soul: '',
			};
		},

		onShow() {
			this.getUserinfoStorage();

		},

		methods: {
			//
			startDate:function(){
				return this.getDate('start')
			},
			
			endDate:function() {
				return this.getDate('end')
			},
			//改变日期
			bindDateChange: function(e) {
				this.birthday = e.target.value
				 
			},
			//性别改变
			bindPickerChange: function(e) {
				console.log('picker发送选择改变，携带值为', e.target.value)
				this.$data.gender = e.target.value == 1 ? "男" : "女";
			},
			//头像上传
			fnUpimg:function(e) {
				let that = this;
				uni.chooseImage({//打开手机本地相册
					count: 1,//只能选取一张照片
					sizeType: ['compressed'], //可以指定是原图还是压缩图，这里指定压缩图
						success: function(res) {  
							
							console.log(JSON.stringify(res.tempFilePaths));
							uni.uploadFile({//将本地资源上传到开发者服务器
								url:that.$data.baseUrl01+'/user/profileup', //接口地址
								filePath: res.tempFilePaths[0],//图片地址
								name: 'file',
								formData:{
									access_token:uni.getStorageSync('access_token'),//加入token
								},
								success: (uploadFileRes) => {
									
									let data = JSON.parse(uploadFileRes.data)
									if(data.code ==1){
										this.avator = data.data.url;//上传成功后返回的图片地址
									}
								}
							});
							
							
						}
				});
				
			},
			saveInfo() {
				var route = "/user/setinfo"

				var account = this.$data.account;
				var uname = this.$data.uname;
				var newGender = this.$data.gender == "男" ? 1 : 0;
				var newBirthday = this.$data.birthday;
				var newIntroduction = this.$data.introduction;
				var newSoul = this.$data.soul;

				/*
				
				  {
				        "account":"",
				        "birthday":"",
				        "sex":"",
				        "introduction":"",
				        "tag":"tag"
						
				        }
				
				*/
			   
				uni.request({
					url:this.$data.baseUrl01 + route,
					method:'POST',
					data:{
						account: account, //通常是获取表单数据，$('#xxx').val
						birthday: newBirthday,
						sex: newGender,
						introduction: newSoul,
					},
					success(res){
						console.log(res)
						uni.showToast({
							title:'修改成功'
						})
					}
				})
				// axios.post(this.$data.baseUrl01 + route, { //get|post可选，用对象{ }传递数据，如果不传递数据，可缺省{ }。get方式参数也可以拼接在url中
				// 	account: account, //通常是获取表单数据，$('#xxx').val
				// 	birthday: newBirthday,
				// 	sex: newGender,
				// 	introduction: newSoul,
				// 	// tag:newTag

				// }).then(function(response) {

				// }).catch(function(error) { //发生错误时的处理
				// 	console.log(error);
				// });



			},
			//获取当前时间
			getDate(type) {
				const date = new Date(); //此时获取时间为有年月日星期时分秒的一个集合
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();

				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			/**
			 * 点击触发
			 * @param {Object} type 跳转页面名或者类型方式
			 */
			fnClick(type) {
				if (type == 'modify') {
					uni.navigateTo({
						url: '/pages/user/modify/modify'
					})
				} else if (type == 'logout') {
					uni.clearStorageSync(); // 遍历清除比较OK
					uni.navigateTo({
						url: '../login/login'
					})
				}
			},
			//
			getUserinfoStorage() {
				var userinfo = uni.getStorageSync('userInfo'); // 同步得到userinfo缓存
				var uname = userinfo.user_name;
				var account = userinfo.account;
				
				// var tag = userinfo.tag;
				var tag = "普通用户";
				console.log(JSON.stringify(userinfo));
									// this.$data.baseUrl02 +
				this.$data.avator = userinfo.head_image_url;//头像是原始头像
				this.$data.uname = uname;
				this.$data.account = account;
				this.$data.tag = tag;
				this.$data.birthday = userinfo.birthday;
				this.$data.introduction = userinfo.introduction;
						
				if (userinfo.gender == 1) {
					this.$data.gender = "男";
				} else {
					this.$data.gender = "女";
				}

			}

		}
	}
</script>

<style>
	.btn-logout {
		margin-top: 80upx;
		width: 80%;
		border-radius: 50upx;
		font-size: 16px;
		color: #fff;
		background: linear-gradient(to right, #365fff, #36bbff);
	}

	.btn-save-info {
		margin-top: 80upx;
		width: 80%;
		border-radius: 50upx;
		font-size: 16px;
		color: #fff;
		background: linear-gradient(to right, #ffaa7f, #ffb7a5);
	}

	.btn-logout-hover {
		background: linear-gradient(to right, #365fdd, #36bbfa);
	}
</style>
