package com.guowei.common.pojo;

import java.util.Map;

public class WeChatTemplate {
	private String touser;
	private String template_id;
	private Map<String, TemplateData> data;  
	public String getTouser() {  
        return touser;  
    }  
  
    public void setTouser(String touser) {  
        this.touser = touser;  
    }  
  
    public String getTemplate_id() {  
        return template_id;  
    }  
  
    public void setTemplate_id(String template_id) {  
        this.template_id = template_id;  
    }  
  
    public Map<String, TemplateData> getData() {  
        return data;  
    }  
  
    public void setData(Map<String, TemplateData> data) {  
        this.data = data;  
    }  
}
