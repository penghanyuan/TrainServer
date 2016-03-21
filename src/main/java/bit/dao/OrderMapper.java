package bit.dao;

import bit.model.Comment;
import bit.model.Order;
import bit.model.Train;

import java.util.List;
import java.util.TreeSet;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectCommentbyOrderId(int orderid);

    Order selectTrainbyOrderId(int orderid);
//
//    Order selectClientbyOrderId(int orderid);
//
//    Order selectServerbyOrderId(int orderid);

    List<Order> selectOrderbyStatus(int status);

    List<Order> selectOrderbyClientId(int clientid);

    List<Order> selectOrderbyServertId(int serverid);
}