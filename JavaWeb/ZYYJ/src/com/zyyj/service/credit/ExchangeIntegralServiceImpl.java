package com.zyyj.service.credit;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyyj.bean.ExchangeIntegral;
import com.zyyj.mapper.credit.ExchangeIntegralMapper;

@Service
public class ExchangeIntegralServiceImpl implements ExchangeIntegralService{

	@Autowired
	private ExchangeIntegralMapper mapper;
	
	@Override
	public List<ExchangeIntegral> getAllExchangeIntegrals() {
		return mapper.getAllExchangeIntegrals();
	}

	// 搜索功能，首先根据搜索选项和搜索字段从数据库得到搜索结果，然后将结果处理成表格形式
	@Override
	public String getSearchResult(String input, String option) {
		List<ExchangeIntegral> searchResult;
		input = "%" + input + "%";
		// 根据不同的搜索选项进行搜索
		if(option.equals("1")) {
			searchResult =  mapper.searchByStudent(input);
		}
		else if(option.equals("2")) {
			searchResult =  mapper.searchByExchangeRule(input);
		}
		else if(option.equals("3")) {
			searchResult =  mapper.searchByClass(input);
		}
		else if(option.equals("4")) {
			searchResult =  mapper.searchByAccount(input);
		}
		else {
			searchResult = null;
		}
		
		// 处理结果，生成表格
		StringBuilder table = new StringBuilder();
		for(ExchangeIntegral e : searchResult) {
			table.append("<tr><td>" + e.getExchange_id() + "</td><td>" + e.getRule_name() + "</td><td>"
					+ e.getStu_name() + "</td><td>" + e.getCreatedate() + "</td><td>" + e.getScore() + "</td><td>" + e.getIntegral() + "</td></tr>");
		}
		return table.toString();
	}
}
