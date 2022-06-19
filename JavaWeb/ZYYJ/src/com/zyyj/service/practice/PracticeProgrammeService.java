package com.zyyj.service.practice;

import java.util.List;

import com.zyyj.bean.PracticeProgramme;

public interface PracticeProgrammeService {
	
	/**
	 * ��ȡ������ϰ��¼
	 * @return
	 */
	List<PracticeProgramme> getAllPracticeProgrammes();
	
	/**
	 * �����ϰ����
	 * @param programme
	 * @return
	 */
	int addPracticeProgramme(PracticeProgramme programme);
	
	/**
	 * ������ϰ����
	 * @param programme
	 * @return
	 */
	int updatePracticeProgramme(PracticeProgramme programme);
	
	/**
	 * ɾ����ϰ����
	 * @param programme_id
	 * @return
	 */
	int deletePracticeProgramme(String programme_id);
	
	/**
	 * ��ȡ���п�Ŀ��Ϣ��������Ӻ��޸ĵ�ѡ���
	 * @return
	 */
	List<String> getAllCourses();
	
	/**
	 * ͨ��id����ĳ����ϰ����
	 * @param programme_id
	 * @return
	 */
	String getPracticeProgramme(String programme_id);
	
	/**
	 * ��ȡ�������
	 * @param input ��������
	 * @param option ����ѡ��
	 * @return 
	 */
	String getSearchResult(String input, String option);
}
