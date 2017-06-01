package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guowei.mapper.GwProductMapper;
import com.guowei.pojo.GwProduct;
import com.guowei.pojo.GwProductExample;
import com.guowei.pojo.GwProductExample.Criteria;
import com.guowei.service.ProductService;
/**
 * 商品管理Service
 * @author 陈安一
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private GwProductMapper productMapper;
	@Override
	public GwProduct getProductById(long id) {
		
//		GwProduct pro = productMapper.selectByPrimaryKey(id);
		
		GwProductExample example = new GwProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<GwProduct> list = productMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			GwProduct pro = list.get(0);
			return pro;
		}
		return null;
	}

}
