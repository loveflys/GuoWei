package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwDivisionMapper;
import com.guowei.pojo.GwDivision;
import com.guowei.pojo.GwDivisionExample;
import com.guowei.pojo.GwDivisionExample.Criteria;
import com.guowei.service.DivisionService;
import com.thoughtworks.xstream.converters.basic.ByteConverter;
/**
 * 订单管理Service
 * @author 陈安一
 *
 */
@Service
@Transactional
public class DivisionServiceImpl implements DivisionService {
	@Autowired
	private GwDivisionMapper divisionMapper;
	@Override
	public GwDivision getGwDivisionById(long parseLong) {
		GwDivision res = divisionMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public int addGwDivision(GwDivision division) {
		Long pid = division.getPid();
		if (pid == 0) {
			division.setLevel(Byte.parseByte("1"));
			division.setAllname(division.getName());
		} else {
			GwDivision temp = divisionMapper.selectByPrimaryKey(pid);
			if (temp != null) {
				Integer l = Integer.parseInt(temp.getLevel().toString());
				l += 1;
				division.setLevel(Byte.parseByte(l.toString()));
				division.setAllname(temp.getAllname() + division.getName());
			}
		}
		int res = divisionMapper.insert(division);
		return res;
	}
	@Override
	public int editGwDivision(GwDivision division) {
		Long pid = division.getPid();
		if (pid == 0) {
			division.setLevel(Byte.parseByte("1"));
			division.setAllname(division.getName());
		} else {
			GwDivision temp = divisionMapper.selectByPrimaryKey(pid);
			if (temp != null) {
				Integer l = Integer.parseInt(temp.getLevel().toString());
				l += 1;
				division.setLevel(Byte.parseByte(l.toString()));
				division.setAllname(temp.getAllname() + division.getName());
			}
		}
		int res = divisionMapper.updateByPrimaryKey(division);
		return res;
	}
	@Override
	public int removeGwDivision(long id) {
		int res = divisionMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwDivisionsByPagedParam(GwDivision division, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwDivisionExample gme = new GwDivisionExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(division.getName())) {
			criteria.andNameLike("%"+division.getName()+"%");
			gme.or(gme.createCriteria().andAllnameLike("%"+division.getName()+"%"));
		}		
		int pageNum = (start/pageSize)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwDivision> list = divisionMapper.selectByExample(gme);
		PageInfo<GwDivision> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwDivisionsByParam(GwDivision division) {
		// TODO Auto-generated method stub
		GwDivisionExample gme = new GwDivisionExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(division.getName())) {
			criteria.andNameLike("%"+division.getName()+"%");
		}		
		List<GwDivision> list = divisionMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
	@Override
	public DatatablesView<?> getGwDivisions(String level) {
		GwDivisionExample gme = new GwDivisionExample();
		Criteria criteria = gme.createCriteria();
		criteria.andLevelNotEqualTo(Byte.parseByte(level));
		List<GwDivision> list = divisionMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
