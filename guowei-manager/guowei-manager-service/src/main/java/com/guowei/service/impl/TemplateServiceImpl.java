package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwTemplateMapper;
import com.guowei.pojo.GwTemplate;
import com.guowei.pojo.GwTemplateExample;
import com.guowei.pojo.GwTemplateExample.Criteria;
import com.guowei.service.TemplateService;
/**
 * 模板管理Service
 * @author 陈安一
 *
 */
@Service
public class TemplateServiceImpl implements TemplateService {
	@Autowired
	private GwTemplateMapper templateMapper;
	@Override
	public GwTemplate getGwTemplateById(long parseLong) {
		GwTemplate res = templateMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public int addGwTemplate(GwTemplate template) {
		int res = templateMapper.insert(template);
		return res;
	}
	@Override
	public int editGwTemplate(GwTemplate template) {
		int res = templateMapper.updateByPrimaryKey(template);
		return res;
	}
	@Override
	public int removeGwTemplate(long id) {
		int res = templateMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwTemplatesByPagedParam(GwTemplate template, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwTemplateExample gme = new GwTemplateExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(template.getName())) {
			criteria.andNameLike(template.getName());
		}		
		int pageNum = (start/10)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwTemplate> list = templateMapper.selectByExample(gme);
		PageInfo<GwTemplate> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwTemplatesByParam(GwTemplate template) {
		// TODO Auto-generated method stub
		GwTemplateExample gme = new GwTemplateExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(template.getName())) {
			criteria.andNameLike(template.getName());
		}		
		List<GwTemplate> list = templateMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
