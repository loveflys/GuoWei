package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwUserMapper;
import com.guowei.pojo.GwUser;
import com.guowei.pojo.GwUserExample;
import com.guowei.pojo.GwUserExample.Criteria;
import com.guowei.service.UserService;
/**
 * 用户管理Service
 * @author 陈安一
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private GwUserMapper userMapper;
	
	@Override
	public GwUser getGwUserByNamePassword(GwUser user) {
		// TODO Auto-generated method stub
		GwUserExample gme = new GwUserExample();
//		Criteria criteria = gme.createCriteria();
		List<GwUser> list = userMapper.selectByExample(gme);
		if (list != null && list.size() > 0) {
			GwUser mng = list.get(0);
			return mng;
		}
		return null;
	}
	@Override
	public GwUser getGwUserById(long parseLong) {
		GwUser res = userMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public GwUser getGwUserByName(String username) {
		GwUserExample example = new GwUserExample();
		Criteria c = example.createCriteria();
		c.andNameLike(username);
		List<GwUser> res = userMapper.selectByExample(example);
		if (res != null && res.size() > 0) {
			return res.get(0);
		}
		return null;
	}
	@Override
	public int addGwUser(GwUser user) {
		int res = userMapper.insert(user);
		return res;
	}
	@Override
	public int editGwUser(GwUser user) {
		int res = userMapper.updateByPrimaryKey(user);
		return res;
	}
	@Override
	public int removeGwUser(long id) {
		int res = userMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwUsersByPagedParam(GwUser user, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwUserExample gme = new GwUserExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(user.getName())) {
			criteria.andNameLike(user.getName());
			gme.or(gme.createCriteria().andPhoneLike(user.getName()));
		}		
		int pageNum = (start/10)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwUser> list = userMapper.selectByExample(gme);
		PageInfo<GwUser> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwUsersByParam(GwUser user) {
		// TODO Auto-generated method stub
		GwUserExample gme = new GwUserExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(user.getName())) {
			criteria.andNameLike(user.getName());
			gme.or(gme.createCriteria().andPhoneLike(user.getName()));
		}		
		List<GwUser> list = userMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
