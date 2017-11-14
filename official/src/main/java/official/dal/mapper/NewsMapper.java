package official.dal.mapper;

import official.dal.po.News;

public interface NewsMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(News record);

    News selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(News record);

}