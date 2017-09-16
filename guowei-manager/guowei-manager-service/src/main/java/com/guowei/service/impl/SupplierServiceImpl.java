package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwSupplierMapper;
import com.guowei.pojo.GwSupplier;
import com.guowei.pojo.GwSupplierExample;
import com.guowei.pojo.GwSupplierExample.Criteria;
import com.guowei.service.SupplierService;
/**
 * 供应商管理Service
 * @author 陈安一
 *
 */
@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private GwSupplierMapper supplierMapper;
	@Override
	public GwSupplier getGwSupplierById(long parseLong) {
		GwSupplier res = supplierMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public int addGwSupplier(GwSupplier supplier) {
		int res = supplierMapper.insert(supplier);
		return res;
	}
	@Override
	public int editGwSupplier(GwSupplier supplier) {
		int res = supplierMapper.updateByPrimaryKey(supplier);
		return res;
	}
	@Override
	public int removeGwSupplier(long id) {
		int res = supplierMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwSuppliersByPagedParam(GwSupplier supplier, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwSupplierExample gme = new GwSupplierExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(supplier.getSupplierName())) {
			criteria.andSupplierNameLike("%"+supplier.getSupplierName()+"%");
		}
		int pageNum = (start/pageSize)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwSupplier> list = supplierMapper.selectByExample(gme);
		PageInfo<GwSupplier> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwSuppliersByParam(GwSupplier supplier) {
		// TODO Auto-generated method stub
		GwSupplierExample gme = new GwSupplierExample();
		Criteria criteria = gme.createCriteria();
		List<GwSupplier> list = supplierMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
	@Override
	public DatatablesView<?> getGwSuppliers(String type) {
		GwSupplierExample gme = new GwSupplierExample();
		Criteria criteria = gme.createCriteria();
		List<GwSupplier> list = supplierMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
