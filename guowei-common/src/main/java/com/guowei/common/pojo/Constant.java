package com.guowei.common.pojo;

public class Constant {
	/**
	 * 公众号AppId
	 */
	public static final String APP_ID = "wx8563cf7cd5154a95";
	
	/**
	 * 管理员openid
	 */
	public static final String MANAGER_OPENID = "opD421XGWhBtUfhi1ej4W5SPPz3M";
	
	/**
	 * 消息模板id
	 */
	public static final String MSG_ID = "MfWQ9I1F9bbxDhLiPisglyDPAcdq8pmBLT5yEVxPSkc";

	/**
	 * 公众号AppSecret
	 */
	public static final String APP_SECRET = "88bb05c605de839c2fc6f29eed7bcce0";

	/**
	 * 微信支付商户号
	 */
	public static final String MCH_ID = "1441608002";

	/**
	 * 微信支付API秘钥
	 */
	public static final String KEY = "QBmgXTJP7QDTudt42qN4Jy2zuc2BvfYh";

	/**
	 * 微信交易类型:公众号支付
	 */
	public static final String TRADE_TYPE_JSAPI = "JSAPI";

	/**
	 * WEB
	 */
	public static final String WEB = "WEB";

	/**
	 * 返回成功字符串
	 */
	public static final String RETURN_SUCCESS = "SUCCESS";

	/**
	 * 支付地址(包涵回调地址)
	 */
	public static final String PAY_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2bef02f0ed84edfc&redirect_uri=http%3a%2f%2fwxpay.pes-soft.com%2fwxpay%2fm%2fweChat%2funifiedOrder&response_type=code&scope=snsapi_base#wechat_redirect";

	/**
	 * 微信统一下单url
	 */
	public static final String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	/**
	 * 微信申请退款url
	 */
	public static final String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	
	/**
	 * 微信发送模板消息url
	 */
	public static final String SENDMSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send";

	/**
	 * 微信支付通知url
	 */
	public static final String NOTIFY_URL = "http://wxpay.pes-soft.com/wxpay/";
	
	/**
	 * 证书位置
	 */
	public static final String CERT_PATH = "H:/Ws/pes-wxpay/src/main/webapp/cert/apiclient_cert.p12";

	/**
	 * 通过code获取授权access_token的URL
	 */
	public static String Authtoken_URL(String code) {
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
		url.append(Constant.APP_ID);
		url.append("&secret=");
		url.append(Constant.APP_SECRET);
		url.append("&code=");
		url.append(code);
		url.append("&grant_type=authorization_code");
		return url.toString();
	}
}
