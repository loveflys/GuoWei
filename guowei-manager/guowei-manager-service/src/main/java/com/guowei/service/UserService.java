package com.guowei.service;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwUser;

public interface UserService {

	GwUser getGwUserByNamePassword(GwUser user);

	GwUser getGwUserById(long parseLong);

	GwUser getGwUserByName(String username);
	
	GwUser getGwUserByOpenId(String openid);
	
	DatatablesView<?> getGwUsersByParam(GwUser user);
	
	DatatablesView<?> getGwUsersByPagedParam(GwUser user, Integer start, Integer pageSize);

	int addGwUser(GwUser user);

	int editGwUser(GwUser user);

	int removeGwUser(long id);
}
