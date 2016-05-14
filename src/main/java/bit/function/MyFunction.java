package bit.function;

import bit.facade.OrderFacade;
import bit.facade.ServerFacade;
import bit.facade.TrainFacade;
import bit.jsonmodel.JsonOrder;
import bit.jsonmodel.JsonSchedule;
import bit.jsonmodel.JsonTrain;
import bit.model.Order;
import bit.model.Schedule;
import bit.model.Server;
import bit.model.Train;
import bit.service.ScheduleService;
import bit.service.ServerService;
import bit.service.TrainService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.formula.functions.T;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    OrderFacade orderFacade;
    @Autowired
    ServerService serverService;
    @Autowired
    TrainService trainService;
    @Autowired
    ScheduleService scheduleService;
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
        String formatType = "yyyy年MM月dd日 ";
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
            {
                jo.setServerTel(o.getServer().getServerTel());
                jo.setServerName(o.getServer().getServerName());
                jo.setServerId(o.getServer().getServerId().toString());
            }

            jo.setTrainClient(o.getClient().getClientName());
            jo.setOrderCtime(sdf.format(o.getOrderCtime()));
            jo.setTrainNum(o.getTrain().getTrainNum());
            jo.setTrainDate(sdf.format(o.getTrain().getTrainDate()));
            jo.setOrderId(o.getOrderId().toString());
            jo.setOrderMoney(o.getOrderMoney());
            jo.setOrderNum(o.getOrderNum().toString());
            jo.setOrderStatus(o.getOrderStatus().toString());
            jo.setTrainFrom(changeNumtoTrain(o.getTrain().getTrainFrom()));
            jo.setTrainTo(changeNumtoTrain(o.getTrain().getTrainTo()));
            jo.setOrderType(changeNumtoType(o.getOrderType()));
//            String trainnum = trainService.getTrainbyId(o.getOrderTrip()).getTrainNum();
//            jo.setSchedules(scheduleService.showSchedule(trainnum));
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
    public JsonOrder formatOrder(Order order){



        Order o = order;
        String formatType = "yyyy年MM月dd日 HH时mm分ss秒";
        SimpleDateFormat sdf =  new SimpleDateFormat(formatType);

            JsonOrder jo = new JsonOrder();

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
            jo.setTrainNum(o.getTrain().getTrainNum());
            jo.setOrderStatus(o.getOrderStatus().toString());
            jo.setTrainFrom(changeNumtoTrain(o.getTrain().getTrainFrom()));
            jo.setTrainTo(changeNumtoTrain(o.getTrain().getTrainTo()));
            jo.setOrderType(changeNumtoType(o.getOrderType()));

            jo.setOrderId(o.getOrderId().toString());

        return jo;
    }
    public List<JsonTrain> fomartTrain(List<Train> trains) {
        List<JsonTrain> jsonTrains= new ArrayList<JsonTrain>();
        String formatType = "yyyy年MM月dd日";
        SimpleDateFormat sdf =  new SimpleDateFormat(formatType);
        if(trains==null)
            return null;
        for(int i = 0;i<trains.size();i++)
        {
            JsonTrain jst  = new JsonTrain();
            jst.setTrainClient(trains.get(i).getClient().getClientName());
            jst.setTrainDate(sdf.format(trains.get(i).getTrainDate()));
            jst.setTrainFrom(changeNumtoTrain(trains.get(i).getTrainFrom()));
            jst.setTrainTo(changeNumtoTrain(trains.get(i).getTrainTo()));
            jst.setTrainId(trains.get(i).getTrainId());
            jst.setTrainNum(trains.get(i).getTrainNum());
            jsonTrains.add(i,jst);
        }

        return jsonTrains;

    }
    public Server verfiyServer(JSONObject jsonObject){
        Server server = new Server();
        server.setServerName(jsonObject.getString("servername"));
        server.setServerPassword(jsonObject.getString("password"));
        server.setServerPid(jsonObject.getString("userpid"));
        server.setServerStation(this.changeTraintoNum(jsonObject.getString("userstation")));
        server.setServerTel(jsonObject.getString("username"));
        server.setServerNum("1111123");
        server.setServerPhoto("url");
        return server;
    }

    public List<String> getAllCid(String orderid){
        List<String> cids = new ArrayList<String>();
        int trip =   orderFacade.showOrderDetail(Integer.valueOf(orderid)).getOrderTrip();
        if(orderFacade.showOrderDetail(Integer.valueOf(orderid)).getOrderType()==0)
        {
            int trainto = trainService.getTrainbyId(trip).getTrainTo();
            List<Server> servers =  serverService.getServerbyStation(trainto);
            for(int i = 0;i<servers.size();i++)
            {
                cids.add(i,servers.get(i).getServerCode());
            }
            return cids;
        }
        else {
            int trainfrom = trainService.getTrainbyId(trip).getTrainFrom();
            List<Server> servers = serverService.getServerbyStation(trainfrom);
            for (int i = 0; i < servers.size(); i++) {
                cids.add(i, servers.get(i).getServerCode());
            }
            return cids;
        }
    }

    public List<JsonSchedule> fomartSchedules(List<Schedule> schedules){
        List<JsonSchedule> jsonSchedules= new ArrayList<JsonSchedule>();
        String formatType = "HH:mm";
        SimpleDateFormat sdf =  new SimpleDateFormat(formatType);
        if(schedules==null)
            return null;
        for(int i = 0;i<schedules.size();i++)
        {
            JsonSchedule jst  = new JsonSchedule();
            jst.setTrainAtime(sdf.format(schedules.get(i).getTrainAtime()));

            jst.setTrainLtime(sdf.format(schedules.get(i).getTrainLtime()));
            jst.setTrainId(schedules.get(i).getTrainId());
            jst.setTrainNum(schedules.get(i).getTrainNum());
            jst.setTrainStation(schedules.get(i).getTrainStation());
            jsonSchedules.add(i,jst);
        }

        return jsonSchedules;
    }

}
