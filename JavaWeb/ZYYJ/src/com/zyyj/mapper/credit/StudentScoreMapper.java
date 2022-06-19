package com.zyyj.mapper.credit;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyyj.bean.StudentScore;

@Repository
public interface StudentScoreMapper {
	
	List<StudentScore> getAllStudentScore();
	
	List<StudentScore> searchByName(String name);
	
	List<StudentScore> searchByClass(String className);
	
	List<StudentScore> searchByGrade(String grade);
	
	List<StudentScore> searchByMajor(String major);
	
	List<StudentScore> searchByAccount(String account);
}
