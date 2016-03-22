package bit.facade.impl;

import bit.facade.OrderFacade;
import bit.model.Order;
import bit.model.Train;
import bit.service.OrderService;
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
    @Override
    public List<Order> showClientOrderbyClientid(int clientid) {
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
    public List<Order> showClientOrderbyServerid(int clientid) {
        return null;
    }
}
