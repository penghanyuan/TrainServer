package bit.controller;

import bit.model.Order;
import bit.model.Train;
import bit.service.OrderService;
import bit.service.TrainService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by penghanyuan on 16/3/21.
 */
@Controller
@RequestMapping("/orderController")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    TrainService trainService;
    @RequestMapping("/{clientid}/showOrderbyCid")
    @ResponseBody
    public Map<String,Object> showOrderbyCid(@PathVariable int clientid, HttpServletRequest request) {
        Map<String,Object> rmap = new HashMap<String, Object>();
        List<Order> orders = this.orderService.getOrderbyClientId(clientid);
        Train train = new Train();
        for(int i = 0; i < orders.size(); i++)
        {
            int trainid = (orders.get(i)).getOrderTrip();
            train = trainService.getTrainbyId(trainid);
            orders.get(i).setTrain(train);
            //System.out.println(list.get(i));
        }
        if(orders!=null)
        {
            rmap.put("status",1);
            rmap.put("data",orders);
        }
        else {
            rmap.put("status",0);
        }
        return rmap;
    }
}
