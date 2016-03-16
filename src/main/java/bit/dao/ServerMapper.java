package bit.dao;

import bit.model.Server;

public interface ServerMapper {
    int deleteByPrimaryKey(Integer serverId);

    int insert(Server record);

    int insertSelective(Server record);

    Server selectByPrimaryKey(Integer serverId);

    int updateByPrimaryKeySelective(Server record);

    int updateByPrimaryKey(Server record);
}