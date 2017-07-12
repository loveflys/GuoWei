package com.guowei.controller;
import java.io.IOException;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.guowei.common.pojo.QiniuRes;
import com.guowei.common.pojo.QiniuTokenEntity;
import com.guowei.common.utils.ParamUtils;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * @描述：文件上传Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2017-7-12 下午11:08:43
 */
@Controller
public class FileController {
	private String ACCESS_KEY= "1xngTYdETpxM_jFGZ6HkfTno7XQ5__NlSWnPSdpD";
	private String SECRET_KEY= "o-Br46JzSVfuglvY6nMhW-3WDllXPWpgnyBKhGLW";
	private String BUCKET= "guoweiimage";
	private String URL= "http://osz2k3fxc.bkt.clouddn.com/";
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	 public @ResponseBody
	 String handleFileUpload(
	         @RequestParam("file") MultipartFile file){
		 //密钥配置
		 Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		 Zone z = Zone.autoZone();
		 Configuration c = new Configuration(z);
		 UploadManager uploadManager = new UploadManager(c);
		 String token = auth.uploadToken(BUCKET);
		 String result = "";
		 if (!file.isEmpty()) {
			 Date now = new Date();
			 try {
				Response res = uploadManager.put(file.getBytes(), now.getTime()+"_"+ParamUtils.generateString(8), token);	
				String key = res.jsonToObject(QiniuRes.class).getKey();
				result = URL + key;
			} catch (QiniuException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }
	     return result;
	 }
	
	@RequestMapping("/getToken")
	public QiniuTokenEntity getToken() {
		QiniuTokenEntity result = new QiniuTokenEntity();
	  //密钥配置
	    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	    String token = auth.uploadToken(BUCKET);
	    result.setOk();
	    result.setToken(token);
	    result.setUrl(URL);
		return result;
	}
}
