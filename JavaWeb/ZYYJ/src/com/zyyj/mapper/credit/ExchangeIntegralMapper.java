package com.zyyj.mapper.credit;

import java.util.List;

import com.zyyj.bean.ExchangeIntegral;

public interface ExchangeIntegralMapper {
	
	List<ExchangeIntegral> getAllExchangeIntegrals();
	
	List<ExchangeIntegral> searchByClass(String className);
	
	List<ExchangeIntegral> searchByStudent(String stuName);
	
	List<ExchangeIntegral> searchByAccount(String account);
	
	List<ExchangeIntegral> searchByExchangeRule(String rule);
	
}
