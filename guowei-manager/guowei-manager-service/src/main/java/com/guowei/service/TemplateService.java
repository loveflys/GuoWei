package com.guowei.service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwTemplate;

@Transactional
public interface TemplateService {
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	GwTemplate getGwTemplateById(long parseLong);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwTemplatesByParam(GwTemplate template);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwTemplatesByPagedParam(GwTemplate template, Integer start, Integer pageSize);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int addGwTemplate(GwTemplate template);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int editGwTemplate(GwTemplate template);

	int removeGwTemplate(long id);
}
