package com.guowei.utils;

import org.springframework.ui.ModelMap;  
import org.springframework.web.context.request.WebRequest;  
import org.springframework.web.context.request.WebRequestInterceptor;  
  
public class AllInterceptor implements WebRequestInterceptor {  
      
    /** 
     * 在请求处理之前执行，该方法主要是用于准备资源数据的，然后可以把它们当做请求属性放到WebRequest中 
     */  
    @Override  
    public void preHandle(WebRequest request) throws Exception {  
        // TODO Auto-generated method stub  
//        System.out.println("请求开始==>"+ request.getDescription(true));
    }  
  
    /** 
     * 该方法将在Controller执行之后，返回视图之前执行，ModelMap表示请求Controller处理之后返回的Model对象，所以可以在 
     * 这个方法中修改ModelMap的属性，从而达到改变返回的模型的效果。 
     */  
    @Override  
    public void postHandle(WebRequest request, ModelMap map) throws Exception {  
        // TODO Auto-generated method stub  
//    	System.out.println("返回数据==>");
//        if (map != null) {
//        	for (String key:map.keySet())  
//                System.out.println(key + "-------------------------");;  
//        }  
    }  
  
    /** 
     * 该方法将在整个请求完成之后，也就是说在视图渲染之后进行调用，主要用于进行一些资源的释放 
     */  
    @Override  
    public void afterCompletion(WebRequest request, Exception exception)  
    throws Exception {  
        
    }  
      
}  
