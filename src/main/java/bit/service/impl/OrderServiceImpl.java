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
    public List<Order> getOrderbyClientId(int clentid) {
        return this.orderMapper.selectOrderbyClientId(clentid);
    }

    @Override
    public List<Order> getOrderbyServerId(int serverid) {
        return this.orderMapper.selectOrderbyServerId(serverid);
    }

    @Override
    public List<Order> getOrderbyStatus(int status) {
        return this.orderMapper.selectOrderbyStatus(status);
    }


    @Override
    public List<Order> getOrderbyTrainId(int trainid) {
        return this.orderMapper.selectOrderbyTrainId(trainid);
    }

    @Override
    public int createOrder(Order order) {
        this.orderMapper.insert(order);
        order.setOrderNum(1000000+order.getOrderId());
        orderMapper.updateByPrimaryKeySelective(order);
        return order.getOrderId();
    }

    @Override
    public Integer uptadeServer(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }
}
