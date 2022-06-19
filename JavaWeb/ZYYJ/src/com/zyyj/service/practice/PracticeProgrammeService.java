package com.zyyj.service.practice;

import java.util.List;

import com.zyyj.bean.PracticeProgramme;

public interface PracticeProgrammeService {
	
	/**
	 * 获取所有练习记录
	 * @return
	 */
	List<PracticeProgramme> getAllPracticeProgrammes();
	
	/**
	 * 添加练习方案
	 * @param programme
	 * @return
	 */
	int addPracticeProgramme(PracticeProgramme programme);
	
	/**
	 * 更新练习方案
	 * @param programme
	 * @return
	 */
	int updatePracticeProgramme(PracticeProgramme programme);
	
	/**
	 * 删除练习方案
	 * @param programme_id
	 * @return
	 */
	int deletePracticeProgramme(String programme_id);
	
	/**
	 * 获取所有科目信息，用于添加和修改的选项框
	 * @return
	 */
	List<String> getAllCourses();
	
	/**
	 * 通过id查找某个练习方案
	 * @param programme_id
	 * @return
	 */
	String getPracticeProgramme(String programme_id);
	
	/**
	 * 获取搜索结果
	 * @param input 搜索内容
	 * @param option 搜索选项
	 * @return 
	 */
	String getSearchResult(String input, String option);
}
