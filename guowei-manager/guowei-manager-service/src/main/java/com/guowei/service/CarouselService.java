package com.guowei.service;
import org.springframework.transaction.annotation.Transactional;

import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwCarousel;

@Transactional
public interface CarouselService {

	GwCarousel getGwCarouselById(long parseLong);
	
	DatatablesView<?> getGwCarouselsByParam(GwCarousel carousel);
	
	DatatablesView<?> getGwCarousels(String level);
	
	DatatablesView<?> getGwCarouselsByPagedParam(GwCarousel carousel, Integer start, Integer pageSize);

	int addGwCarousel(GwCarousel carousel);

	int editGwCarousel(GwCarousel carousel);

	int removeGwCarousel(long id);
}
