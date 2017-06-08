package com.guowei.service;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwDivision;

public interface DivisionService {

	GwDivision getGwDivisionById(long parseLong);
	
	DatatablesView<?> getGwDivisionsByParam(GwDivision division);
	
	DatatablesView<?> getGwDivisionsByPagedParam(GwDivision division, Integer start, Integer pageSize);

	int addGwDivision(GwDivision division);

	int editGwDivision(GwDivision division);

	int removeGwDivision(long id);
}
