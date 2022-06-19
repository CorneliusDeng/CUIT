package com.zyyj.service.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyyj.bean.StudentExam;
import com.zyyj.mapper.exam.StudentExamMapper;

@Service
public class StudentExamServiceImpl implements StudentExamService{

	@Autowired
	private StudentExamMapper mapper;
	
	@Override
	public List<StudentExam> getAllStudentExams() {
		List<StudentExam> list = mapper.getAllStudentExams();
		return list;
	}

	@Override
	public String getSearchResult(String input, String option) {
		List<StudentExam> list = null;
		input = "%" + input + "%";
		if(option.equals("1")) {
			list = mapper.searchByStudent(input);
		}
		else if(option.equals("2")) {
			list = mapper.searchByClass(input);
		}
		else if(option.equals("3")) {
			list = mapper.searchByExam(input);
		}
		else {
			list = null;
		}
		StringBuilder table = new StringBuilder();
		for(StudentExam s : list) {
			table.append("<tr><td>" + s.getPractice_id() + "</td><td>" + s.getStu_name() + 
					"</td><td>" + s.getExam_name() + "</td><td>" + (s.getStatus()==1?"是":"否") +
					"</td><td>" + s.getCreatetime() + "</td><td>" + s.getScore() + "</td><td>" + s.getCourse_name() + "</td></tr>");
		}
		return table.toString();
	}

}
