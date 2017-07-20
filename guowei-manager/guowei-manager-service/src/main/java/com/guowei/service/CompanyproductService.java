package com.guowei.service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwCompanyproduct;

@Transactional
public interface CompanyproductService {

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	GwCompanyproduct getGwCompanyproductById(long parseLong);
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwCompanyproductsByParam(GwCompanyproduct companyproduct);
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwCompanyproductsByPagedParam(GwCompanyproduct companyproduct, Integer start, Integer pageSize);
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int addGwCompanyproduct(GwCompanyproduct companyproduct);
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int editGwCompanyproduct(GwCompanyproduct companyproduct);
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int removeGwCompanyproduct(long id);
	
	int addCompanyProductStock(long id, int addstock, Long mid);
}
