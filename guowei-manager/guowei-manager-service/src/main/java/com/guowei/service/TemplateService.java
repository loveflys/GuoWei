package com.guowei.service;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwTemplate;

public interface TemplateService {

	GwTemplate getGwTemplateById(long parseLong);
	
	DatatablesView<?> getGwTemplatesByParam(GwTemplate template);
	
	DatatablesView<?> getGwTemplatesByPagedParam(GwTemplate template, Integer start, Integer pageSize);

	int addGwTemplate(GwTemplate template);

	int editGwTemplate(GwTemplate template);

	int removeGwTemplate(long id);
}
