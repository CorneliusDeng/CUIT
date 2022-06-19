package com.zyyj.controller.credit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyyj.service.credit.ExchangeIntegralService;

@Controller
public class ExchangeIntegralController {
	
	@Autowired
	private ExchangeIntegralService service;
	
	@RequestMapping(value="searchExchangeIntegral", method=RequestMethod.POST)
	@ResponseBody
	public void searchExchangeIntegral(String input, String option, HttpServletResponse resp) throws IOException{
		String result = service.getSearchResult(input, option);
		resp.setHeader("Content-Type", "text/plain;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.write(result);
	}
}
