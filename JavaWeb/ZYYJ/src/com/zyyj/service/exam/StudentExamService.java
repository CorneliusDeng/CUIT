package com.zyyj.service.exam;

import java.util.List;

import com.zyyj.bean.StudentExam;

public interface StudentExamService {
	
	List<StudentExam> getAllStudentExams();
	
	String getSearchResult(String input, String option);

}
