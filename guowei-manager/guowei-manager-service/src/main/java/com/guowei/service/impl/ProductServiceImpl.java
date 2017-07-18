package com.guowei.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwCategoryMapper;
import com.guowei.mapper.GwCompanyproductMapper;
import com.guowei.mapper.GwProductMapper;
import com.guowei.mapper.GwPurchaseMapper;
import com.guowei.mapper.GwTemplateproductMapper;
import com.guowei.pojo.GwCategory;
import com.guowei.pojo.GwCompanyproductExample;
import com.guowei.pojo.GwProduct;
import com.guowei.pojo.GwProductExample;
import com.guowei.pojo.GwTemplateproductExample;
import com.guowei.pojo.GwProduct;
import com.guowei.pojo.GwProductExample.Criteria;
import com.guowei.pojo.GwPurchase;
import com.guowei.pojo.GwPurchaseExample;
import com.guowei.service.ProductService;
/**
 * 商品管理Service
 * @author 陈安一
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private GwProductMapper productMapper;
	@Autowired
	private GwTemplateproductMapper templateproductMapper;
	@Autowired
	private GwCompanyproductMapper companyproductMapper;
	@Autowired
	private GwCategoryMapper cateMapper;
	@Autowired
	private GwPurchaseMapper purchaseMapper;
	@Override
	public GwProduct getGwProductById(long parseLong) {
		GwProduct res = productMapper.selectByPrimaryKey(parseLong);
		GwCategory cate = cateMapper.selectByPrimaryKey(res.getCid());
		res.setCname(cate.getName());
		return res;
	}
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public GwProduct getGwProductByTitle(String title) {
		GwProductExample example = new GwProductExample();
		Criteria c = example.createCriteria();
		c.andTitleLike(title);
		List<GwProduct> res = productMapper.selectByExample(example);
		if (res != null && res.size() > 0) {
			return res.get(0);
		}
		return null;
	}
	@Override
	public int addGwProduct(GwProduct product, Long mid) {
		GwCategory cate = cateMapper.selectByPrimaryKey(product.getCid());
		product.setCname(cate.getName());
		GwPurchase purchase = new GwPurchase();
		
		
		int res = productMapper.insert(product);
		purchase.setMid(mid);
		purchase.setNumber(product.getStock());
		purchase.setPid(product.getId());
		purchase.setPrice(product.getBuyingprice());
		purchase.setCreated(product.getCreated());
		int addPurchase = purchaseMapper.insert(purchase);
		return (res == 1 && addPurchase == 1)?1:0;
	}
	@Override
	public int editGwProduct(GwProduct product) {
		GwCategory cate = cateMapper.selectByPrimaryKey(product.getCid());
		product.setCname(cate.getName());
		int res = productMapper.updateByPrimaryKey(product);
		return res;
	}
	@Override
	public int removeGwProduct(long id) {
		GwTemplateproductExample example1 = new GwTemplateproductExample();
		example1.createCriteria().andPidEqualTo(id);
		templateproductMapper.deleteByExample(example1);
		
		GwPurchaseExample exa = new GwPurchaseExample();
		exa.createCriteria().andPidEqualTo(id);
		purchaseMapper.deleteByExample(exa);
		
		GwCompanyproductExample example2 = new GwCompanyproductExample();
		example2.createCriteria().andPidEqualTo(id);
		companyproductMapper.deleteByExample(example2);
		
		int res = productMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwProductsByPagedParam(GwProduct product, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwProductExample gme = new GwProductExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(product.getTitle())) {
			criteria.andTitleLike(product.getTitle());
		}		
		int pageNum = (start/pageSize)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwProduct> list = productMapper.selectByExample(gme);
		for (GwProduct gwProduct : list) {
			GwCategory cate = cateMapper.selectByPrimaryKey(gwProduct.getCid());
			gwProduct.setCname(cate.getName());
		}
		PageInfo<GwProduct> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwProductsByParam(GwProduct product) {
		// TODO Auto-generated method stub
		GwProductExample gme = new GwProductExample();
		List<GwProduct> list = productMapper.selectByExample(gme);
		for (GwProduct gwProduct : list) {
			GwCategory cate = cateMapper.selectByPrimaryKey(gwProduct.getCid());
			gwProduct.setCname(cate.getName());
		}
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
	@Override
	public int addPurchase(String id, String purchaseNum, String purchasePrice, String mid) {
		int updatePro = 1;
		int addPurchase = 1;
		GwProduct pro = productMapper.selectByPrimaryKey(Long.parseLong(id));
		if (pro != null) {
			pro.setStock(pro.getStock() + Integer.parseInt(purchaseNum));
			pro.setBuyingprice(new BigDecimal(purchasePrice));
			updatePro = productMapper.updateByPrimaryKey(pro);
			GwPurchase purchase = new GwPurchase();
			purchase.setMid(Long.parseLong(mid));
			purchase.setNumber(Integer.parseInt(purchaseNum));
			purchase.setPrice(new BigDecimal(purchasePrice));
			purchase.setPid(pro.getId());
			purchase.setCreated(Calendar.getInstance().getTime());
			addPurchase = purchaseMapper.insert(purchase);
		} else {
			updatePro = 0;
		}
		
		return (updatePro == 1 && addPurchase == 1)?1:0;
	}
}
