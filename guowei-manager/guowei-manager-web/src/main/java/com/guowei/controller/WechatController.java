
package com.guowei.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.guowei.common.pojo.AccessToken;
import com.guowei.common.pojo.Secret;
import com.guowei.common.utils.WeiXinOAuth;

/**
 * @描述：用户Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class WechatController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 微信授权
	 * @param request
	 * @return
	 */
	@RequestMapping("/api/oauth")
	public String oauth(HttpServletRequest request, @RequestParam String code) {
		JSONObject accessTokenResult = WeiXinOAuth.GetWeiXinAccessToken(Secret.APP_ID, Secret.APP_SECRET, code);
		System.out.println(accessTokenResult.toJSONString());
		String access_token = accessTokenResult.getString("access_token");
		String openid = accessTokenResult.getString("openid");
		
		JSONObject res = WeiXinOAuth.GetWeiXinUserInfo(access_token, openid);
		System.out.println(res.toJSONString());
		// 这里简单处理,存储到session中
		return "";
	}
}
