package bit.facade.impl;

import bit.facade.OrderFacade;
import bit.model.Client;
import bit.model.Order;
import bit.model.Server;
import bit.model.Train;
import bit.service.ClientService;
import bit.service.OrderService;
import bit.service.ServerService;
import bit.service.TrainService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by penghanyuan on 16/3/22.
 */
@Component("orderFacade")
public class OrderFacadeImpl implements OrderFacade {
    @Autowired
    private OrderService orderService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ServerService serverService;
    @Override
    public List<Order> showClientOrderbyClientid(int clientid) {
        //如果没有facade层,就需要在controller里面做这个封装,然而controller本来的职责不包含这个,所以加了个facade层
        List<Order> orders = this.orderService.getOrderbyClientId(clientid);
        Train train = new Train();
        if(orders!=null)
        {
            for(int i = 0; i < orders.size(); i++)
            {
                orders.set(i,this.showOrderDetail(orders.get(i).getOrderId()));
            }
            return orders;
        }
        else
            return null;
    }

    @Override
    public List<Order> showServerOrderbyServerid(int serverid) {
        List<Order> orders = this.orderService.getOrderbyServerId(serverid);
        if(orders!=null)
        {
            for(int i = 0; i < orders.size(); i++)
            {
                orders.set(i,this.showOrderDetail(orders.get(i).getOrderId()));
            }
            return orders;
        }
        else
            return null;
    }

    @Override
    public Order showOrderDetail(int orderid) {
        Order order = this.orderService.getOrderbyId(orderid);
        if(order!=null) {
            Client client = this.clientService.getClientbyId(order.getOrderClient());
            if(order.getOrderServer()!=null) {
                Server server = this.serverService.getServerbyId(order.getOrderServer());
                order.setServer(server);
            }
            if(order.getOrderTrip()!=null) {
                Train train = this.trainService.getTrainbyId(order.getOrderTrip());
                order.setTrain(train);
            }
            order.setClient(client);


            return order;
        }
        else
            return null;
    }

    @Override
    public int createNewOrder(Order order) {
        return this.orderService.createOrder(order);
    }

    @Override
    public String verfiyOrder(int trainid) {
        List<Order> orders = this.orderService.getOrderbyTrainId(trainid);
        switch (orders.size()){
            case 0:
                return "none";
            case 1:
                if(orders.get(0).getOrderType()==0)
                    return "jiezhan";
                else
                    return "songzhan";
            case 2:
                return "all";
            default:
                return "";
        }
    }

    @Override
    public int setServer(Order order) {
        return orderService.uptadeServer(order);
    }

    @Override
    public int changeStatus(Order order) {
        return orderService.uptadeServer(order);
    }
}
