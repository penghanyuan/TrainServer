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
        for(int i = 0; i < orders.size(); i++)
        {
            int trainid = (orders.get(i)).getOrderTrip();
            train = trainService.getTrainbyId(trainid);
            orders.get(i).setTrain(train);
        }
        return orders;
    }

    @Override
    public List<Order> showServerOrderbyServerid(int serverid) {
        List<Order> orders = this.orderService.getOrderbyServerId(serverid);
        Train train = new Train();
        for(int i = 0; i < orders.size(); i++)
        {
            int trainid = (orders.get(i)).getOrderTrip();
            train = trainService.getTrainbyId(trainid);
            orders.get(i).setTrain(train);
        }
        return orders;
    }

    @Override
    public Order showOrderDetail(int orderid) {
        Order order = this.orderService.getOrderbyId(orderid);
        Client client = this.clientService.getClientbyId(order.getOrderClient());
        Server server = this.serverService.getServerbyId(order.getOrderClient());
        order.setClient(client);
        order.setServer(server);
        return order;
    }

    @Override
    public int createNewOrder(Order order) {
        return this.orderService.createOrder(order);
    }
}
