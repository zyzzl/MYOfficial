package official.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import official.dal.po.Message;

@Mapper
public interface MessageMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Message record);

    int selectMessageListCount();
    
    List<Message> selectMessageList(@Param("offset")int offset, @Param("pageSize")int pageSize);
}