package com.guowei.common.utils;

import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.guowei.common.pojo.Secret;

public class WeiXinOAuth
{
	/// <summary>
	/// 获取微信Code
	/// </summary>
	/// <param name="appId"></param>
	/// <param name="appSecret"></param>
	/// <param name="redirectUrl"></param>
	public String GetWeiXinCode(String appId,String appSecret,String redirectUrl)
	{
		Random r = new Random();
		//微信登录授权
		//String url = "https://open.weixin.qq.com/connect/qrconnect?appid=" + appId + "&redirect_uri=" + redirectUrl +"&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect";
		//微信OpenId授权
		//String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appId + "&redirect_uri=" + redirectUrl +"&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect";
		//微信用户信息授权
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appId + "&redirect_uri=" + redirectUrl + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		return url;
	}
	/// <summary>
	/// 通过code获取access_token
	/// </summary>
	/// <param name="appId"></param>
	/// <param name="appSecret"></param>
	/// <param name="code"></param>
	/// <returns></returns>
	public static JSONObject GetWeiXinAccessToken(String appId,String appSecret,String code)
	{
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appId+"&secret="+appSecret+
			"&code="+ code + "&grant_type=authorization_code";
		JSONObject result = HttpHelper.httpRequest(url);		
		return result;
	}
	
	public static JSONObject GetWeiXinAccessToken(String appId,String appSecret)
	{
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appId+"&secret="+appSecret;
		JSONObject result = HttpHelper.httpRequest(url);		
		return result;
	}
	
	public static JSONObject GetWeiXinShortUrl(String token,String longUrl)
	{
		String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token="+token;
		String param = "{\"action\":\"long2short\","  
                + "\"long_url\":\""+longUrl+"\"}"; 
		JSONObject result = HttpHelper.httpRequest(url, "POST", param);		
		return result;
	}
	
	public static JSONObject SendTemplateMsg(String actoken,String params)
	{
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+actoken;
		JSONObject result = HttpHelper.httpPost(url, params);		
		return result;
	}
	/// <summary>
	/// 拉取用户信息
	/// </summary>
	/// <param name="accessToken"></param>
	/// <param name="openId"></param>
	/// <returns></returns>
	public static JSONObject GetWeiXinUserInfo(String accessToken,String openId)
	{
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken+"&openid="+openId+"⟨=zh_CN";
		JSONObject result = HttpHelper.httpRequest(url);		
		return result;
	}
}
