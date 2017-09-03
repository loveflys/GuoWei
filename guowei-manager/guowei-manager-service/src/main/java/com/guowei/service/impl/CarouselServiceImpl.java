package com.guowei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.mapper.GwCarouselMapper;
import com.guowei.pojo.GwCarousel;
import com.guowei.pojo.GwCarouselExample;
import com.guowei.pojo.GwCarouselExample.Criteria;
import com.guowei.service.CarouselService;
/**
 * 轮播图管理Service
 * @author 陈安一
 *
 */
@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {
	@Autowired
	private GwCarouselMapper carouselMapper;
	@Override
	public GwCarousel getGwCarouselById(long parseLong) {
		GwCarousel res = carouselMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	public int addGwCarousel(GwCarousel carousel) {
		int res = carouselMapper.insert(carousel);
		return res;
	}
	@Override
	public int editGwCarousel(GwCarousel carousel) {
		int res = carouselMapper.updateByPrimaryKey(carousel);
		return res;
	}
	@Override
	public int removeGwCarousel(long id) {
		int res = carouselMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public DatatablesView<?> getGwCarouselsByPagedParam(GwCarousel carousel, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwCarouselExample gme = new GwCarouselExample();
		Criteria criteria = gme.createCriteria();
		if (!"".equals(carousel.getTitle())) {
			criteria.andTitleLike("%"+carousel.getTitle()+"%");
			gme.or(gme.createCriteria().andTitleLike("%"+carousel.getTitle()+"%"));
		}
		int pageNum = (start/pageSize)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwCarousel> list = carouselMapper.selectByExample(gme);
		PageInfo<GwCarousel> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	public DatatablesView<?> getGwCarouselsByParam(GwCarousel carousel) {
		// TODO Auto-generated method stub
		GwCarouselExample gme = new GwCarouselExample();
		Criteria criteria = gme.createCriteria();
//		if (!"".equals(carousel.getName())) {
//			criteria.andNameLike("%"+carousel.getName()+"%");
//		}		
		List<GwCarousel> list = carouselMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
	@Override
	public DatatablesView<?> getGwCarousels(String type) {
		GwCarouselExample gme = new GwCarouselExample();
		Criteria criteria = gme.createCriteria();
		criteria.andTypeNotEqualTo(Byte.parseByte(type));
		List<GwCarousel> list = carouselMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
}
