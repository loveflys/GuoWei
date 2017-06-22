package com.guowei.common.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

public class HttpHelper {
	/**   
     * 发起http请求获取返回结果   
     * @param req_url 请求地址   
     * @return   
     */   
    public static JSONObject httpRequest(String req_url) {  
        StringBuffer buffer = new StringBuffer();    
        try {    
            URL url = new URL(req_url);    
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();    
     
            httpUrlConn.setDoOutput(true);    
            httpUrlConn.setDoInput(true);    
            httpUrlConn.setUseCaches(false);    
            httpUrlConn.setConnectTimeout(50000);  
            httpUrlConn.setReadTimeout(50000);  
            httpUrlConn.setRequestMethod("GET");   
            httpUrlConn.connect();  //发送请求  
            if (httpUrlConn.getResponseCode() == 200) {                    
                // 将返回的输入流转换成字符串    
                InputStream inputStream = httpUrlConn.getInputStream();    
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");    
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);    
         
                String str = null;    
                while ((str = bufferedReader.readLine()) != null) {    
                    buffer.append(str);    
                }    
                bufferedReader.close();    
                inputStreamReader.close();    
                // 释放资源    
                inputStream.close();    
                inputStream = null;    
                httpUrlConn.disconnect();                                
            }       
     
        } catch (Exception e) {    
            System.out.println(e.getStackTrace());    
        }    
        return JSONObject.parseObject(buffer.toString());    
    }  
}
