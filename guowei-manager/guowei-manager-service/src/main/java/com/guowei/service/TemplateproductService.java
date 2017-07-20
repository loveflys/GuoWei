package com.guowei.service;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwTemplateproduct;

public interface TemplateproductService {

	GwTemplateproduct getGwTemplateproductById(long parseLong);
	
	DatatablesView<?> getGwTemplateproductsByParam(GwTemplateproduct templateproduct);
	
	DatatablesView<?> getGwTemplateproductsByPagedParam(GwTemplateproduct templateproduct, Integer start, Integer pageSize);

	int addGwTemplateproduct(GwTemplateproduct templateproduct);

	int editGwTemplateproduct(GwTemplateproduct templateproduct);

	int removeGwTemplateproduct(long id);
}
