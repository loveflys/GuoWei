package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwSupplierstorageMapper;
import com.guowei.mapper.GwSupplierstorageMapper;
import com.guowei.pojo.GwSupplierstorage;
import com.guowei.pojo.GwSupplierstorageExample;
import com.guowei.pojo.GwSupplierstorageExample.Criteria;
import com.guowei.service.SupplierstorageService;
/**
 * 轮播图管理Service
 * @author 陈安一
 *
 */
@Service
@Transactional
public class SupplierstorageServiceImpl implements SupplierstorageService {
	@Autowired
	private GwSupplierstorageMapper supplierstorageMapper;
	@Override
	public GwSupplierstorage getGwSupplierstorageById(long parseLong) {
		GwSupplierstorage res = supplierstorageMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public int addGwSupplierstorage(GwSupplierstorage supplierstorage) {
		int res = supplierstorageMapper.insert(supplierstorage);
		return res;
	}
	@Override
	public int editGwSupplierstorage(GwSupplierstorage supplierstorage) {
		int res = supplierstorageMapper.updateByPrimaryKey(supplierstorage);
		return res;
	}
	@Override
	public int removeGwSupplierstorage(long id) {
		int res = supplierstorageMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwSupplierstoragesByPagedParam(GwSupplierstorage supplierstorage, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwSupplierstorageExample gme = new GwSupplierstorageExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(supplierstorage.getStorageName())) {
			criteria.andStorageNameLike("%"+supplierstorage.getStorageName()+"%");
		}
		if (supplierstorage.getSid() > 0) {
			criteria.andSidEqualTo(supplierstorage.getSid());
		}
		int pageNum = (start/pageSize)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwSupplierstorage> list = supplierstorageMapper.selectByExample(gme);
		PageInfo<GwSupplierstorage> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwSupplierstoragesByParam(GwSupplierstorage supplierstorage) {
		// TODO Auto-generated method stub
		GwSupplierstorageExample gme = new GwSupplierstorageExample();
		Criteria criteria = gme.createCriteria();
		if (supplierstorage.getSid() > 0) {
			criteria.andSidEqualTo(supplierstorage.getSid());
		}		
		List<GwSupplierstorage> list = supplierstorageMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
	@Override
	public DatatablesView<?> getGwSupplierstorages(String type) {
		GwSupplierstorageExample gme = new GwSupplierstorageExample();
		Criteria criteria = gme.createCriteria();
		List<GwSupplierstorage> list = supplierstorageMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
