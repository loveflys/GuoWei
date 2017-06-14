package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwTemplateproductMapper;
import com.guowei.pojo.GwTemplateproduct;
import com.guowei.pojo.GwTemplateproductExample;
import com.guowei.pojo.GwTemplateproductExample.Criteria;
import com.guowei.service.TemplateproductService;
/**
 * 模板管理Service
 * @author 陈安一
 *
 */
@Service
public class TemplateproductServiceImpl implements TemplateproductService {
	@Autowired
	private GwTemplateproductMapper templateproductMapper;
	@Override
	public GwTemplateproduct getGwTemplateproductById(long parseLong) {
		GwTemplateproduct res = templateproductMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public int addGwTemplateproduct(GwTemplateproduct templateproduct) {
		int res = templateproductMapper.insert(templateproduct);
		return res;
	}
	@Override
	public int editGwTemplateproduct(GwTemplateproduct templateproduct) {
		int res = templateproductMapper.updateByPrimaryKey(templateproduct);
		return res;
	}
	@Override
	public int removeGwTemplateproduct(long id) {
		int res = templateproductMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwTemplateproductsByPagedParam(GwTemplateproduct templateproduct, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwTemplateproductExample gme = new GwTemplateproductExample();
		Criteria criteria = gme.createCriteria();
//		if (!"".equals(templateproduct.getName())) {
//			criteria.andNameLike(templateproduct.getName());
//		}		
		int pageNum = (start/10)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwTemplateproduct> list = templateproductMapper.selectByExample(gme);
		PageInfo<GwTemplateproduct> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwTemplateproductsByParam(GwTemplateproduct templateproduct) {
		// TODO Auto-generated method stub
		GwTemplateproductExample gme = new GwTemplateproductExample();
		Criteria criteria = gme.createCriteria();
//		if (!"".equals(templateproduct.getName())) {
//			criteria.andNameLike(templateproduct.getName());
//		}		
		List<GwTemplateproduct> list = templateproductMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
