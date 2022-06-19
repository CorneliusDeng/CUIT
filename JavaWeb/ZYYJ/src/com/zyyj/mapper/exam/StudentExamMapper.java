package com.zyyj.mapper.exam;

import java.util.List;

import com.zyyj.bean.StudentExam;

public interface StudentExamMapper {
	
	List<StudentExam> getAllStudentExams();
	
	List<StudentExam> searchByStudent(String stuName);
	
	List<StudentExam> searchByClass(String className);
	
	List<StudentExam> searchByExam(String exam_name);
	
	int deleteStudentExam(String exam_id);
}
