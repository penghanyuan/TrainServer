package bit.dao;

import bit.model.Client;

public interface ClientMapper {
    int deleteByPrimaryKey(Integer clientId);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer clientId);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
}