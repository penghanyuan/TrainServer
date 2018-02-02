package bit.dao;

import bit.model.Client;
import bit.model.Order;
import bit.model.Train;

import java.util.List;

public interface ClientMapper {
    int deleteByPrimaryKey(Integer clientId);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer clientId);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);

    List<Client> selectOrderbyClientId(int clientId);

    List<Client> selectTrainbyClientId(int clientId);
}