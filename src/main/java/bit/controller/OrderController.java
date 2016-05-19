package bit.controller;

import bit.facade.OrderFacade;
import bit.function.MyAndroidPush;
import bit.function.MyFunction;
import bit.function.MyPush;
import bit.function.ServerPush;
import bit.jsonmodel.JsonOrder;
import bit.model.Order;
import bit.model.Train;
import bit.model.test;
import bit.service.OrderService;
import bit.service.TrainService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.IntegerCodec;
import org.apache.log4j.Logger;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.android.Android10Instantiator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by penghanyuan on 16/3/21.
 */
@Controller
@RequestMapping("/orderController")
public class OrderController {
    private static List<String> requestQueue = new ArrayList<String>();
    private static boolean flag =true;
    private static String oldoid = null;
    @Autowired
    OrderFacade orderFacade;
    @Autowired
    MyFunction myFunction;
    @Autowired
    MyPush myPush;
    @Autowired
    ServerPush serverPush;
    @Autowired
    MyAndroidPush androidPush;
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
            rmap.put("data", myFunction.formatOrder(order));
        }
        else {
            rmap.put("status",0);
        }
        return rmap;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    @ResponseBody
    public Integer createOrder(@RequestBody JSONObject jsonObject) {

        Integer oid = orderFacade.createNewOrder(myFunction.formatOrder(jsonObject));
        try {

            myPush.push(oid,  myFunction.getAllCid(oid.toString()));
            serverPush.push(oid);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oid;
    }
//    @RequestMapping("/test")
//    @ResponseBody
//    public void test() {
//
//
//        try {
//            myPush.push(Integer.valueOf(1));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    @RequestMapping(value = "/verfiyOrder", method = RequestMethod.POST)
    @ResponseBody
    public String verfiyOrder(@RequestBody JSONObject jsonObject) {
        String t= this.orderFacade.verfiyOrder(jsonObject.getInteger("trainid"));
        return t;
    }


    @RequestMapping(value = "{serverid}/{orderid}/setQueue", method = RequestMethod.GET)
    @ResponseBody
    public String setQueue(@PathVariable String serverid,@PathVariable String orderid){
       // requestQueue.add(jsonObject.getString("serverid"));

        synchronized(this){
            if(oldoid!=null){
                if(!oldoid.equals(orderid)){//非重复订单,新订单
                    flag=true;
                    oldoid = orderid;
                    requestQueue.clear();
                }
            }else {//第一个订单
                flag = true;
                oldoid = orderid;
            }
            requestQueue.add(serverid);

            System.out.println("now is "+oldoid);
            System.out.println(JSON.toJSONString(requestQueue));
            if(flag)
            {
                flag = false;
                //可以下单
                this.setOrderServer(requestQueue.get(0),orderid);
            }
            else {
                //不能下单
                System.out.println("error");
            }
        }
        return "";
    }

    private int setOrderServer(String serverid,String orderid){
        Order order = new Order();
        order.setOrderId(Integer.valueOf(orderid));
        order.setOrderServer(Integer.valueOf(serverid));
        order.setOrderStatus(0);
        order.setOrderRtime(new Date());
        try {
            myPush.push(Integer.valueOf(orderid));
        } catch (IOException e) {
            e.printStackTrace();
        }
        myPush.pushAPN();
        return orderFacade.setServer(order);
    }

    @RequestMapping(value = "{status}/{orderid}/changeStatus", method = RequestMethod.GET)
    @ResponseBody
    public int changeStatus(@PathVariable String status,@PathVariable String orderid) {
        Order order = new Order();
        order.setOrderId(Integer.valueOf(orderid));
        order.setOrderStatus(Integer.valueOf(status));
        order.setOrderFtime(new Date());
        if(status.equals("0"))
            try{
                androidPush.push(3);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        return orderFacade.changeStatus(order);
    }
}
