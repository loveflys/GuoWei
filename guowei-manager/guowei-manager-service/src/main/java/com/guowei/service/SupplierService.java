package com.guowei.service;
import org.springframework.transaction.annotation.Transactional;

import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwSupplier;

@Transactional
public interface SupplierService {

	GwSupplier getGwSupplierById(long parseLong);
	
	DatatablesView<?> getGwSuppliersByParam(GwSupplier supplier);
	
	DatatablesView<?> getGwSuppliers(String level);
	
	DatatablesView<?> getGwSuppliersByPagedParam(GwSupplier supplier, Integer start, Integer pageSize);

	int addGwSupplier(GwSupplier supplier);

	int editGwSupplier(GwSupplier supplier);

	int removeGwSupplier(long id);
}
