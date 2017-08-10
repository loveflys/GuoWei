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
import com.guowei.pojo.GwOrder;
import com.guowei.pojo.GwUser;
import com.guowei.service.OrderService;
import com.guowei.service.PayService;

@Controller
@RequestMapping(value = "/wechat")
public class WeChatController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PayService payService;
	@Resource
	private OrderService orderService;
	/**
	 * 统一下单
	 */
	@RequestMapping(value = "/unifiedOrder", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String unifiedOrder(HttpServletRequest request) {
		GwUser user = (GwUser) request.getSession().getAttribute(Constants.CURRENT_USER);
		String orderId = request.getParameter("orderId");
		// 调用统一下单service
		String prepayId = payService.unifiedOrder(user.getWechatOpenid(), request.getRemoteAddr(), orderId);
		System.out.println("prepayId==>" + prepayId);
		JSONObject res = new JSONObject();
		if (!PayUtils.isEmpty(prepayId)) {
			String timeStamp = PayUtils.getTimeStamp();// 当前时间戳
			String nonceStr = PayUtils.getRandomStr(20);// 不长于32位的随机字符串

			SortedMap<String, Object> signMap = new TreeMap<String, Object>();// 自然升序map
			signMap.put("appId", Constant.APP_ID);
			signMap.put("package", prepayId);
			signMap.put("timeStamp", timeStamp);
			signMap.put("nonceStr", nonceStr);
			signMap.put("signType", "MD5");
			System.out.println(timeStamp);
			res.put("status", true);
			res.put("appId", Constant.APP_ID);
			res.put("timeStamp", timeStamp);
			res.put("nonceStr", nonceStr);
			res.put("prepayId", prepayId);
			res.put("paySign", PayUtils.getSign(signMap));
		} else {
			res.put("status", false);
			GwOrder order = orderService.getGwOrderById(Long.parseLong(request.getParameter("id")));
			order.setStatus(Byte.parseByte("3"));
			int status = orderService.editGwOrder(order);
			System.out.println("微信统一下单失败,订单编号:失败原因");
			// return "redirect:/pay";// 支付下单失败，重定向至订单列表
		}
		// 将支付需要参数返回至页面，采用h5方式调用支付接口

		return JSON.toJSONString(res);
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
				if (SignUtils.checkSign(kvm, Constant.KEY)) {
					GwOrder order = orderService.getGwOrderById(Long.parseLong(request.getParameter("id")));
					if (kvm.get("result_code").equals("SUCCESS")) {
						// TODO(user) 微信服务器通知此回调接口支付成功后，通知给业务系统做处理
						log.info("out_trade_no: " + kvm.get("out_trade_no") + " pay SUCCESS!");
						System.out.println("out_trade_no: " + kvm.get("out_trade_no") + " pay SUCCESS!");						
						
						order.setStatus(Byte.parseByte("2"));
						int status = orderService.editGwOrder(order);
						
						if (status == 1) {
							System.out.println("支付成功.修改订单状态成功");
						} else {
							System.out.println("支付成功.修改订单状态失败");
						}
						
						response.getWriter().write(
								"<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[ok]]></return_msg></xml>");
					} else {
						log.error("out_trade_no: " + kvm.get("out_trade_no") + " result_code is FAIL");
						System.out.println("out_trade_no: " + kvm.get("out_trade_no") + " result_code is FAIL");
						
						order.setStatus(Byte.parseByte("3"));
						int status = orderService.editGwOrder(order);
						
						if (status == 1) {
							System.out.println("支付失败.修改订单状态成功");
						} else {
							System.out.println("支付失败.修改订单状态失败");
						}
						
						response.getWriter().write(
								"<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[result_code is FAIL]]></return_msg></xml>");
					}
				} else {
					response.getWriter().write(
							"<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[check signature FAIL]]></return_msg></xml>");
					System.out.println("out_trade_no: " + kvm.get("out_trade_no") + " check signature FAIL");
					log.error("out_trade_no: " + kvm.get("out_trade_no") + " check signature FAIL");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}