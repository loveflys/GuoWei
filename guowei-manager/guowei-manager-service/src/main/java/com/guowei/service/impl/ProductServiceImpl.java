package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwProductMapper;
import com.guowei.pojo.GwProduct;
import com.guowei.pojo.GwProductExample;
import com.guowei.pojo.GwProduct;
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
	public GwProduct getGwProductById(long parseLong) {
		GwProduct res = productMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public GwProduct getGwProductByTitle(String title) {
		GwProductExample example = new GwProductExample();
		Criteria c = example.createCriteria();
		c.andTitleLike(title);
		List<GwProduct> res = productMapper.selectByExample(example);
		if (res != null && res.size() > 0) {
			return res.get(0);
		}
		return null;
	}
	@Override
	public int addGwProduct(GwProduct product) {
		int res = productMapper.insert(product);
		return res;
	}
	@Override
	public int editGwProduct(GwProduct product) {
		int res = productMapper.updateByPrimaryKey(product);
		return res;
	}
	@Override
	public int removeGwProduct(long id) {
		int res = productMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwProductsByPagedParam(GwProduct product, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwProductExample gme = new GwProductExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(product.getTitle())) {
			criteria.andTitleLike(product.getTitle());
		}		
		int pageNum = (start/10)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwProduct> list = productMapper.selectByExample(gme);
		PageInfo<GwProduct> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwProductsByParam(GwProduct product) {
		// TODO Auto-generated method stub
		GwProductExample gme = new GwProductExample();
		List<GwProduct> list = productMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
