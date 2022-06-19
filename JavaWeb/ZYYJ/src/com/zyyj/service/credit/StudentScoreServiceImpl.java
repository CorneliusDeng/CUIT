package com.zyyj.service.credit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyyj.bean.StudentScore;
import com.zyyj.mapper.credit.StudentScoreMapper;

@Service
public class StudentScoreServiceImpl implements StudentScoreService{
	
	@Autowired
	private StudentScoreMapper mapper;
	
	@Override
	public List<StudentScore> getAllStudentScore() {
		return mapper.getAllStudentScore();
	}

	@Override
	public String getSearchResult(String input, String option) {
		List<StudentScore> resultList = null;
		System.out.println(input + option);
		if(option.equals("1")) {
			resultList = mapper.searchByName("%" + input + "%");
		}
		else if(option.equals("2")) {
			resultList = mapper.searchByClass("%" + input + "%");
		}
		else if(option.equals("3")) {
			resultList = mapper.searchByGrade("%" + input + "%");
		}
		else if(option.equals("4")) {
			resultList = mapper.searchByMajor("%" + input + "%");
		}
		else if(option.equals("5")) {
			resultList = mapper.searchByAccount("%" + input + "%");
		}
		else {
			resultList = null;
		}
		StringBuilder table = new StringBuilder();
		int i = 1;
		for(StudentScore ss : resultList) {
			table.append("<tr><td>" + i + "</td><td>" + ss.getStudentName() + "</td><td>" + ss.getScore() + "</td></td>");
			i++;
		}
		return table.toString();
	}
		
}
