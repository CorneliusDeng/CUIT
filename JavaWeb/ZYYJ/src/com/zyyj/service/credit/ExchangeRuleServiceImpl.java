package com.zyyj.service.credit;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyyj.bean.ExchangeRule;
import com.zyyj.mapper.credit.ExchangeRuleMapper;
import com.zyyj.service.ServiceUtil;

@Service
public class ExchangeRuleServiceImpl implements ExchangeRuleService{
	
	@Autowired
	private ExchangeRuleMapper exchangeRuleMapper;
	
	/**
	 * 添加的业务逻辑：生成日期和id，封装后用传给持久层
	 * @return 
	 */
	@Override
	public int addExchangeRule(ExchangeRule exchangeRule) {
		// 生成创建日期
		String createdate = LocalDate.now().toString();
		exchangeRule.setCreatedate(createdate);
		
		// 生成ID
		String max_id = exchangeRuleMapper.getMaxId();
		String next_id = null;
		if(max_id == null) {
			next_id = "rule001";
		}
		else {
			next_id = ServiceUtil.getNextId(max_id, "rule");
		}
		exchangeRule.setRule_id(next_id);
		
		// 添加到数据库
		return exchangeRuleMapper.addExchangeRule(exchangeRule);
	}
	
	/**
	 * 获取所有的规则，直接调用持久层方法
	 */
	@Override
	public List<ExchangeRule> getAllExchangeRules() {
		List<ExchangeRule> result = exchangeRuleMapper.getAllExchangeRules();
		return result;
	}

	/**
	 * 修改，
	 * @return 
	 */
	@Override
	public int updateExchangeRule(ExchangeRule exchangeRule) {
		return exchangeRuleMapper.updateExchangeRule(exchangeRule);
	}
	
	/**
	 * 删除
	 * @return 
	 */
	@Override
	public int deleteExchangeRule(String rule_id) {
		return exchangeRuleMapper.deleteExchangeRule(rule_id);
	}

	@Override
	public String getExchangeRuleJSON(String rule_id) {
		
		return exchangeRuleMapper.getExchangeRule(rule_id).toString();
	}
}
