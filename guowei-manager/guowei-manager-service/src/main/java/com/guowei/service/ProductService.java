package com.guowei.service;
import com.guowei.common.pojo.SimpleListResult;
import com.guowei.pojo.GwProduct;

public interface ProductService {
	GwProduct getProductById(long id);
	
	SimpleListResult getProductList(int pageNum, int pageSize);
}
