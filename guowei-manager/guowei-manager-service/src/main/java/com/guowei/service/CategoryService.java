package com.guowei.service;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwCategory;

public interface CategoryService {

	GwCategory getGwCategoryById(long parseLong);
	
	DatatablesView<?> getGwCategorysByParam(GwCategory category);
	
	DatatablesView<?> getGwCategorysByPagedParam(GwCategory category, Integer start, Integer pageSize);

	int addGwCategory(GwCategory category);

	int editGwCategory(GwCategory category);

	int removeGwCategory(long id);
}
