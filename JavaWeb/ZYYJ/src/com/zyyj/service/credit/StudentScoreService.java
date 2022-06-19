package com.zyyj.service.credit;

import java.util.List;

import com.zyyj.bean.StudentScore;

public interface StudentScoreService {
	
	List<StudentScore> getAllStudentScore();
	
	String getSearchResult(String input, String option);
	
}
