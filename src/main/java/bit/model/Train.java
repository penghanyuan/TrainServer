package bit.model;

import java.util.Date;
import java.util.List;

public class Train {
    private Integer trainId;

    private String trainNum;

    private Date trainDate;

    private String trainCarriage;

    private Integer trainFrom;

    private Integer trainTo;

    private Integer trainClient;

    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum == null ? null : trainNum.trim();
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public String getTrainCarriage() {
        return trainCarriage;
    }

    public void setTrainCarriage(String trainCarriage) {
        this.trainCarriage = trainCarriage == null ? null : trainCarriage.trim();
    }

    public Integer getTrainFrom() {
        return trainFrom;
    }

    public void setTrainFrom(Integer trainFrom) {
        this.trainFrom = trainFrom;
    }

    public Integer getTrainTo() {
        return trainTo;
    }

    public void setTrainTo(Integer trainTo) {
        this.trainTo = trainTo;
    }

    public Integer getTrainClient() {
        return trainClient;
    }

    public void setTrainClient(Integer trainClient) {
        this.trainClient = trainClient;
    }
}