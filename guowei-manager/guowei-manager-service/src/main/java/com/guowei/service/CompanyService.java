package com.guowei.service;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwCompany;

public interface CompanyService {

	GwCompany getGwCompanyById(long parseLong);
	
	DatatablesView<?> getGwCompanysByParam(GwCompany company);
	
	DatatablesView<?> getGwCompanysByPagedParam(GwCompany company, Integer start, Integer pageSize);

	int addGwCompany(GwCompany company);

	int editGwCompany(GwCompany company);

	int removeGwCompany(long id);
}
