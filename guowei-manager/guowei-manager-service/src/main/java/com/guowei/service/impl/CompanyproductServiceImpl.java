package com.guowei.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.MessageView;
import com.guowei.mapper.GwCompanyprochangeMapper;
import com.guowei.mapper.GwCompanyproductMapper;
import com.guowei.mapper.GwProductMapper;
import com.guowei.pojo.GwCompanyprochange;
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
	private GwCompanyprochangeMapper companyproductchangeMapper;
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
		DatatablesView result = new DatatablesView();
		System.out.println("查询公司产品开始================");
		try {
			GwCompanyproductExample gme = new GwCompanyproductExample();
			Criteria criteria = gme.createCriteria();
	//		if (!"".equals(companyproduct.getCompanyproductName())) {
	//			criteria.andCompanyproductNameLike(companyproduct.getCompanyproductName());
	//			gme.or(gme.createCriteria().andCompanyproductContactphoneLike(companyproduct.getCompanyproductName()));
	//		}		
			int pageNum = (start/pageSize)+1;
			PageHelper.startPage(pageNum, pageSize);
			List<GwCompanyproduct> list = companyproductMapper.selectByExample(gme);
			System.out.println("查询公司产品结果==>" + JSON.toJSONString(list));
			PageInfo<GwCompanyproduct> page = new PageInfo<>(list);
			result.setData(list);
			result.setRecordsTotal((int)page.getTotal());
			System.out.println("查询公司产品结束==>" + JSON.toJSONString(result));
		} catch (Exception e) {
			System.out.println("查询公司产品异常==>" + e.getMessage());
		}
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
	public int addCompanyProductStock(long id, int addstock, Long mid) {
		GwCompanyproduct cp = companyproductMapper.selectByPrimaryKey(id);
		int res = 0;
		int update = 1;
		int insertRecord = 1;
		if (cp != null) {
			cp.setStock(cp.getStock() + addstock);
			res = companyproductMapper.updateByPrimaryKey(cp);	
			GwProduct pro = productMapper.selectByPrimaryKey(cp.getPid());
			pro.setStock(pro.getStock() - addstock);
			pro.setDistribute(pro.getDistribute() + addstock);
			update = productMapper.updateByPrimaryKey(pro);
			GwCompanyprochange changed = new GwCompanyprochange();
			changed.setCpid(id);
			changed.setCreated(Calendar.getInstance().getTime());
			changed.setMid(mid);
			changed.setNumber(addstock);
			insertRecord = companyproductchangeMapper.insert(changed);
		}
		return (res == 1 && update == 1 && insertRecord == 1)?1:0;
	}
}
