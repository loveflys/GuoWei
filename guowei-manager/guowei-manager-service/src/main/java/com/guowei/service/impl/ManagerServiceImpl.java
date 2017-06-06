package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwManagerMapper;
import com.guowei.pojo.GwManager;
import com.guowei.pojo.GwManagerExample;
import com.guowei.pojo.GwProduct;
import com.guowei.pojo.GwManagerExample.Criteria;
import com.guowei.service.ManagerService;
/**
 * 商品管理Service
 * @author 陈安一
 *
 */
@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private GwManagerMapper managerMapper;
	
	@Override
	public GwManager getGwManagerByNamePassword(GwManager manager) {
		// TODO Auto-generated method stub
		GwManagerExample gme = new GwManagerExample();
//		Criteria criteria = gme.createCriteria();
		List<GwManager> list = managerMapper.selectByExample(gme);
		if (list != null && list.size() > 0) {
			GwManager mng = list.get(0);
			return mng;
		}
		return null;
	}
	@Override
	public GwManager getGwManagerById(long parseLong) {
		GwManager res = managerMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public GwManager getGwManagerByName(String username) {
		GwManagerExample example = new GwManagerExample();
		Criteria c = example.createCriteria();
		c.andNameLike(username);
		List<GwManager> res = managerMapper.selectByExample(example);
		if (res != null && res.size() > 0) {
			return res.get(0);
		}
		return null;
	}
	@Override
	public int addGwManager(GwManager manager) {
		int res = managerMapper.insert(manager);
		return res;
	}
	@Override
	public int editGwManager(GwManager manager) {
		int res = managerMapper.updateByPrimaryKey(manager);
		return res;
	}
	@Override
	public int removeGwManager(long id) {
		int res = managerMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwManagersByPagedParam(GwManager manager, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwManagerExample gme = new GwManagerExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(manager.getName())) {
			criteria.andNameLike(manager.getName());
			gme.or(gme.createCriteria().andPhoneLike(manager.getName()));
		}		
		int pageNum = (start/10)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwManager> list = managerMapper.selectByExample(gme);
		PageInfo<GwManager> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwManagersByParam(GwManager manager) {
		// TODO Auto-generated method stub
		GwManagerExample gme = new GwManagerExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(manager.getName())) {
			criteria.andNameLike(manager.getName());
			gme.or(gme.createCriteria().andPhoneLike(manager.getName()));
		}		
		List<GwManager> list = managerMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
