package com.guowei.service;

import com.guowei.common.pojo.AuthToken;

public interface PayService {
	
	/**
	 * 统一下单接口
	 * @param authToken 授权token
	 * @param remoteAddr 请求主机ip
	 * @return prepayId 预支付id
	 */
	String unifiedOrder(String openid, String remoteAddr, String orderId);
	
	/**
	 * 申请退款接口
	 */
	String refund();
}
