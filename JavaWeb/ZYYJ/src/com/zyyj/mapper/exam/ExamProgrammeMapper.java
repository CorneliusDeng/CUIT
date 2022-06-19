package com.zyyj.mapper.exam;

import java.util.List;

import com.zyyj.bean.ExamProgramme;

public interface ExamProgrammeMapper {
	
	// 查询所有
	List<ExamProgramme> getAllExamProgrammes();
	
	// 添加
	int addExamProgramme(ExamProgramme examProgramme);
	int addCourseExam(ExamProgramme examProgramme);
	int addExamRecord(ExamProgramme examProgramme);
	
	// 修改
	int updateExamProgramme(ExamProgramme examProgramme);
	int updateCourseExam(ExamProgramme examProgramme);
	
	// 删除
	int deleteExamProgramme(String exam_id);
	int deleteCourseExam(String exam_id);
	int deleteExamRecord(String exam_id);
	
	// 获取最大ID
	String getMaxId();
	List<String> getAllCourses();
	ExamProgramme getExamProgramme(String exam_id);
	
	List<ExamProgramme> searchByName(String name);
	List<ExamProgramme> searchByCourse(String course);
}
