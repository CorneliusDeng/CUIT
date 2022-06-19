package com.zyyj.service.practice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyyj.bean.StudentPractice;
import com.zyyj.mapper.practice.StudentPracticeMapper;

@Service
public class StudentPracticeServiceImpl implements StudentPracticeService{
	
	@Autowired
	private StudentPracticeMapper mapper;    // ��ϰ��¼���ݿ���ʲ�
	
	@Override
	public List<StudentPractice> getAllStudentPractice() {
		return mapper.getAllStudentPractice();
	}
	
	@Override
	public String getSearchResult(String input, String option) {
		List<StudentPractice> list = null;
		if(option.equals("1")) {
			list = mapper.searchByStudent("%" + input + "%");
		}
		else if(option.equals("2")){
			list = mapper.searchByClass("%" + input + "%");
		}
		
		StringBuilder table = new StringBuilder();
		for(StudentPractice sp : list) {
			table.append("<tr>");
			table.append("<td>" + sp.getPractice_id() + "</td><td>" + sp.getStuName() + "</td>");
			table.append("<td>" + (sp.getStatus()==1?"是":"否") + "</td><td>" + sp.getCreatetime() + "</td>");
			table.append("<td>" + sp.getScore() + "</td><td>" + sp.getProgramme() + "</td>");
			table.append("<td>" + sp.getCourse() + "</td>");
			table.append("</tr>");
		}
		
		return table.toString();
	}

}
