package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.MessageView;
import com.guowei.mapper.GwCompanyproductMapper;
import com.guowei.mapper.GwProductMapper;
import com.guowei.pojo.GwCompanyproduct;
import com.guowei.pojo.GwCompanyproductExample;
import com.guowei.pojo.GwCompanyproductExample.Criteria;
import com.guowei.pojo.GwProduct;
import com.guowei.service.CompanyproductService;
/**
 * 公司产品管理Service
 * @author 陈安一
 *
 */
@Service
@Transactional
public class CompanyproductServiceImpl implements CompanyproductService {
	@Autowired
	private GwCompanyproductMapper companyproductMapper;
	@Autowired
	private GwProductMapper productMapper;
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public GwCompanyproduct getGwCompanyproductById(long parseLong) {
		GwCompanyproduct res = companyproductMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int addGwCompanyproduct(GwCompanyproduct companyproduct) {
		int res = companyproductMapper.insert(companyproduct);
		return res;
	}
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int editGwCompanyproduct(GwCompanyproduct companyproduct) {
		int res = companyproductMapper.updateByPrimaryKey(companyproduct);
		return res;
	}
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int removeGwCompanyproduct(long id) {
		int res = companyproductMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public DatatablesView<?> getGwCompanyproductsByPagedParam(GwCompanyproduct companyproduct, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwCompanyproductExample gme = new GwCompanyproductExample();
		Criteria criteria = gme.createCriteria();
//		if (!"".equals(companyproduct.getCompanyproductName())) {
//			criteria.andCompanyproductNameLike(companyproduct.getCompanyproductName());
//			gme.or(gme.createCriteria().andCompanyproductContactphoneLike(companyproduct.getCompanyproductName()));
//		}		
		int pageNum = (start/pageSize)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwCompanyproduct> list = companyproductMapper.selectByExample(gme);
		PageInfo<GwCompanyproduct> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public DatatablesView<?> getGwCompanyproductsByParam(GwCompanyproduct companyproduct) {
		// TODO Auto-generated method stub
		GwCompanyproductExample gme = new GwCompanyproductExample();
		Criteria criteria = gme.createCriteria();
		criteria.andCompanyIdEqualTo(companyproduct.getCompanyId());
		List<GwCompanyproduct> list = companyproductMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
	@Override
	public int addCompanyProductStock(long id, int addstock) {
		GwCompanyproduct cp = companyproductMapper.selectByPrimaryKey(id);
		int res = 0;
		int update = 1;
		if (cp != null) {
			cp.setStock(cp.getStock() + addstock);
			res = companyproductMapper.updateByPrimaryKey(cp);	
			GwProduct pro = productMapper.selectByPrimaryKey(cp.getPid());
			pro.setStock(pro.getStock() - addstock);
			pro.setDistribute(pro.getDistribute() + addstock);
			update = productMapper.updateByPrimaryKey(pro);
		}
		return (res == 1 && update == 1)?1:0;
	}
}
