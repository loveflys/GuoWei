package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwCompanyMapper;
import com.guowei.mapper.GwCompanyproductMapper;
import com.guowei.mapper.GwProductMapper;
import com.guowei.mapper.GwTemplateproductMapper;
import com.guowei.pojo.GwCompany;
import com.guowei.pojo.GwCompanyExample;
import com.guowei.pojo.GwCompanyproduct;
import com.guowei.pojo.GwCompanyproductExample;
import com.guowei.pojo.GwProduct;
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
@Transactional
public class TemplateproductServiceImpl implements TemplateproductService {
	@Autowired
	private GwTemplateproductMapper templateproductMapper;
	@Autowired
	private GwCompanyMapper companyMapper;
	@Autowired
	private GwProductMapper productMapper;
	@Autowired
	private GwCompanyproductMapper companyproductMapper;
	@Override
	public GwTemplateproduct getGwTemplateproductById(long parseLong) {
		GwTemplateproduct res = templateproductMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public int addGwTemplateproduct(GwTemplateproduct templateproduct) {
		Long tid = templateproduct.getTid();
		Long pid = templateproduct.getPid();
		GwCompanyExample gme = new GwCompanyExample();
		com.guowei.pojo.GwCompanyExample.Criteria criteria = gme.createCriteria();
		criteria.andTemplateIdEqualTo(tid);
		gme.or(gme.createCriteria().andSectemplateIdEqualTo(tid));
		List<GwCompany> list = companyMapper.selectByExample(gme);
		int companyRes = 1;
		if(list != null && list.size() > 0) {
			for (GwCompany gwCompany : list) {
				//每个公司分别插入该公司商品
				GwCompanyproduct temp = new GwCompanyproduct();
				temp.setCompanyId(gwCompany.getId());
				temp.setPid(pid);
				temp.setProimage(templateproduct.getProimage());
				temp.setProname(templateproduct.getProname());
				temp.setProprice(templateproduct.getProprice());
				temp.setSellcount(0);
				temp.setSellprice(templateproduct.getSellprice());
				temp.setStatus(Byte.parseByte("1"));
				temp.setStock(templateproduct.getStock());
				temp.setStorageracks(templateproduct.getStorageracks());
				temp.setWarnstock(templateproduct.getWarnstock());
				int insertCP = companyproductMapper.insert(temp);
				//为商品扣减库存，增加铺货数
				GwProduct pro = productMapper.selectByPrimaryKey(pid);
				int updatePro = 0;
				if (pro != null) {
					if (pro.getStock() >= temp.getStock()) {
						//扣减库存
						pro.setStock(pro.getStock() - temp.getStock());
						//增加铺货
						pro.setDistribute(pro.getDistribute() + temp.getStock());
						updatePro = productMapper.updateByPrimaryKey(pro);
					}
				}
				if (insertCP != 1 || updatePro != 1) {
					companyRes = 0;
				}
			}
		}
		int res = templateproductMapper.insert(templateproduct);
		return (res == 1 && companyRes == 1)?1:0;
	}
	@Override
	public int editGwTemplateproduct(GwTemplateproduct templateproduct) {
		int res = templateproductMapper.updateByPrimaryKey(templateproduct);
		return res;
	}
	@Override
	public int removeGwTemplateproduct(long id) {
		GwTemplateproduct product = templateproductMapper.selectByPrimaryKey(id);
		Long tid = product.getTid();
		Long pid = product.getPid();
		GwCompanyExample gme = new GwCompanyExample();
		gme.createCriteria().andTemplateIdEqualTo(tid);
		gme.or(gme.createCriteria().andSectemplateIdEqualTo(tid));
		List<GwCompany> list = companyMapper.selectByExample(gme);
		int companyRes = 1;
		if(list != null && list.size() > 0) {
			for (GwCompany gwCompany : list) {
				//每个公司分别删除该公司商品
				GwCompanyproductExample example = new GwCompanyproductExample();
				com.guowei.pojo.GwCompanyproductExample.Criteria c = example.createCriteria();
				c.andCompanyIdEqualTo(gwCompany.getId());
				c.andPidEqualTo(pid);
				GwCompanyproduct temp = null;
				List<GwCompanyproduct> temps = companyproductMapper.selectByExample(example);
				if (temps != null && temps.size() > 0) {
					temp = temps.get(0);
				}
				int deleteCP = companyproductMapper.deleteByExample(example);
				//为商品返还库存，返还铺货数
				GwProduct pro = productMapper.selectByPrimaryKey(pid);
				int updatePro = 1;
				if (pro != null && temp != null) {
					//返还库存
					pro.setStock(pro.getStock() + temp.getStock());
					//返还铺货
					pro.setDistribute(pro.getDistribute() - temp.getStock());
					updatePro = productMapper.updateByPrimaryKey(pro);
				}
				if (deleteCP != 1 || updatePro != 1) {
					companyRes = 0;
				}
			}
		}
		
		
		int res = templateproductMapper.deleteByPrimaryKey(id);
		return (res == 1 && companyRes == 1)?1:0;
	}

	@Override
	public DatatablesView<?> getGwTemplateproductsByPagedParam(GwTemplateproduct templateproduct, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwTemplateproductExample gme = new GwTemplateproductExample();
		Criteria criteria = gme.createCriteria();
		if (templateproduct.getTid() != null && templateproduct.getTid() > 0) {
			criteria.andTidEqualTo(templateproduct.getTid());
		}		
		if (templateproduct.getPid() != null && templateproduct.getPid() > 0) {
			criteria.andPidEqualTo(templateproduct.getPid());
		}
		int pageNum = (start/pageSize)+1;
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
		if (templateproduct.getTid() != null && templateproduct.getTid() > 0) {
			criteria.andTidEqualTo(templateproduct.getTid());
		}		
		if (templateproduct.getPid() != null && templateproduct.getPid() > 0) {
			criteria.andPidEqualTo(templateproduct.getPid());
		}
		List<GwTemplateproduct> list = templateproductMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
