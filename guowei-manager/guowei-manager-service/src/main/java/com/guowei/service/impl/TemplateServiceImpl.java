package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwTemplateMapper;
import com.guowei.mapper.GwTemplateproductMapper;
import com.guowei.pojo.GwTemplate;
import com.guowei.pojo.GwTemplateExample;
import com.guowei.pojo.GwTemplateExample.Criteria;
import com.guowei.pojo.GwTemplateproductExample;
import com.guowei.service.TemplateService;
/**
 * 模板管理Service
 * @author 陈安一
 *
 */
@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {
	@Autowired
	private GwTemplateMapper templateMapper;
	@Autowired
	private GwTemplateproductMapper templateproductMapper;
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public GwTemplate getGwTemplateById(long parseLong) {
		GwTemplate res = templateMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int addGwTemplate(GwTemplate template) {
		int res = templateMapper.insert(template);
		return res;
	}
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int editGwTemplate(GwTemplate template) {
		int res = templateMapper.updateByPrimaryKey(template);
		return res;
	}
	@Override
	public int removeGwTemplate(long id) {
		GwTemplateproductExample example = new GwTemplateproductExample();
		example.createCriteria().andTidEqualTo(id);
		templateproductMapper.deleteByExample(example);
		int res = templateMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public DatatablesView<?> getGwTemplatesByPagedParam(GwTemplate template, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwTemplateExample gme = new GwTemplateExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(template.getName())) {
			criteria.andNameLike("%"+template.getName()+"%");
		}	
		if (template.getSupplierid() != null && template.getSupplierid() > 0) {
			criteria.andSupplieridEqualTo(template.getSupplierid());
		}		
		int pageNum = (start/pageSize)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwTemplate> list = templateMapper.selectByExample(gme);
		PageInfo<GwTemplate> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public DatatablesView<?> getGwTemplatesByParam(GwTemplate template) {
		// TODO Auto-generated method stub
		GwTemplateExample gme = new GwTemplateExample();
		Criteria criteria = gme.createCriteria();
		if (template.getSupplierid() > 0) {
			criteria.andSupplieridEqualTo(template.getSupplierid());
		}		
		List<GwTemplate> list = templateMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
