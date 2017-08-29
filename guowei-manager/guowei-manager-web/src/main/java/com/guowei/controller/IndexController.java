package com.guowei.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.guowei.service.OrderService;
import com.guowei.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.guowei.common.pojo.Constant;

@Controller
@RequestMapping(value = "/")
public class IndexController {
	@Resource
	private OrderService orderService;
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("payURL", Constant.PAY_URL);
		return "index";
	}
	
	@RequestMapping(value="/getIndexData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getIndexData(HttpServletRequest request) {
		Date d = new Date();  
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        String dateNowStr = format.format(d);  
		
        Calendar week = Calendar.getInstance(); 
        week.add(Calendar.WEEK_OF_YEAR, -1);
        String weeks = format.format(week.getTime());
        
        Calendar month = Calendar.getInstance();
        month.add(Calendar.MONTH, -1);
        String months = format.format(month.getTime()); 
        
		BigDecimal TodayAmount = orderService.getOrdersData(dateNowStr,dateNowStr) == null ? new BigDecimal("0") : orderService.getOrdersData(dateNowStr,dateNowStr); //new BigDecimal(127.1);
		BigDecimal ToweekAmount = orderService.getOrdersData(weeks, dateNowStr) == null ? new BigDecimal("0") : orderService.getOrdersData(weeks, dateNowStr);
		BigDecimal TomonthAmount = orderService.getOrdersData(months, dateNowStr) == null ? new BigDecimal("0") : orderService.getOrdersData(months, dateNowStr);
		BigDecimal allAmount = orderService.getOrdersData("", "") == null ? new BigDecimal("0") : orderService.getOrdersData("", "");
		BigDecimal newUser = userService.getUserCount(dateNowStr,dateNowStr) == null ? new BigDecimal("0") : userService.getUserCount(dateNowStr,dateNowStr);
		BigDecimal allUser = userService.getUserCount("", "") == null ? new BigDecimal("0") : userService.getUserCount("", "");

		
		JSONObject res = new JSONObject();
		res.put("TodayAmount", TodayAmount);
		res.put("ToweekAmount", ToweekAmount);
		res.put("TomonthAmount", TomonthAmount);
		res.put("allAmount", allAmount);
		res.put("newUser", newUser);
		res.put("allUser", allUser);
		String data = JSON.toJSONString(res);
		return data;
	}
}
