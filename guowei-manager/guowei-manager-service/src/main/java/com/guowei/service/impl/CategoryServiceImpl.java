package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwCategoryMapper;
import com.guowei.pojo.GwCategory;
import com.guowei.pojo.GwCategoryExample;
import com.guowei.pojo.GwCategoryExample.Criteria;
import com.guowei.service.CategoryService;
/**
 * 订单管理Service
 * @author 陈安一
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private GwCategoryMapper categoryMapper;
	@Override
	public GwCategory getGwCategoryById(long parseLong) {
		GwCategory res = categoryMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public int addGwCategory(GwCategory category) {
		int res = categoryMapper.insert(category);
		return res;
	}
	@Override
	public int editGwCategory(GwCategory category) {
		int res = categoryMapper.updateByPrimaryKey(category);
		return res;
	}
	@Override
	public int removeGwCategory(long id) {
		int res = categoryMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwCategorysByPagedParam(GwCategory category, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwCategoryExample gme = new GwCategoryExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(category.getName())) {
			criteria.andNameLike(category.getName());
		}		
		int pageNum = (start/pageSize)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwCategory> list = categoryMapper.selectByExample(gme);
		PageInfo<GwCategory> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwCategorysByParam(GwCategory category) {
		// TODO Auto-generated method stub
		GwCategoryExample gme = new GwCategoryExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(category.getName())) {
			criteria.andNameLike(category.getName());
		}		
		List<GwCategory> list = categoryMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
