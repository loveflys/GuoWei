package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwCompanyMapper;
import com.guowei.mapper.GwCompanyproductMapper;
import com.guowei.mapper.GwTemplateproductMapper;
import com.guowei.pojo.GwCompany;
import com.guowei.pojo.GwCompanyExample;
import com.guowei.pojo.GwCompanyExample.Criteria;
import com.guowei.pojo.GwCompanyTemp;
import com.guowei.pojo.GwCompanyproduct;
import com.guowei.pojo.GwCompanyproductExample;
import com.guowei.pojo.GwTemplateproduct;
import com.guowei.pojo.GwTemplateproductExample;
import com.guowei.service.CompanyService;

/**
 * 公司管理Service
 * 
 * @author 陈安一
 *
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private GwCompanyMapper companyMapper;
	@Autowired
	private GwCompanyproductMapper companyproductMapper;
	@Autowired
	private GwTemplateproductMapper templateproductMapper;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public GwCompany getGwCompanyById(long parseLong) {
		GwCompany res = companyMapper.selectByPrimaryKey(parseLong);
		return res;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int addGwCompany(GwCompany company) {
		// 1、获取模板商品
		GwTemplateproductExample example2 = new GwTemplateproductExample();
		example2.createCriteria().andTidEqualTo(company.getTemplateId());
		List<GwTemplateproduct> list = templateproductMapper.selectByExample(example2);
		for (GwTemplateproduct gwTemplateproduct : list) {
			// 2、依次添加为公司产品
			GwCompanyproduct cp = new GwCompanyproduct();
			cp.setCompanyId(company.getId());
			cp.setProname(gwTemplateproduct.getProname());
			cp.setProimage(gwTemplateproduct.getProimage());
			cp.setProprice(gwTemplateproduct.getProprice());
			cp.setPid(gwTemplateproduct.getPid());
			cp.setSellcount(0);
			cp.setSellprice(gwTemplateproduct.getProprice());
			cp.setStatus(Byte.parseByte("1"));
			cp.setStock(gwTemplateproduct.getStock());
			cp.setStorageracks(gwTemplateproduct.getStorageracks());
			int insertResult = companyproductMapper.insert(cp);
		}
		int res = companyMapper.insert(company);
		return res;
	}

	@Override
	public int editGwCompany(GwCompany company) {
		GwCompany temp = companyMapper.selectByPrimaryKey(company.getId());
		if (company.getTemplateId() != null && temp.getTemplateId() != company.getTemplateId()) {
			// 替换公司模板
			// 1、删除原公司产品
			GwCompanyproductExample example1 = new GwCompanyproductExample();
			example1.createCriteria().andCompanyIdEqualTo(company.getId());
			int deleteResult = companyproductMapper.deleteByExample(example1);
			// 2、获取模板商品
			GwTemplateproductExample example2 = new GwTemplateproductExample();
			example2.createCriteria().andTidEqualTo(company.getTemplateId());
			List<GwTemplateproduct> list = templateproductMapper.selectByExample(example2);
			for (GwTemplateproduct gwTemplateproduct : list) {
				// 3、依次添加为公司产品
				GwCompanyproduct cp = new GwCompanyproduct();
				cp.setCompanyId(company.getId());
				cp.setPid(gwTemplateproduct.getPid());
				cp.setProname(gwTemplateproduct.getProname());
				cp.setProimage(gwTemplateproduct.getProimage());
				cp.setProprice(gwTemplateproduct.getProprice());
				cp.setSellcount(0);
				cp.setSellprice(gwTemplateproduct.getProprice());
				cp.setStatus(Byte.parseByte("1"));
				cp.setStock(gwTemplateproduct.getStock());
				cp.setStorageracks(gwTemplateproduct.getStorageracks());
				int insertResult = companyproductMapper.insert(cp);
			}
		}
		int res = companyMapper.updateByPrimaryKey(company);
		return res;
	}

	@Override
	public int removeGwCompany(long id) {
		GwCompanyproductExample example = new GwCompanyproductExample();
		example.createCriteria().andCompanyIdEqualTo(id);
		int deleteResult = companyproductMapper.deleteByExample(example);
		int res = companyMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public DatatablesView<?> getGwCompanysByPagedParam(GwCompany company, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwCompanyExample gme = new GwCompanyExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(company.getCompanyName())) {
			criteria.andCompanyNameLike(company.getCompanyName());
			gme.or(gme.createCriteria().andCompanyContactphoneLike(company.getCompanyName()));
		}
		int pageNum = (start / pageSize) + 1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwCompany> list = companyMapper.selectByExample(gme);
		PageInfo<GwCompany> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int) page.getTotal());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
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

	@Override
	public GwCompanyTemp selectById(Long id) {
		GwCompanyTemp res = companyMapper.selectById(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwCompanyTempsByParam(GwCompanyTemp company) {
		// TODO Auto-generated method stub
		GwCompanyExample gme = new GwCompanyExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(company.getCompanyName())) {
			criteria.andCompanyNameLike(company.getCompanyName());
			gme.or(gme.createCriteria().andCompanyContactphoneLike(company.getCompanyName()));
		}
		List<GwCompanyTemp> list = companyMapper.selectTempByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}

	@Override
	public DatatablesView<?> getGwCompanyTempsByPagedParam(GwCompanyTemp company, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwCompanyExample gme = new GwCompanyExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(company.getCompanyName())) {
			criteria.andCompanyNameLike(company.getCompanyName());
			gme.or(gme.createCriteria().andCompanyContactphoneLike(company.getCompanyName()));
		}
		int pageNum = (start / pageSize) + 1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwCompanyTemp> list = companyMapper.selectTempByExample(gme);
		PageInfo<GwCompanyTemp> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int) page.getTotal());
		return result;
	}
}
