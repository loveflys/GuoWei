package com.guowei.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.guowei.common.pojo.Constant;
import com.guowei.common.pojo.Secret;
import com.guowei.common.pojo.TemplateData;
import com.guowei.common.pojo.WeChatTemplate;

public class WechatWarn {
	@SuppressWarnings("deprecation")
	public static JSONObject Warn(String CompanyName, String ProductName, Integer stock) throws UnsupportedEncodingException {
		String time = "";
		StringBuffer dataString =  new StringBuffer();
		Date now = new Date();
		time = now.getYear() + "-" + (now.getMonth()+1) + "-" + now.getDate()
			+ now.getHours() + ":" + now.getMinutes();
		
		JSONObject accessTokenResult = WeiXinOAuth.GetWeiXinAccessToken(Secret.APP_ID, Secret.APP_SECRET);
		String access_token = accessTokenResult.getString("access_token");
		
		WeChatTemplate param = new WeChatTemplate();
		Map<String,TemplateData> m = new HashMap<String,TemplateData>();  
		TemplateData first = new TemplateData();  
		first.setColor("#000000");    
		first.setValue("您好。");    
		m.put("first", first);  
		  
		TemplateData keyword1 = new TemplateData();    
		keyword1.setColor("#000000");    
		keyword1.setValue(CompanyName);    
		m.put("keyword1", keyword1);  
		  
		TemplateData keyword2 = new TemplateData();    
		keyword2.setColor("#000000");    
		keyword2.setValue(ProductName);    
		m.put("keyword2", keyword2);  
		  
		TemplateData keyword3 = new TemplateData();    
		keyword3.setColor("#000000");    
		keyword3.setValue(stock.toString());    
		m.put("keyword3", keyword3);  
		  
		TemplateData remark = new TemplateData();    
		remark.setColor("#000000");    
		remark.setValue("请尽快补充库存并登陆上线了更新库存数据。");    
		m.put("remark", remark);  
		param.setTouser(Constant.MANAGER_OPENID1);
		param.setTemplate_id(Constant.MSG_ID);
		param.setData(m);      
		String params =JSONObject.toJSONString(param);
		JSONObject res = WeiXinOAuth.SendTemplateMsg(access_token, params);
		param.setTouser(Constant.MANAGER_OPENID2);
		params =JSONObject.toJSONString(param);
		res = WeiXinOAuth.SendTemplateMsg(access_token, params);
		return res;
	}
	
	public static JSONObject ApplyWarn(String CompanyName, String userName, String date) {	
		JSONObject res = null;
		try {
			res = generalWarn("你好。你有一条待处理的货架申请", "申请公司:" + CompanyName, userName, "无", date);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("ApplyWarn提醒报错");
		}
		return res;
	}
	public static JSONObject ComplainWarn(String content, String userName, String date) {	
		JSONObject res = null;
		try {
			res = generalWarn("你好。你有一条待处理的意见投诉", content, userName, "无", date);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("ComplainWarn提醒报错");
		}
		return res;
	}
	
	@SuppressWarnings("deprecation")
	public static JSONObject generalWarn(String mainTitle, String title, String name, String suggestion, String date) throws UnsupportedEncodingException {
		String time = "";
		StringBuffer dataString =  new StringBuffer();
		Date now = new Date();
		time = now.getYear() + "-" + (now.getMonth()+1) + "-" + now.getDate()
			+ now.getHours() + ":" + now.getMinutes();
		
		JSONObject accessTokenResult = WeiXinOAuth.GetWeiXinAccessToken(Secret.APP_ID, Secret.APP_SECRET);
		String access_token = accessTokenResult.getString("access_token");
		
		WeChatTemplate param = new WeChatTemplate();
		Map<String,TemplateData> m = new HashMap<String,TemplateData>();  
		TemplateData first = new TemplateData();  
		first.setColor("#000000");    
		first.setValue(mainTitle);    
		m.put("first", first);  
		  
		TemplateData keyword1 = new TemplateData();    
		keyword1.setColor("#000000");    
		keyword1.setValue(title);    
		m.put("keyword1", keyword1);  
		  
		TemplateData keyword2 = new TemplateData();    
		keyword2.setColor("#000000");    
		keyword2.setValue(name);    
		m.put("keyword2", keyword2);  
		  
		TemplateData keyword3 = new TemplateData();    
		keyword3.setColor("#000000");    
		keyword3.setValue(suggestion);    
		m.put("keyword3", keyword3);  
		
		TemplateData keyword4 = new TemplateData();    
		keyword4.setColor("#000000");    
		keyword4.setValue(date);    
		m.put("keyword4", keyword4);  
		  
		TemplateData remark = new TemplateData();    
		remark.setColor("#000000");    
		remark.setValue("请尽快处理。");    
		m.put("remark", remark);  
		param.setTouser(Constant.MANAGER_OPENID1);
		param.setTemplate_id(Constant.APPLY_MSG_ID);
		param.setData(m);
		String params =JSONObject.toJSONString(param);
		JSONObject res = WeiXinOAuth.SendTemplateMsg(access_token, params);
		param.setTouser(Constant.MANAGER_OPENID2);
		params =JSONObject.toJSONString(param);
		res = WeiXinOAuth.SendTemplateMsg(access_token, params);
		param.setTouser(Constant.MANAGER_OPENID3);
		params =JSONObject.toJSONString(param);
		res = WeiXinOAuth.SendTemplateMsg(access_token, params);
		return res;
	}
}
