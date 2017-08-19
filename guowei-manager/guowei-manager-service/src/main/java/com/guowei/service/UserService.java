package com.guowei.service;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.pojo.GwApply;
import com.guowei.pojo.GwComplain;
import com.guowei.pojo.GwUser;

public interface UserService {

	GwUser getGwUserByNamePassword(GwUser user);

	GwUser getGwUserById(long parseLong);

	GwUser getGwUserByName(String username);
	
	GwUser getGwUserByOpenId(String openid);
	
	DatatablesView<?> getGwUsersByParam(GwUser user);
	
	DatatablesView<?> getGwUsersByPagedParam(GwUser user, Integer start, Integer pageSize);
	
	GwApply getGwApplyById(long parseLong);
	
	DatatablesView<?> getGwApplysByParam(GwApply apply);
	
	DatatablesView<?> getGwApplysByPagedParam(GwApply apply, Integer start, Integer pageSize);
	
	GwComplain getGwComplainById(long parseLong);
	
	DatatablesView<?> getGwComplainsByParam(GwComplain complain);
	
	DatatablesView<?> getGwComplainsByPagedParam(GwComplain complain, Integer start, Integer pageSize);

	int addGwUser(GwUser user);
	
	int addGwComplain(GwComplain complain);
	
	int addGwApply(GwApply apply);

	int editGwUser(GwUser user);

	int removeGwUser(long id);
}
