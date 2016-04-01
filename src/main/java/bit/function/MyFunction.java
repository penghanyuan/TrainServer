package bit.function;

import bit.jsonmodel.JsonOrder;
import bit.model.Order;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by penghanyuan on 16/3/25.
 */
@Component("myFunction")
public class MyFunction {
    private String fullFileName = "train.json";
    private MyData myData = new MyData();
    public Integer changeTraintoNum(String train){
        String a[] = myData.getData();
        for(int i = 0;i<a.length;i++)
        {
            if(a[i].equals(train))
                return i;
        }
        return 0;
    }
    public String changeNumtoTrain(int i){
        String[] data = myData.getData();
        return data[i];
    }
    public String changeNumtoStatus(int i){
        switch (i)
        {
            case 0 :
                return "未出行";
            case 1:
                return "已出行";
            case 2:
                return "待评价";
            case 3:
                return "未接单";
            default:
                return "";
        }
    }
    public String changeNumtoType(int i){
        switch (i)
        {
            case 0 :
                return "接站";
            case 1:
                return "送站";
            default:
                return "";
        }
    }
    public List<JsonOrder> formatOrder(List<Order> orders){

        List<JsonOrder> jsonOrders = new ArrayList<JsonOrder>();

        Order o = new Order();
        String formatType = "yyyy年MM月dd日 HH时mm分ss秒";
        SimpleDateFormat sdf =  new SimpleDateFormat(formatType);
        for(int i = 0;i<orders.size();i++)
        {
            JsonOrder jo = new JsonOrder();
            o = orders.get(i);
            if(o.getOrderFtime()!=null)
                jo.setOrderFtime(sdf.format(o.getOrderFtime()));
            if(o.getServer()!=null)
                jo.setOrderServer(o.getServer().getServerName());
            if(o.getServer()!=null)
                jo.setServerTel(o.getServer().getServerTel());

            jo.setTrainClient(o.getClient().getClientName());
            jo.setOrderCtime(sdf.format(o.getOrderCtime()));

            jo.setTrainDate(sdf.format(o.getTrain().getTrainDate()));
            jo.setOrderId(o.getOrderId().toString());
            jo.setOrderMoney(o.getOrderMoney());
            jo.setOrderNum(o.getOrderNum().toString());

            jo.setOrderStatus(o.getOrderStatus().toString());
            jo.setTrainFrom(changeNumtoTrain(o.getTrain().getTrainFrom()));
            jo.setTrainTo(changeNumtoTrain(o.getTrain().getTrainTo()));
            jo.setOrderType(changeNumtoType(o.getOrderType()));

            jo.setOrderId(o.getOrderId().toString());
            jsonOrders.add(i,jo);
        }
        return jsonOrders;
    }
    public Order formatOrder(JSONObject jsonObject){
        Order o = new Order();
        o.setOrderStatus(3);
        o.setOrderTrip(jsonObject.getInteger("orderTrip"));
        o.setOrderType(jsonObject.getInteger("orderType"));
        o.setOrderClient(1);
        o.setOrderNum(1111111);
        o.setOrderMoney((float) 23);
        o.setOrderCtime(new Date());
        return o;
    }
}
