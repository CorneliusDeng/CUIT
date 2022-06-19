<script>
	import Config from 'pages/config.js'
	export default {
		onLaunch: function() {
			let app = getApp();
			uni.getSystemInfo({
				success: function(res) {
					app.globalData.systemInfo = res
				}
			});
			// 每10s更新一次位置
			setInterval(()=>{
				uni.getLocation({
					type:'gcj02',
					success(res){
						let user = uni.getStorageSync("userInfo")
						if(user != null){
							uni.request({
								url:Config.baseUrl + '/location',
								method:'POST',
								data:{
									userId: user.user_id,
									latitude: res.latitude,
									longitude: res.longitude
								},
								success(res){
									console.log('已更新定位')
								}
							})
						}
						
					}
				})
			}, 10000)
			// uni.request({
			// 	// url:'http://192.168.31.221:8081/getuser',
			// 	url: app.globalData.domain + "/getuser",
			// 	data: {
			// 		userID: 1
			// 	},
			// 	success(res) {
			// 		app.globalData.userInfo = res.data;
			// 		console.log("用户信息获取成功：")
			// 	},
			// 	fail() {
			// 		console.log("用户信息获取失败！");
			// 	}
			// })
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
			let user = uni.getStorageSync("userInfo")
			// 用户退出app后清除定位信息
			if(user != null){
				uni.request({
					url:Config.baseUrl + '/location/'+user.user_id,
					method:'DELETE',
					success(res){
						console.log("已清除用户位置信息")
					}
				})
			}
			
		},
		globalData: {
			systemInfo: {},
			userInfo: {},
			domain: "http://1.14.43.96:8081",
			transformTime: function(time) {
				let releaseTime = new Date(time);
				let now = new Date();
				let res = now.getTime() - releaseTime.getTime();
				res = Math.floor(res / 1000);
				if (res <= 60) {
					res = "刚刚";
				} else if (res <= 60 * 60) {
					res = Math.floor(res / 60) + "分钟前";
				} else if (res <= 60 * 60 * 24) {
					res = Math.floor(res / (60 * 60)) + "小时前";
				} else if (res <= 60 * 60 * 24 * 2) {
					res = "昨天";
				} else if (res <= 60 * 60 * 24 * 3) {
					res = "前天";
				} else {
					res = (releaseTime.getMonth() + 1) + "-" + releaseTime.getDate();
				}
				return res;
			}
		}
	}
</script>

<style>
	/*每个页面公共css */
</style>
