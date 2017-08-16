package com.guowei.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 * @author 陈安一
 *
 */
@Controller
public class PageController {
	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex () {		
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		java.util.Date now = new java.util.Date();
		System.out.println("time==>" + now.getYear() + "-" + now.getMonth() + "-" + now.getDate() +" || 页面请求==>" + page);
		return page;
	}
	
	@RequestMapping("/MP_verify_agdIGsYMS7odHhoZ.txt") 
	public String wechattxt(HttpServletRequest request,HttpServletResponse response, HttpSession session) {
		String fileName="MP_verify_agdIGsYMS7odHhoZ.txt";
        
        response.reset();// 不加这一句的话会出现下载错误 
//        response.setHeader("Content-disposition", "attachment; filename="+fileName);// 设定输出文件头   
        response.setContentType("text/x-plain");// 定义输出类型 
        
        try {
            ServletOutputStream out = response.getOutputStream();
            
            String path = session.getServletContext().getRealPath("/")+fileName;
            File file = new File(session.getServletContext().getRealPath("/")+fileName);
            FileOutputStream fos = new FileOutputStream(file);   
            Writer writer = new OutputStreamWriter(fos, "utf-8");   
            
            String text="agdIGsYMS7odHhoZ";
            writer.write(text);   
            writer.close();   
            fos.close();  
            
            
            FileInputStream fis = new java.io.FileInputStream(file);
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream(4096);
            
            byte[] cache = new byte[4096];
            for (int offset = fis.read(cache); offset != -1; offset = fis.read(cache)) {
                    byteOutputStream.write(cache, 0, offset);
            }
            
            byte[] bt = null;
            bt = byteOutputStream.toByteArray();               
            
            out.write(bt);
            out.flush();
            out.close();
            fis.close();
//            if(file.exists()){
//                file.delete();
//            }            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        return null;
	}
}
