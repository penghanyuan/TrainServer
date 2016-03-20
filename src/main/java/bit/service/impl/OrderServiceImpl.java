package bit.service.impl;

import bit.dao.OrderMapper;
import bit.model.Order;
import bit.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/10.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Order getOrderbyId(int id) {
        return this.orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> getCommentbyOrderId(int orderid) {
        return this.orderMapper.selectCommentbyOrderId(orderid);
    }

    @Override
    public Order getTrainbyOrderId(int orderid) {
        return this.orderMapper.selectTrainbyOrderId(orderid);
    }

    @Override
    public Order getClientbyOrderId(int orderid) {
        return this.orderMapper.selectClientbyOrderId(orderid);
    }

    @Override
    public Order getServerbyOrderId(int orderid) {
        return this.orderMapper.selectServerbyOrderId(orderid);
    }

    @Override
    public List<Order> getOrderbyStatus(int status) {
        return this.orderMapper.selectOrderbyStatus(status);
    }
}
