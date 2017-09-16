package com.guowei.service;
import org.springframework.transaction.annotation.Transactional;

import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwSupplier;
import com.guowei.pojo.GwSupplierstorage;

@Transactional
public interface SupplierstorageService {

	GwSupplierstorage getGwSupplierstorageById(long parseLong);
	
	DatatablesView<?> getGwSupplierstoragesByParam(GwSupplierstorage supplier);
	
	DatatablesView<?> getGwSupplierstorages(String level);
	
	DatatablesView<?> getGwSupplierstoragesByPagedParam(GwSupplierstorage supplierstorage, Integer start, Integer pageSize);

	int addGwSupplierstorage(GwSupplierstorage supplierstorage);

	int editGwSupplierstorage(GwSupplierstorage supplierstorage);

	int removeGwSupplierstorage(long id);
}
