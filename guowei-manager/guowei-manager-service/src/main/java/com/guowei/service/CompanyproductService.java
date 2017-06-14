package com.guowei.service;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwCompanyproduct;

public interface CompanyproductService {

	GwCompanyproduct getGwCompanyproductById(long parseLong);
	
	DatatablesView<?> getGwCompanyproductsByParam(GwCompanyproduct companyproduct);
	
	DatatablesView<?> getGwCompanyproductsByPagedParam(GwCompanyproduct companyproduct, Integer start, Integer pageSize);

	int addGwCompanyproduct(GwCompanyproduct companyproduct);

	int editGwCompanyproduct(GwCompanyproduct companyproduct);

	int removeGwCompanyproduct(long id);
}
