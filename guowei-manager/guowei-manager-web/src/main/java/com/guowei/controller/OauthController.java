package com.guowei.controller;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.guowei.common.pojo.Secret;
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.WeiXinOAuth;
import com.guowei.pojo.GwUser;
import com.guowei.service.UserService;

/**
 * @描述：订单Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class OauthController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private UserService userService;
	/**
	 * 微信授权
	 * @param request
	 * @return
	 */
	@RequestMapping("/api/oauth")
	public ModelAndView oauth(HttpServletRequest request, @RequestParam String code, @RequestParam String state) {
		JSONObject accessTokenResult = WeiXinOAuth.GetWeiXinAccessToken(Secret.APP_ID, Secret.APP_SECRET, code);
		System.out.println("授权开始==>"+accessTokenResult.toJSONString());
		String access_token = accessTokenResult.getString("access_token");
		String openid = accessTokenResult.getString("openid");
		
		JSONObject res = WeiXinOAuth.GetWeiXinUserInfo(access_token, openid);
		System.out.println("授权结束==>"+res.toJSONString());

		GwUser user = userService.getGwUserByOpenId(openid);
		if (user == null) {
			user = new GwUser();
			user.setAvatar(res.getString("headimgurl"));
			user.setCreated(Calendar.getInstance().getTime());
			user.setName(res.getString("nickname"));
			user.setPhone("");
			user.setTotalconsume(0l);
			user.setUpdated(Calendar.getInstance().getTime());
			user.setWechatOpenid(openid);
			user.setWechatAccount(res.getString("openid").substring(0, 19));
			int result = userService.addGwUser(user);
			if (result == 1) {		
				user = userService.getGwUserByOpenId(openid);
				log.info(Constants.SYS_NAME + "用户：（"+ res.getString("nickname") +"） 注册成功!");
			}
		}
		request.getSession().setAttribute(Constants.CURRENT_USER, user);
		request.getSession().setAttribute("token", access_token);
		return new ModelAndView("redirect:/"+state);
	}
}
