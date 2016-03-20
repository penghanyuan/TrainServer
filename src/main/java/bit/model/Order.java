package bit.model;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer orderId;

    private Integer orderNum;

    private Integer orderStatus;

    private Integer orderType;

    private Integer orderServer;

    private Date orderCtime;

    private Date orderRtime;

    private Date orderFtime;

    private Float orderMoney;

    private Integer orderClient;

    private Integer orderTrip;


    private List<Comment> comments;

    private Train train;

    private Client client;

    private Server server;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderServer() {
        return orderServer;
    }

    public void setOrderServer(Integer orderServer) {
        this.orderServer = orderServer;
    }

    public Date getOrderCtime() {
        return orderCtime;
    }

    public void setOrderCtime(Date orderCtime) {
        this.orderCtime = orderCtime;
    }

    public Date getOrderRtime() {
        return orderRtime;
    }

    public void setOrderRtime(Date orderRtime) {
        this.orderRtime = orderRtime;
    }

    public Date getOrderFtime() {
        return orderFtime;
    }

    public void setOrderFtime(Date orderFtime) {
        this.orderFtime = orderFtime;
    }

    public Float getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Float orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(Integer orderClient) {
        this.orderClient = orderClient;
    }

    public Integer getOrderTrip() {
        return orderTrip;
    }

    public void setOrderTrip(Integer orderTrip) {
        this.orderTrip = orderTrip;
    }


}