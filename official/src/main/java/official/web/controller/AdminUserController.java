package official.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import official.common.util.Page;
import official.common.util.SecurityUtil;
import official.dal.po.AdminUser;
import official.service.AdminUserService;

@Controller
public class AdminUserController {
	
	@Autowired
	private AdminUserService adminUserService;

	/**
	 * 登录
	 * 
	 * @param session
	 * @param account
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpSession session, String account, String password){
		if (!StringUtils.isNoneBlank(account, password)) {
			return "tologin";
		}
		AdminUser adminUser = adminUserService.queryByAccount(account);
		if (adminUser == null) {
			return "tologin";
		}
		if (!SecurityUtil.getMD5String(password).equals(adminUser.getPassword())) {
			return "tologin";
		}
		// 修改最近登录时间
		adminUser.setLastLoginTime(new Date());
		if (adminUserService.editById(adminUser) != 1) {
			return "";
		}
		session.setAttribute("user", adminUser);
		return null;
	}
	
	/**
	 * 查询用户列表
	 * 
	 * @param map
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "userlist", method = RequestMethod.POST)
	public String queryUserList(ModelMap map, Integer pageIndex, Integer pageSize){
		if (!StringUtils.isNoneBlank(pageIndex.toString(), pageSize.toString())) {
			return "";
		}
		int totalCount = adminUserService.queryUserListCount();
		if (totalCount == 0) {
			return "";
		}
		Page page = new Page(pageIndex, pageSize, totalCount);
		List<AdminUser> list = adminUserService.queryUserList(pageIndex, pageSize);
		page.setT(list);
		map.put("userList", list);
		return null;
	}
	
	/**
	 * 添加用户
	 * 
	 * @param adminUser
	 * @return
	 */
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String addUser(AdminUser adminUser){
		if (!StringUtils.isNoneBlank(adminUser.getAccount(), adminUser.getPassword())) {
			return "";
		}
		AdminUser au = adminUserService.queryByAccount(adminUser.getAccount());
		// 账号重复
		if (au != null) {
			return "";
		}
		// 密码加密
		adminUser.setPassword(SecurityUtil.getMD5String(adminUser.getPassword()));
		if (adminUserService.addUser(adminUser) != 1) {
			return "";
		}
		return null;
	}
	
	/**
	 * 编辑用户
	 * 
	 * @param adminUser
	 * @return
	 */
	@RequestMapping(value = "edituser", method = RequestMethod.POST)
	public String editUser(AdminUser adminUser){
		if (!StringUtils.isNoneBlank(adminUser.getAccount(), adminUser.getPassword(), adminUser.getId().toString())) {
			return "";
		}
		AdminUser au = adminUserService.queryByAccount(adminUser.getAccount());
		// 账号重复
		if (au != null) {
			return "";
		}
		// 密码加密
		adminUser.setPassword(SecurityUtil.getMD5String(adminUser.getPassword()));
		if (adminUserService.editById(adminUser) != 1) {
			return "";
		}
		return null;
	}
	
	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteuser", method = RequestMethod.POST)
	public String deleteUser(Long id){
		if (!StringUtils.isNoneBlank(id.toString())) {
			return "";
		}
		AdminUser au = new AdminUser();
		au.setId(id);
		au.setIsDelete(1);
		if (adminUserService.editById(au) != 1) {
			return "";
		}
		return null;
	}
}
