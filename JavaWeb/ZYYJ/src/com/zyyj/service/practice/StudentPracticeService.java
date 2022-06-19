package com.zyyj.service.practice;

import java.util.List;

import com.zyyj.bean.StudentPractice;

public interface StudentPracticeService {
	
	List<StudentPractice> getAllStudentPractice();
	
	/**
	 * 获取搜索结果，发送搜索内容和选项，获取搜索结果json
	 * @param input
	 * @param option
	 * @return
	 */
	String getSearchResult(String input, String option);
}
