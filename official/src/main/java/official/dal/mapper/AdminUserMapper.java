package official.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import official.dal.po.AdminUser;

@Mapper
public interface AdminUserMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminUser record);

    AdminUser selectByAccount(String account);
    
    List<AdminUser> selectUserList(@Param("offset")int offset, @Param("pageSize")int pageSize);
    
    int selectUserListCount();
}