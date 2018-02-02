package bit.jsonmodel;

import java.util.Date;

/**
 * Created by penghanyuan on 16/4/1.
 */
public class JsonTrain {
    private Integer trainId;

    private String trainNum;

    private String trainDate;

    private String trainCarriage;

    private String trainFrom;

    private String trainTo;

    private String trainClient;

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
        this.trainNum = trainNum;
    }

    public String getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(String trainDate) {
        this.trainDate = trainDate;
    }

    public String getTrainCarriage() {
        return trainCarriage;
    }

    public void setTrainCarriage(String trainCarriage) {
        this.trainCarriage = trainCarriage;
    }

    public String getTrainFrom() {
        return trainFrom;
    }

    public void setTrainFrom(String trainFrom) {
        this.trainFrom = trainFrom;
    }

    public String getTrainTo() {
        return trainTo;
    }

    public void setTrainTo(String trainTo) {
        this.trainTo = trainTo;
    }

    public String getTrainClient() {
        return trainClient;
    }

    public void setTrainClient(String trainClient) {
        this.trainClient = trainClient;
    }
}
