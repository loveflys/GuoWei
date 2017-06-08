package com.guowei.service;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwOrder;

public interface OrderService {

	GwOrder getGwOrderById(long parseLong);
	
	DatatablesView<?> getGwOrdersByParam(GwOrder order);
	
	DatatablesView<?> getGwOrdersByPagedParam(GwOrder order, Integer start, Integer pageSize);

	int addGwOrder(GwOrder order);

	int editGwOrder(GwOrder order);

	int removeGwOrder(long id);
}
