package com.zyyj.service.practice;

import java.util.List;

import com.zyyj.bean.StudentPractice;

public interface StudentPracticeService {
	
	List<StudentPractice> getAllStudentPractice();
	
	/**
	 * ��ȡ��������������������ݺ�ѡ���ȡ�������json
	 * @param input
	 * @param option
	 * @return
	 */
	String getSearchResult(String input, String option);
}
