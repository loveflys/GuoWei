package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwCompanyMapper;
import com.guowei.pojo.GwCompany;
import com.guowei.pojo.GwCompanyExample;
import com.guowei.pojo.GwCompanyExample.Criteria;
import com.guowei.service.CompanyService;
/**
 * 公司管理Service
 * @author 陈安一
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private GwCompanyMapper companyMapper;
	@Override
	public GwCompany getGwCompanyById(long parseLong) {
		GwCompany res = companyMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public int addGwCompany(GwCompany company) {
		int res = companyMapper.insert(company);
		return res;
	}
	@Override
	public int editGwCompany(GwCompany company) {
		int res = companyMapper.updateByPrimaryKey(company);
		return res;
	}
	@Override
	public int removeGwCompany(long id) {
		int res = companyMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwCompanysByPagedParam(GwCompany company, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwCompanyExample gme = new GwCompanyExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(company.getCompanyName())) {
			criteria.andCompanyNameLike(company.getCompanyName());
			gme.or(gme.createCriteria().andCompanyContactphoneLike(company.getCompanyName()));
		}		
		int pageNum = (start/10)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwCompany> list = companyMapper.selectByExample(gme);
		PageInfo<GwCompany> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwCompanysByParam(GwCompany company) {
		// TODO Auto-generated method stub
		GwCompanyExample gme = new GwCompanyExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(company.getCompanyName())) {
			criteria.andCompanyNameLike(company.getCompanyName());
			gme.or(gme.createCriteria().andCompanyContactphoneLike(company.getCompanyName()));
		}		
		List<GwCompany> list = companyMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
