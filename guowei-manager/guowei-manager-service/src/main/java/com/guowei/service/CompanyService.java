package com.guowei.service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwCompany;
import com.guowei.pojo.GwCompanyTemp;

@Transactional
public interface CompanyService {
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	GwCompany getGwCompanyById(long parseLong);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwCompanysByParam(GwCompany company);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwCompanysByPagedParam(GwCompany company, Integer start, Integer pageSize);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwCompanyTempsByParam(GwCompanyTemp company);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwCompanyTempsByPagedParam(GwCompanyTemp company, Integer start, Integer pageSize);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int addGwCompany(GwCompany company);
	
	int editGwCompany(GwCompany company);

	int removeGwCompany(long id);
	
	GwCompanyTemp selectById(Long id);
}
