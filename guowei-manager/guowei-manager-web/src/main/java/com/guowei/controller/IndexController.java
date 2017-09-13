package com.guowei.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.guowei.common.utils.Constants;

@Controller
@RequestMapping(value = "/")
public class IndexController {
	@Resource
	private OrderService orderService;
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/")
	public String index(HttpServletRequest request, Model model) {
		model.addAttribute("payURL", Constant.PAY_URL);
		model.addAttribute("currentUser", request.getSession().getAttribute(Constants.CURRENT_USER));
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

		List<BigDecimal> yeardata = new ArrayList<BigDecimal>();
		List<BigDecimal> monthdata = new ArrayList<BigDecimal>();
		
		List<String> yeardatatitle = new ArrayList<String>();
		List<String> monthdatatitle = new ArrayList<String>();
		for (int i = 1; i <= 12; i++) {
			Calendar temp1 = Calendar.getInstance();
			temp1.add(Calendar.MONTH, -(12-i));
			temp1.set(Calendar.DATE, 1);
	        String temps1 = format.format(temp1.getTime());
	        yeardatatitle.add(String.valueOf(temp1.getTime().getYear()+1900) + "-" +String.valueOf(temp1.getTime().getMonth() + 1));
	        
	        Calendar temp2 = Calendar.getInstance();
			temp2.add(Calendar.MONTH, -(11-i));
			temp2.set(Calendar.DATE, 1);
			temp2.add(Calendar.DATE, -1);
	        String temps2 = format.format(temp2.getTime()); 
	        BigDecimal tempAmount = orderService.getOrdersData(temps1, temps2) == null ? new BigDecimal("0") : orderService.getOrdersData(temps1, temps2);
	        yeardata.add(tempAmount);
		}
		
		for (int i = 1; i <= 30; i++) {
			Calendar temp1 = Calendar.getInstance();
			temp1.add(Calendar.DATE, -(30-i));
	        String temps1 = format.format(temp1.getTime()); 
	        monthdatatitle.add(temps1);
	        BigDecimal tempAmount = orderService.getOrdersData(temps1, temps1) == null ? new BigDecimal("0") : orderService.getOrdersData(temps1, temps1);
	        monthdata.add(tempAmount);
		}
		
		JSONObject res = new JSONObject();
		res.put("TodayAmount", TodayAmount);
		res.put("ToweekAmount", ToweekAmount);
		res.put("TomonthAmount", TomonthAmount);
		res.put("allAmount", allAmount);
		res.put("newUser", newUser);
		res.put("allUser", allUser);
		res.put("yeardata", yeardata);
		res.put("monthdata", monthdata);
		res.put("yeardatatitle", yeardatatitle);
		res.put("monthdatatitle", monthdatatitle);
		String data = JSON.toJSONString(res);
		return data;
	}
}
