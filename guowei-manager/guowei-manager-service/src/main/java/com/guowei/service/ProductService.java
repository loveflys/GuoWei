package com.guowei.service;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwProduct;

public interface ProductService {

	GwProduct getGwProductById(long parseLong);

	GwProduct getGwProductByTitle(String title);
	
	DatatablesView<?> getGwProductsByParam(GwProduct product);
	
	DatatablesView<?> getGwProductsByPagedParam(GwProduct product, Integer start, Integer pageSize);

	int addGwProduct(GwProduct product);

	int editGwProduct(GwProduct product);

	int removeGwProduct(long id);
}
