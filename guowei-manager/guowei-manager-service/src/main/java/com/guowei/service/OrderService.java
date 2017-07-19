package com.guowei.service;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwOrder;
import com.guowei.pojo.GwOrderdetail;

@Transactional
public interface OrderService {
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	GwOrder getGwOrderById(long parseLong);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwOrdersByParam(GwOrder order);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	DatatablesView<?> getGwOrdersByPagedParam(GwOrder order, Integer start, Integer pageSize);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int addGwOrder(GwOrder order);
	
	int createGwOrder(GwOrder order, List<GwOrderdetail> orderdetail) throws UnsupportedEncodingException;

	int editGwOrder(GwOrder order);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int removeGwOrder(long id);
}
