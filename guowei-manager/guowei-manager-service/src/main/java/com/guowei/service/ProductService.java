package com.guowei.service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwProduct;

@Transactional
public interface ProductService {
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	GwProduct getGwProductById(long parseLong);

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	GwProduct getGwProductByTitle(String title);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwProductsByParam(GwProduct product);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwProductsByPagedParam(GwProduct product, Integer start, Integer pageSize);

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int addGwProduct(GwProduct product);

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int editGwProduct(GwProduct product);

	int removeGwProduct(long id);
}
