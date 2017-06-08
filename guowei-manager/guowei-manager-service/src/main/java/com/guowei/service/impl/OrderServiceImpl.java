package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwOrderMapper;
import com.guowei.pojo.GwOrder;
import com.guowei.pojo.GwOrderExample;
import com.guowei.pojo.GwOrderExample.Criteria;
import com.guowei.service.OrderService;
/**
 * 订单管理Service
 * @author 陈安一
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private GwOrderMapper orderMapper;
	@Override
	public GwOrder getGwOrderById(long parseLong) {
		GwOrder res = orderMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public int addGwOrder(GwOrder order) {
		int res = orderMapper.insert(order);
		return res;
	}
	@Override
	public int editGwOrder(GwOrder order) {
		int res = orderMapper.updateByPrimaryKey(order);
		return res;
	}
	@Override
	public int removeGwOrder(long id) {
		int res = orderMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwOrdersByPagedParam(GwOrder order, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwOrderExample gme = new GwOrderExample();
		Criteria criteria = gme.createCriteria();
//		if (!"".equals(order.getTitle())) {
//			criteria.andTitleLike(order.getTitle());
//		}		
		int pageNum = (start/10)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwOrder> list = orderMapper.selectByExample(gme);
		PageInfo<GwOrder> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwOrdersByParam(GwOrder order) {
		// TODO Auto-generated method stub
		GwOrderExample gme = new GwOrderExample();
		Criteria criteria = gme.createCriteria();
//		if (!"".equals(order.getTitle())) {
//			criteria.andTitleLike(order.getTitle());
//		}		
		List<GwOrder> list = orderMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
