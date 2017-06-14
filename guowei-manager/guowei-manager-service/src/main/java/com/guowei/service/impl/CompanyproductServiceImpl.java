package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwCompanyproductMapper;
import com.guowei.pojo.GwCompanyproduct;
import com.guowei.pojo.GwCompanyproductExample;
import com.guowei.pojo.GwCompanyproductExample.Criteria;
import com.guowei.service.CompanyproductService;
/**
 * 公司产品管理Service
 * @author 陈安一
 *
 */
@Service
public class CompanyproductServiceImpl implements CompanyproductService {
	@Autowired
	private GwCompanyproductMapper companyproductMapper;
	@Override
	public GwCompanyproduct getGwCompanyproductById(long parseLong) {
		GwCompanyproduct res = companyproductMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public int addGwCompanyproduct(GwCompanyproduct companyproduct) {
		int res = companyproductMapper.insert(companyproduct);
		return res;
	}
	@Override
	public int editGwCompanyproduct(GwCompanyproduct companyproduct) {
		int res = companyproductMapper.updateByPrimaryKey(companyproduct);
		return res;
	}
	@Override
	public int removeGwCompanyproduct(long id) {
		int res = companyproductMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwCompanyproductsByPagedParam(GwCompanyproduct companyproduct, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwCompanyproductExample gme = new GwCompanyproductExample();
		Criteria criteria = gme.createCriteria();
//		if (!"".equals(companyproduct.getCompanyproductName())) {
//			criteria.andCompanyproductNameLike(companyproduct.getCompanyproductName());
//			gme.or(gme.createCriteria().andCompanyproductContactphoneLike(companyproduct.getCompanyproductName()));
//		}		
		int pageNum = (start/10)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwCompanyproduct> list = companyproductMapper.selectByExample(gme);
		PageInfo<GwCompanyproduct> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwCompanyproductsByParam(GwCompanyproduct companyproduct) {
		// TODO Auto-generated method stub
		GwCompanyproductExample gme = new GwCompanyproductExample();
		Criteria criteria = gme.createCriteria();
//		if (!"".equals(companyproduct.get)) {
//			criteria.andCompanyproductNameLike(companyproduct.getCompanyproductName());
//			gme.or(gme.createCriteria().andCompanyproductContactphoneLike(companyproduct.getCompanyproductName()));
//		}		
		List<GwCompanyproduct> list = companyproductMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
