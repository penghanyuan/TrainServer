package bit.service;

import bit.model.Order;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/10.
 */
public interface OrderService {
    public Order getOrderbyId(int id);
    public List<Order> getCommentbyOrderId(int orderid);
    public Order getTrainbyOrderId(int orderid);
    public Order getClientbyOrderId(int orderid);
    public Order getServerbyOrderId(int orderid);
    public List<Order> getOrderbyStatus(int status);
}
