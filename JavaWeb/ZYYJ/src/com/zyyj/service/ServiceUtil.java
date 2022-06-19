package com.zyyj.service;

import java.util.List;

public class ServiceUtil {
	
	public static String getNextId(String max_id, String prefix) {
		String next_id = max_id;
		int next = Integer.valueOf(max_id.substring(prefix.length() + 1)) + 1;
		if(next < 10) {
			next_id = prefix + "00" + next;
		}
		else if(next < 100) {
			next_id = prefix + "0" + next;
		}
		else {
			next_id = prefix + next;
		}
		return next_id;
	}
	
}
