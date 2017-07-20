package com.guowei.service;
import org.springframework.transaction.annotation.Transactional;

import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwDivision;

@Transactional
public interface DivisionService {

	GwDivision getGwDivisionById(long parseLong);
	
	DatatablesView<?> getGwDivisionsByParam(GwDivision division);
	
	DatatablesView<?> getGwDivisions(String level);
	
	DatatablesView<?> getGwDivisionsByPagedParam(GwDivision division, Integer start, Integer pageSize);

	int addGwDivision(GwDivision division);

	int editGwDivision(GwDivision division);

	int removeGwDivision(long id);
}
