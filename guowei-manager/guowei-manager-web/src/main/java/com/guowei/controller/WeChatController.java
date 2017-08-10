package com.guowei.controller;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.util.SignUtils;
import com.guowei.common.pojo.AuthToken;
import com.guowei.common.pojo.Constant;
import com.guowei.common.pojo.Secret;
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.PayUtils;
import com.guowei.common.utils.WeiXinOAuth;
import com.guowei.service.PayService;

@Controller
@RequestMapping(value = "/wechat")
public class WeChatController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
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
		String orderId = request.getParameter("orderId");
		// 通过code获取网页授权access_token
		AuthToken authToken = PayUtils.getTokenByAuthCode(code);
		// 调用统一下单service
		String prepayId = payService.unifiedOrder(authToken, request.getRemoteAddr(), orderId);
		System.out.println("prepayId==>" + prepayId);
		if (!PayUtils.isEmpty(prepayId)) {
			String timeStamp = PayUtils.getTimeStamp();// 当前时间戳
			String nonceStr = PayUtils.getRandomStr(20);// 不长于32位的随机字符串

			String jsticket = PayUtils.getTicket(authToken.getAccess_token());

			String url = request.getRequestURL().toString();

			String str = "jsapi_ticket=" + jsticket + "&noncestr=" + nonceStr + "&timestamp=" + timeStamp + "&url="
					+ url;

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
			// return "redirect:/pay";// 支付下单失败，重定向至订单列表
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

	@RequestMapping(value = "/getConfig", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getConfig(HttpServletRequest request) {
		JSONObject accessTokenResult = WeiXinOAuth.GetWeiXinAccessToken(Secret.APP_ID, Secret.APP_SECRET);
		String access_token = accessTokenResult.getString("access_token");

		String timeStamp = PayUtils.getTimeStamp();// 当前时间戳
		String nonceStr = PayUtils.getRandomStr(20);// 不长于32位的随机字符串

		String jsticket = PayUtils.getTicket(access_token);

		String url = request.getParameter("url");

		String str = "jsapi_ticket=" + jsticket + "&noncestr=" + nonceStr + "&timestamp=" + timeStamp + "&url=" + url;

		String sign = PayUtils.SHA1(str);

		JSONObject res = new JSONObject();
		res.put("appId", Secret.APP_ID);
		res.put("timeStamp", timeStamp);
		res.put("nonceStr", nonceStr);
		res.put("url", url);
		res.put("sign", sign);
		return JSON.toJSONString(res);
	}

	/**
	 * 微信通知支付结果的回调地址，notify_url
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/payresult")
	public void payresult(HttpServletRequest request, HttpServletResponse response) {
		try {
			synchronized (this) {
				Map<String, String> kvm = PayUtils.parseRequestXmlToMap(request);
				if (SignUtils.checkSign(kvm, Constant.MCH_ID)) {
					if (kvm.get("result_code").equals("SUCCESS")) {
						// TODO(user) 微信服务器通知此回调接口支付成功后，通知给业务系统做处理
						log.info("out_trade_no: " + kvm.get("out_trade_no") + " pay SUCCESS!");
						response.getWriter().write(
								"<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[ok]]></return_msg></xml>");
					} else {
						log.error("out_trade_no: " + kvm.get("out_trade_no") + " result_code is FAIL");
						response.getWriter().write(
								"<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[result_code is FAIL]]></return_msg></xml>");
					}
				} else {
					response.getWriter().write(
							"<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[check signature FAIL]]></return_msg></xml>");
					log.error("out_trade_no: " + kvm.get("out_trade_no") + " check signature FAIL");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}