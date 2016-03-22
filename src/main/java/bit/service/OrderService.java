package bit.service;

import bit.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/10.
 */
public interface OrderService {
    // public Order getTrainbyOrderId(int orderid);
    //public List<Order> getCommentbyOrderId(int orderid);
    public Order getOrderbyId(int id);
    public List<Order> getOrderbyStatus(int status);
    public List<Order> getOrderbyClientId(int clentid);
    public List<Order> getOrderbyServerId(int serverid);
    public List<Order> getOrderbyTrainId(int trainid);

}

