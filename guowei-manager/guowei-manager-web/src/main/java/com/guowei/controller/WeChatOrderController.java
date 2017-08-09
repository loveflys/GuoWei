package com.guowei.controller;

import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guowei.common.pojo.AuthToken;
import com.guowei.common.pojo.Constant;
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.PayUtils;
import com.guowei.service.PayService;

@Controller
@RequestMapping(value = "/m/weChat")
public class WeChatOrderController {

	@Autowired
	private PayService payService;

	/**
	 * 统一下单
	 */
	@RequestMapping(value = "/unifiedOrder")
	public ModelAndView unifiedOrder(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("pay");
		// 用户同意授权，获得的code
		String code = request.getParameter("code");
		// 通过code获取网页授权access_token
		AuthToken authToken = PayUtils.getTokenByAuthCode(code);
		// 调用统一下单service
		String prepayId = payService.unifiedOrder(authToken, request.getRemoteAddr());
		System.out.println("prepayId==>"+prepayId);
		if (!PayUtils.isEmpty(prepayId)) {
			String timeStamp = PayUtils.getTimeStamp();// 当前时间戳
			String nonceStr = PayUtils.getRandomStr(20);// 不长于32位的随机字符串
			
			String jsticket = PayUtils.getTicket(authToken.getAccess_token());
			
			String url = request.getRequestURL().toString();
			
			String str = "jsapi_ticket=" + jsticket +
	                "&noncestr=" + nonceStr +
	                "&timestamp=" + timeStamp +
	                "&url=" + url;
			
			String sign = PayUtils.SHA1(str);

			SortedMap<String, Object> signMap = new TreeMap<String, Object>();// 自然升序map
			signMap.put("appId", Constant.APP_ID);
			signMap.put("package", prepayId);
			signMap.put("timeStamp", timeStamp);
			signMap.put("nonceStr", nonceStr);
			signMap.put("signType", "MD5");
			System.out.println(timeStamp);
			model.addObject("appId", Constant.APP_ID);
			model.addObject("timeStamp", timeStamp);
			model.addObject("nonceStr", nonceStr);
			model.addObject("prepayId", prepayId);
			model.addObject("paySign", PayUtils.getSign(signMap));// 获取签名
			model.addObject("sign", sign);
		} else {
			System.out.println("微信统一下单失败,订单编号:失败原因");
//			return "redirect:/pay";// 支付下单失败，重定向至订单列表
		}
		// 将支付需要参数返回至页面，采用h5方式调用支付接口
		
		
		return model;
	}

	@RequestMapping(value = "/pay")
	public ModelAndView refund(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("pay");
		model.addObject("currentUser", request.getSession().getAttribute(Constants.CURRENT_USER));
		return model;
	}
}