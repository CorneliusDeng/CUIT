package com.zyyj.service.credit;

import java.util.List;

import com.zyyj.bean.ExchangeRule;

public interface ExchangeRuleService {
	
	int addExchangeRule(ExchangeRule exchangeRule);
	
	List<ExchangeRule> getAllExchangeRules();
	
	int updateExchangeRule(ExchangeRule exchangeRule);
	
	int deleteExchangeRule(String rule_id);
	
	String getExchangeRuleJSON(String rule_id);
}
