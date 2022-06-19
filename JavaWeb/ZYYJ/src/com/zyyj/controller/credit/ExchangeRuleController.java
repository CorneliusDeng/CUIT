package com.zyyj.controller.credit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyyj.bean.ExchangeRule;
import com.zyyj.service.credit.ExchangeRuleService;

import User.UserInfo;

/**
 * 积分兑换规则模块的controller，只负责接收请求和响应，
 * 其他数据库等操作转到Service完成
 * @author Jay
 *
 */
@Controller
public class ExchangeRuleController {
	
	@Autowired
	private ExchangeRuleService exchangeRuleService;
	/*@Autowired
	private HttpServletRequest request;*/
	
	/**
	 * 接收添加新规则的请求
	 * @param exchangeRule
	 * @param map
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="addExchangeRule", method=RequestMethod.POST)
	public String addExchangeRule(ExchangeRule exchangeRule, HttpServletResponse resp) throws IOException {
		int stat = exchangeRuleService.addExchangeRule(exchangeRule);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(stat > 0) {
			out.println("<script>alert('添加成功');window.location='admin.jsp?externalPage=credit/exchangerule.jsp';</script>");
		}
		else {
			out.println("<script>alert('添加失败');window.location='admin.jsp?externalPage=credit/exchangerule.jsp';</script>");
		}
		return null;
	}
	
	/**
	 * 处理修改请求，接收完整的属性，封装成对象
	 * @param exchangeRule
	 * @param map
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="updateExchangeRule", method=RequestMethod.POST)
	public String updateExchangeRule(ExchangeRule exchangeRule, HttpServletResponse resp) throws IOException {
		int stat = exchangeRuleService.updateExchangeRule(exchangeRule);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(stat > 0) {
			out.println("<script>alert('修改成功');window.location='admin.jsp?externalPage=credit/exchangerule.jsp';</script>");
		}
		else {
			out.println("<script>alert('修改失败');window.location='admin.jsp?externalPage=credit/exchangerule.jsp';</script>");
		}
		return null;
	}
	
	/**
	 * 处理删除请求，接收rule——id
	 * @param rule_id
	 * @param map
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="deleteExchangeRule", method=RequestMethod.GET)
	public String deleteExchangeRule(String rule_id, HttpServletResponse resp) throws IOException {
		int stat = exchangeRuleService.deleteExchangeRule(rule_id);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(stat > 0) {
			out.println("<script>alert('删除成功');window.location='admin.jsp?externalPage=credit/exchangerule.jsp';</script>");
		}
		else {
			out.println("<script>alert('删除失败');window.location='admin.jsp?externalPage=credit/exchangerule.jsp';</script>");
		}
		return null;
	}
	@RequestMapping(value="getExchangeRuleJSON", method=RequestMethod.POST)
	public void getExchangeRuleJSON(String rule_id, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.write(exchangeRuleService.getExchangeRuleJSON(rule_id));
		out.close();
	}
}
