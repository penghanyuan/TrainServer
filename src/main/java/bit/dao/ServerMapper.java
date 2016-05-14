package bit.dao;

import bit.model.Comment;
import bit.model.Order;
import bit.model.Server;

import java.util.List;

public interface ServerMapper {
    int deleteByPrimaryKey(Integer serverId);

    int insert(Server record);

    int insertSelective(Server record);

    Server selectByPrimaryKey(Integer serverId);

    Server selectByUserName(String username);

    int updateByPrimaryKeySelective(Server record);

    int updateByPrimaryKey(Server record);

    List<Server> selectOrderbyServerId(int serverId);

    List<Server> selectCommentbyServerId(int serverId);

    List<Server> selectByStation(int station);
}