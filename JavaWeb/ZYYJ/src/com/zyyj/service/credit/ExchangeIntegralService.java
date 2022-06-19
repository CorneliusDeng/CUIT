package com.zyyj.service.credit;

import java.util.List;

import com.zyyj.bean.ExchangeIntegral;

public interface ExchangeIntegralService {
	
	List<ExchangeIntegral> getAllExchangeIntegrals();
	
	String getSearchResult(String input, String option);
	
}
