export default {
	//缓存数据
	userData:function(){
		let userData = {
			"userID": 666,
			"name": "阿彪",
			"url": "https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/abiao.jpg",
			"msgList": {
				"777": {
					"id": 777,
					"name": "邓棋",
					"url": "https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/dq.jpg",
					"news": "今天好",
					"time":new Date(),
					"tip": 5
				},
				"888": {
					"id": 888,
					"name": "武帅",
					"url": "https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/wushuai.jpg",
					"news": "今天好",
					"time":new Date(),
					"tip": 5
				}
			},
			"msgDetail": {
				"777": {
					"id": 777,
					"name": "邓棋",
					"url": "https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/dq.jpg",
					"msgs": [
						{
							"uid":777,
							"uname": "邓棋",
							"url": "https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/dq.jpg",
							"msg": "你好啊",
							"time": new Date()-1000*60*10,
							"type": 'text',
						}
					]
				},
				"888": {
					"id": 888,
					"name": "武帅",
					"url": "https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/wushuai.jpg",
					"msgs": [
						{
							"uid":888,
							"uname": "武帅",
							"url": "https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/wushuai.jpg",
							"msg": "你好啊",
							"time": new Date()-1000*60*10,
							"type": 'text',
						}
					]
				}
			}
		}
		return userData;
	}
}