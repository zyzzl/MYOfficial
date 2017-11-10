package official.service;

import java.util.List;

import official.dal.po.AdminUser;

public interface AdminUserService {

	/**
	 * 根据账号查询用户
	 * 
	 * @param account
	 * @return
	 */
	AdminUser queryByAccount(String account);
	
	/**
	 * 修改
	 * 
	 * @param account
	 * @return
	 */
	int editById(AdminUser adminUser);
	
	/**
	 * 分页查询用户列表
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<AdminUser> queryUserList(int pageIndex, int pageSize);
	
	/**
	 * 查询用户数量
	 * 
	 * @return
	 */
	int queryUserListCount();
	
	/**
	 * 添加用户
	 * 
	 * @param adminUser
	 * @return
	 */
	int addUser(AdminUser adminUser);
}
