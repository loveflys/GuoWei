package com.guowei.service;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwManager;

public interface ManagerService {

	GwManager getGwManagerByNamePassword(GwManager manager);

	GwManager getGwManagerById(long parseLong);

	GwManager getGwManagerByName(String username);
	
	DatatablesView<?> getGwManagersByParam(GwManager manager);
	
	DatatablesView<?> getGwManagersByPagedParam(GwManager manager, Integer start, Integer pageSize);

	int addGwManager(GwManager manager);

	int editGwManager(GwManager manager);

	int removeGwManager(long id);
}
