package com.guowei.service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwProduct;

@Transactional
public interface ProductService {
	
	GwProduct getGwProductById(long parseLong);

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	GwProduct getGwProductByTitle(String title);
	
	DatatablesView<?> getGwProductsByParam(GwProduct product);
	
	DatatablesView<?> getGwProductsByPagedParam(GwProduct product, Integer start, Integer pageSize, String order, String orderby);

	int addGwProduct(GwProduct product, Long mid);
	
	int addPurchase(String id,String purchaseNum,String purchasePrice,String mid);

	int editGwProduct(GwProduct product);

	int removeGwProduct(long id);
}
