package bit.facade;

import bit.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/22.
 */

public interface OrderFacade {
    public List<Order> showClientOrderbyClientid(int clientid);
    public List<Order> showServerOrderbyServerid(int serverid);
    public Order showOrderDetail(int orderid);
    public int createNewOrder(Order order);
    public String verfiyOrder(int trainid);
}
