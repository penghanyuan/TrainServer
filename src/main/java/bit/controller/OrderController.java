package bit.controller;

import bit.facade.OrderFacade;
import bit.function.MyFunction;
import bit.jsonmodel.JsonOrder;
import bit.model.Order;
import bit.model.Train;
import bit.model.test;
import bit.service.OrderService;
import bit.service.TrainService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by penghanyuan on 16/3/21.
 */
@Controller
@RequestMapping("/orderController")
public class OrderController {
    private static List<String> requestQueue = new ArrayList<String>();
    private static boolean flag =true;
    @Autowired
    OrderFacade orderFacade;
    @Autowired
    MyFunction myFunction;
    @RequestMapping("/{clientid}/showAllClientOrder")
    @ResponseBody
    public Map<String,Object> showAllClientOrder(@PathVariable int clientid, HttpServletRequest request) {
        Map<String,Object> rmap = new HashMap<String, Object>();
        List<Order> orders = this.orderFacade.showClientOrderbyClientid(clientid);
        List<JsonOrder> jsonOrders = myFunction.formatOrder(orders);
        if(jsonOrders!=null)
        {
            rmap.put("status",1);
            rmap.put("data",jsonOrders);
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
        List<JsonOrder> jsonOrders = myFunction.formatOrder(orders);
        if(jsonOrders!=null)
        {
            rmap.put("status",1);
            rmap.put("data",jsonOrders);
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

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    @ResponseBody
    public Integer createOrder(@RequestBody JSONObject jsonObject) {
        return orderFacade.createNewOrder(myFunction.formatOrder(jsonObject));
    }

    @RequestMapping(value = "/verfiyOrder", method = RequestMethod.POST)
    @ResponseBody
    public String verfiyOrder(@RequestBody JSONObject jsonObject) {
        String t= this.orderFacade.verfiyOrder(jsonObject.getInteger("trainid"));
        return t;
    }


    @RequestMapping(value = "{serverid}/setQueue", method = RequestMethod.GET)
    @ResponseBody
    public String setQueue(@PathVariable String serverid){
       // requestQueue.add(jsonObject.getString("serverid"));

        synchronized(this){
            requestQueue.add(serverid);
            System.out.println("now is"+requestQueue.size());
            System.out.println(JSON.toJSONString(requestQueue));
            if(flag)
            {
                requestQueue.get(0);
                flag = false;
                //可以下单
            }
            else {
                //不能下单
            }
        }
        return "";
    }
}
