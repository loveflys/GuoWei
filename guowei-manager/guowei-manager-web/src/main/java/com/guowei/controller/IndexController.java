package com.guowei.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.guowei.common.pojo.Constant;

@Controller
@RequestMapping(value = "/")
public class IndexController {
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("payURL", Constant.PAY_URL);
		return "index";
	}
	
	@RequestMapping(value="/getIndexData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getIndexData(HttpServletRequest request) {
		BigDecimal TodayAmount = new BigDecimal(127.1);
		BigDecimal ToweekAmount = new BigDecimal(328.5);
		BigDecimal TomonthAmount = new BigDecimal(3255);
		BigDecimal allAmount = new BigDecimal(8888);
		int newUser = 44;
		long allUser = 88;
		
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
