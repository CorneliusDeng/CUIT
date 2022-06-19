package com.zyyj.mapper.practice;

import java.util.List;

import com.zyyj.bean.StudentPractice;

public interface StudentPracticeMapper {
	
	/**
	 * ��ȡ������ϰ��¼
	 * @return
	 */
	List<StudentPractice> getAllStudentPractice();
	
	/**
	 * ����ѧ������������ϰ��¼
	 * @param student_name
	 * @return
	 */
	List<StudentPractice> searchByStudent(String input);
	
	/**
	 * ������ϰ����ɾ��ѧ����ϰ��¼����Ҫ����ɾ����ϰ����ʱͬʱɾ�������ϰ��¼
	 * @param programme_id
	 * @return
	 */
	int deleteStudentPractice(String programme_id);
	
	List<StudentPractice> searchByClass(String input);
}
