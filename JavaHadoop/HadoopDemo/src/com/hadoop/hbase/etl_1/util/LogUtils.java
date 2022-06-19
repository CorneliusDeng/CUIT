package com.hadoop.hbase.etl_1.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.hadoop.hbase.etl_1.util.IPSeekerExt.RegionInfo;
import com.hadoop.hbase.etl_1.constants.EventLogConstants;
import com.hadoop.hbase.etl_1.constants.GlobalConstants;

import cz.mallat.uasparser.UserAgentInfo;


public class LogUtils {
	/**
	 *  
	 * @param string
	 * @return
	 */
	public static String dateProcess(String string) {
		String xx = string.split(":")[0].substring(1);
		
		return xx;
	}

	public static void processsInfo(String msg, HashMap<String, String> maps) {
		String baseAll = msg.substring(msg.indexOf("?") + 1);
		String query[] = baseAll.split("&");
		for (String qu : query) {
			String array[] = qu.split("=");
			if (array.length > 1) {
				try {
					String key = array[0];
					String value = URLDecoder.decode(array[1], "UTF-8");
					if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
						maps.put(key, value);
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * //192.168.0.123 - - [01/Mar/2017:20:29:25 +0800]
	 * "GET /linuxWeb/StuServlet?en=e_pv&p_url=http%3A%2F%2Flocalhost%3A8080%2FBIG_DATA_LOG2%2Fdemo.jsp&p_ref=http%3A%2F%2Flocalhost%3A8080%2FBIG_DATA_LOG2%2Fdemo2.jsp&tt=%E6%B5%8B%E8%AF%95%E9%A1%B5%E9%9D%A21&ver=1&pl=website&sdk=js&u_ud=550DE3C3-3923-4C36-BDBD-45784A6E314E&u_mid=laoxiao&u_sd=BDADFCF7-AD57-45E6-8418-6742A0233E25&c_time=1488371364733&b_iev=Mozilla%2F5.0%20(compatible%3B%20MSIE%2010.0%3B%20Windows%20NT%206.1%3B%20WOW64%3B%20Trident%2F7.0%3B%20LCTE)&b_rst=1366*768 HTTP/1.1"
	 * 200
	 
	 */
	public static void handler(String msg, HashMap<String, String> maps) {
		if (StringUtils.isNotBlank(msg)) {
			String split[] = msg.split(" ");
			//System.out.println(split.length+" ==========================================================");
			if (split.length == 10) {
				maps.put(EventLogConstants.LOG_COLUMN_NAME_IP, split[0]);//得到IP
				maps.put(EventLogConstants.LOG_COLUMN_NAME_SERVER_TIME, dateProcess(split[3]));//得到日期
				
				processsInfo(split[6], maps);//把？后边的所有kv对存入maps
				
				processUserAgent(maps);//处理浏览器，把useragent转换成浏览器信息
				
				processsIp(maps);//处理ip,把ip转换成城市
			}
		}
	}

	private static void processsIp(HashMap<String, String> maps) {
		
		String ip = maps.get(EventLogConstants.LOG_COLUMN_NAME_IP);
		
		IPSeekerExt ipSeekerExt = new IPSeekerExt();
		RegionInfo info = ipSeekerExt.analyticIp(ip);
		if (info != null) {
			maps.put(EventLogConstants.LOG_COLUMN_NAME_COUNTRY, info.getCountry());
			maps.put(EventLogConstants.LOG_COLUMN_NAME_CITY, info.getCity());
			maps.put(EventLogConstants.LOG_COLUMN_NAME_PROVINCE, info.getProvince());
		}

	}

	public static void processUserAgent(HashMap<String, String> maps) {
		String userAgent = maps.get(EventLogConstants.LOG_COLUMN_NAME_USER_AGENT);
		if (StringUtils.isNotBlank(userAgent)) {
			UserAgentInfo userAgentInfo = UserAgentUtils.getUserAgentInfo(userAgent);
			maps.put(EventLogConstants.LOG_COLUMN_NAME_BROWSER_NAME, userAgentInfo.getUaFamily());
			maps.put(EventLogConstants.LOG_COLUMN_NAME_BROWSER_VERSION, userAgentInfo.getBrowserVersionInfo());
			maps.put(EventLogConstants.LOG_COLUMN_NAME_OS_NAME, userAgentInfo.getOsFamily());
			maps.put(EventLogConstants.LOG_COLUMN_NAME_OS_VERSION, userAgentInfo.getOsName());

		}

	}

	public static void main(String[] args) {
		String date = "/linuxWeb/StuServlet?en=e_pv&p_url";
		System.out.println(date.split("&")[0]);
	}
}
