package com.guowei.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

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
    
    /**
     * POST请求获取数据
     */
    public static JSONObject httpPost(String path,String post){
        URL url = null;
        try {
            url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            printWriter.write(post);//post的参数 xx=xx&yy=yy
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();
            return JSONObject.parseObject(bos.toString("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
