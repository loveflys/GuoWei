package com.guowei.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.common.utils.WechatWarn;
import com.guowei.mapper.GwApplyMapper;
import com.guowei.mapper.GwComplainMapper;
import com.guowei.mapper.GwUserMapper;
import com.guowei.pojo.GwApply;
import com.guowei.pojo.GwApplyExample;
import com.guowei.pojo.GwComplain;
import com.guowei.pojo.GwComplainExample;
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
	
	@Autowired
	private GwApplyMapper applyMapper;
	
	@Autowired
	private GwComplainMapper complainMapper;
	
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
		c.andNameLike("%"+username+"%");
		List<GwUser> res = userMapper.selectByExample(example);
		if (res != null && res.size() > 0) {
			return res.get(0);
		}
		return null;
	}
	
	@Override
	public GwUser getGwUserByOpenId(String openid) {
		GwUserExample example = new GwUserExample();
		Criteria c = example.createCriteria();
		c.andWechatOpenidEqualTo(openid);
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
		gme.setOrderByClause("created DESC");
		Criteria criteria = gme.createCriteria();
		if (!"".equals(user.getName())) {
			criteria.andNameLike("%"+user.getName()+"%");
			gme.or(gme.createCriteria().andPhoneLike("%"+user.getName()+"%"));
		}		
		int pageNum = (start/pageSize)+1;
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
		gme.setOrderByClause("created DESC");
		Criteria criteria = gme.createCriteria();
		if (!"".equals(user.getName())) {
			criteria.andNameLike("%"+user.getName()+"%");
			gme.or(gme.createCriteria().andPhoneLike("%"+user.getName()+"%"));
		}		
		List<GwUser> list = userMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
	@Override
	public GwApply getGwApplyById(long parseLong) {
		GwApply res = applyMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public DatatablesView<?> getGwApplysByParam(GwApply apply) {
		GwApplyExample gme = new GwApplyExample();
		gme.setOrderByClause("created DESC");
		com.guowei.pojo.GwApplyExample.Criteria criteria = gme.createCriteria();
		if (!"".equals(apply.getContactPhone())) {
			criteria.andContactPhoneLike("%"+apply.getContactPhone()+"%");
			gme.or(gme.createCriteria().andCompanyNameLike("%"+apply.getContactPhone()+"%"));
			gme.or(gme.createCriteria().andContactNameLike("%"+apply.getContactPhone()+"%"));
		}		
		List<GwApply> list = applyMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
	@Override
	public DatatablesView<?> getGwApplysByPagedParam(GwApply apply, Integer start, Integer pageSize) {
		GwApplyExample gme = new GwApplyExample();
		gme.setOrderByClause("created DESC");
		com.guowei.pojo.GwApplyExample.Criteria criteria = gme.createCriteria();
		if (!"".equals(apply.getContactPhone())) {
			criteria.andContactPhoneLike("%"+apply.getContactPhone()+"%");
			gme.or(gme.createCriteria().andCompanyNameLike("%"+apply.getContactPhone()+"%"));
			gme.or(gme.createCriteria().andContactNameLike("%"+apply.getContactPhone()+"%"));
		}		
		int pageNum = (start/pageSize)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwApply> list = applyMapper.selectByExample(gme);
		PageInfo<GwApply> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	@Override
	public GwComplain getGwComplainById(long parseLong) {
		GwComplain res = complainMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public DatatablesView<?> getGwComplainsByParam(GwComplain complain) {
		GwComplainExample gme = new GwComplainExample();
		gme.setOrderByClause("created DESC");
		com.guowei.pojo.GwComplainExample.Criteria criteria = gme.createCriteria();
		if (!"".equals(complain.getContactPhone())) {
			criteria.andContactPhoneLike("%"+complain.getContactPhone()+"%");
		}		
		List<GwComplain> list = complainMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
	@Override
	public DatatablesView<?> getGwComplainsByPagedParam(GwComplain complain, Integer start, Integer pageSize) {
		GwComplainExample gme = new GwComplainExample();
		gme.setOrderByClause("created DESC");
		com.guowei.pojo.GwComplainExample.Criteria criteria = gme.createCriteria();
		if (!"".equals(complain.getContactPhone())) {
			criteria.andContactPhoneEqualTo(complain.getContactPhone());
		}		
		int pageNum = (start/pageSize)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwComplain> list = complainMapper.selectByExample(gme);
		PageInfo<GwComplain> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	@Override
	public int addGwComplain(GwComplain complain) {
		int res = complainMapper.insert(complain);
		if (res == 1) {
			GwUser user = userMapper.selectByPrimaryKey(complain.getUid());
			Date time = complain.getCreated();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");  
			String date=sdf.format(time); 			
			WechatWarn.ComplainWarn(complain.getContent(), user.getName() + "(手机号码:" + complain.getContactPhone() + ")", date);
		}
		return res;
	}
	@Override
	public int addGwApply(GwApply apply) {
		int res = applyMapper.insert(apply);
		if (res == 1) {
			Date time = apply.getCreated();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");  
			String date=sdf.format(time); 
			WechatWarn.ApplyWarn(apply.getCompanyName(), apply.getContactName() + "(手机号码:" + apply.getContactPhone() + ")", date);
		}
		return res;
	}
	@Override
	public BigDecimal getUserCount(String startTime, String endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (startTime != null && !"".equals(startTime)) {
			params.put("startTime", startTime);
		}
		if (endTime != null && !"".equals(endTime)) {
			params.put("endTime", endTime);
		}
		BigDecimal res = userMapper.searchUserCount(params);
		return res;
	}
}
