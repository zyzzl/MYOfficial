package official.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import official.dal.mapper.AdminUserMapper;
import official.dal.po.AdminUser;
import official.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	
	@Autowired
	private AdminUserMapper adminUserMapper;

	@Override
	public AdminUser queryByAccount(String account) {
		return adminUserMapper.selectByAccount(account);
	} 

	@Override
	public int editById(AdminUser adminUser) {
		return adminUserMapper.updateByPrimaryKeySelective(adminUser);
	}

	@Override
	public List<AdminUser> queryUserList(int pageIndex, int pageSize) {
		return adminUserMapper.selectUserList((pageIndex - 1) * pageSize, pageSize);
	}

	@Override
	public int queryUserListCount() {
		return adminUserMapper.selectUserListCount();
	}

	@Override
	public int addUser(AdminUser adminUser) {
		return adminUserMapper.insertSelective(adminUser);
	}

}
