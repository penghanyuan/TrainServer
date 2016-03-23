package bit.controller;

import bit.facade.OrderFacade;
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
    OrderFacade orderFacade;
    @RequestMapping("/{clientid}/showAllClientOrder")
    @ResponseBody
    public Map<String,Object> showAllClientOrder(@PathVariable int clientid, HttpServletRequest request) {
        Map<String,Object> rmap = new HashMap<String, Object>();
        List<Order> orders = this.orderFacade.showClientOrderbyClientid(clientid);
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
    @RequestMapping("/{serverid}/showAllServerOrder")
    @ResponseBody
    public Map<String,Object> showAllServerOrder(@PathVariable int serverid, HttpServletRequest request) {
        Map<String,Object> rmap = new HashMap<String, Object>();
        List<Order> orders = this.orderFacade.showServerOrderbyServerid(serverid);
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
    @RequestMapping("/{orderid}/showOrderDetail")
    @ResponseBody
    public Map<String,Object> showOrderDetail(@PathVariable int orderid, HttpServletRequest request) {
        Map<String,Object> rmap = new HashMap<String, Object>();
        Order order = this.orderFacade.showOrderDetail(orderid);
        if(order!=null)
        {
            rmap.put("status",1);
            rmap.put("data",order);
        }
        else {
            rmap.put("status",0);
        }
        return rmap;
    }
}
