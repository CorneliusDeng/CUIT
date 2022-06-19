package com.zyyj.mapper.credit;

import java.util.List;

import com.zyyj.bean.ExchangeRule;

/**
 * 积分兑换规则mapper，方法对应的数据库sql语句位于exchangeRuleMapper.xml
 * @author Jay
 *
 */
public interface ExchangeRuleMapper {
	
	// 添加
	int addExchangeRule(ExchangeRule exchangeRule);
	// 查询所有
	List<ExchangeRule> getAllExchangeRules();
	// 修改
	int updateExchangeRule(ExchangeRule exchangeRule);
	// 删除
	int deleteExchangeRule(String rule_id);
	
	String getMaxId();
	
	ExchangeRule getExchangeRule(String rule_id);
}
