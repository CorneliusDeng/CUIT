package com.zyyj.mapper.practice;

import java.util.List;

import com.zyyj.bean.PracticeProgramme;

public interface PracticeProgrammeMapper {
	
	List<PracticeProgramme> getAllPracticeProgrammes();
	
	int addPracticeProgramme(PracticeProgramme programme);
	int addCourseProgramme(PracticeProgramme programme);
	int addPracticeRecord(PracticeProgramme programme);
	
	int updatePracticeProgramme(PracticeProgramme programme);
	int updateCourseProgramme(PracticeProgramme programme);
	
	int deletePracticeProgramme(String programme_id);
	int deleteCourseProgramme(String programme_id);
	int deletePracticeRecord(String programme_id);
	
	
	List<String> getAllCourses();
	
	String getMaxId();
	
	PracticeProgramme getPracticeProgramme(String programme_id);
	
	List<PracticeProgramme> searchByName(String name);
	List<PracticeProgramme> searchByCourse(String course);
}
