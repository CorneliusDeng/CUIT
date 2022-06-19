export default {
	// 首页时间转化
	datetime(e) {
		let old = new Date(e);
		let now = new Date();
		// 获取old具体时间
		let d = old.getTime();
		let h = old.getHours();
		let m = old.getMinutes();
		let Y = old.getUTCFullYear();
		let M = old.getMonth() + 1;
		let D = old.getDate();
		// 获取now具体时间
		let nd = now.getTime();
		let nh = now.getHours();
		let nm = now.getMinutes();
		let nY = now.getUTCFullYear();
		let nM = now.getMonth() + 1;
		let nD = now.getDate();
		// 当天时间 昨天时间 大于两天
		if (D === nD && Y === nY && nM === M) {
			if (h < 10) {
				h = '0' + h;
			}
			if (m < 10) {
				m = '0' + m;
			}
			return h + ":" + m;
		} else if (D + 1 === nD && Y === nY && nM === M) {
			if (h < 10) {
				h = '0' + h;
			}
			if (m < 10) {
				m = '0' + m;
			}
			return '昨天' + h + ":" + m;
		} else {
			return Y + '/' + M + '/' + D;
		}

	},
	//聊天时间
	datetime1(e) {
		let old = new Date(e);
		let now = new Date();
		// 获取old具体时间
		let d = old.getTime();
		let h = old.getHours();
		let m = old.getMinutes();
		let Y = old.getUTCFullYear();
		let M = old.getMonth() + 1;
		let D = old.getDate();
		// 获取now具体时间
		let nd = now.getTime();
		let nh = now.getHours();
		let nm = now.getMinutes();
		let nY = now.getUTCFullYear();
		let nM = now.getMonth() + 1;
		let nD = now.getDate();
		// 当天时间 昨天时间 大于两天
		if (D === nD && Y === nY && nM === M) {
			if (h < 10) {
				h = '0' + h;
			}
			if (m < 10) {
				m = '0' + m;
			}
			return h + ":" + m;
		} else if (D + 1 === nD && Y === nY && nM === M) {
			if (h < 10) {
				h = '0' + h;
			}
			if (m < 10) {
				m = '0' + m;
			}
			return '昨天' + h + ":" + m;
		} else if (Y === nY) {
			//今年
			if (h < 10) {
				h = '0' + h;
			}
			if (m < 10) {
				m = '0' + m;
			}
			return M + '月' + D + '日' + h + ':' + m;
		} else {
			//大于今年
			if (h < 10) {
				h = '0' + h;
			}
			if (m < 10) {
				m = '0' + m;
			}
			return Y + '年' + M + '月' + D + '日' + h + ':' + m;
		}

	},
	//间隔时间差
	spacTime(old, now) {
		old = new Date(old);
		now = new Date(now);
		var told = old.getTime();
		var tnow = now.getTime();
		if (told > (tnow + 1000 * 60 * 5)) {
			return now;
		} else {
			return '';
		}
	},
	// 详细时间
	detailtime(e) {
		let old = new Date(e);
		// 获取具体时间
		let d = old.getTime();
		let h = old.getHours();
		let m = old.getMinutes();
		let Y = old.getUTCFullYear();
		let M = old.getMonth() + 1;
		let D = old.getDate();

		// 处理时间
		if (M < 10) {
			M = '0' + M;
		}
		if (D < 10) {
			D = '0' + D;
		}
		if (h < 10) {
			h = '0' + h;
		}
		if (m < 10) {
			m = '0' + m;
		}
		return Y + '-' + M + '-' + D + ' ' + h + ':' + m;
	},
}
