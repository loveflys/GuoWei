package com.guowei.controller;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @描述：文件上传Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2017-7-12 下午11:08:43
 */
@Controller
public class FileController {
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	 public @ResponseBody
	 String handleFileUpload(
	         @RequestParam("file") MultipartFile file){
		 System.out.println(file.isEmpty());
		 String ACCESS_KEY = "";
		 String SECRET_KEY = "";
		 //密钥配置
		 Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		 Zone z = Zone.autoZone();
		 Configuration c = new Configuration(z);
		 UploadManager uploadManager = new UploadManager(c);
		 String token = auth.uploadToken(qiniuConfig.getBname());
		 FileEntity result = new FileEntity();
		 if (!file.isEmpty()) {
			 Date now = new Date();
			 try {
				Response res = uploadManager.put(file.getBytes(), now.getTime()+"_"+ParamUtils.generateString(8), token);	
				String key = res.jsonToObject(QiniuRes.class).getKey();
				result.setOk();
			    result.setUrl(qiniuConfig.getUrl() + key);
			} catch (QiniuException e) {
				// TODO Auto-generated catch block
				result.setErr("-200", e.response.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				result.setErr("-200", e.getMessage());
			}
	     } else {
			 result.setErr("-200", "文件呢？？？");
	     }
	     return result;
	 }

	@ApiOperation("获取图片")
	@GetMapping("/images/{path}")
	public void getImage(HttpServletRequest request,
						 @PathVariable("path") String path,
						 HttpServletResponse response) {
		try {
			File dest = new File(filePath + path+".jpg");
			RenderedImage image = ImageIO.read(dest);
			// 设置响应类型
			response.setContentType("image/jpeg");
			response.addHeader("Pragma", "No-cache");
			response.addHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expire", 0l);
			// 输出图片
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (Exception e) {
			log.info(request.getRemoteAddr()+"的用户请求api==>"+request.getRequestURL()+"抛出异常==>"+e.getMessage());
		}
	}
	
	@ApiOperation("获取七牛云token")
	@GetMapping("/getToken")
	public QiniuTokenEntity getToken() {
		QiniuTokenEntity result = new QiniuTokenEntity();
		String ACCESS_KEY = qiniuConfig.getAk();
	    String SECRET_KEY = qiniuConfig.getSk();
	  //密钥配置
	    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	    String token = auth.uploadToken(qiniuConfig.getBname());
	    result.setOk();
	    result.setToken(token);
	    result.setUrl(qiniuConfig.getUrl());
		return result;
	}
}
