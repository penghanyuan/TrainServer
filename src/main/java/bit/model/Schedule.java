package bit.model;

import java.util.Date;

public class Schedule {
    private Integer trainId;

    private String trainNum;

    private String trainStation;

    private Date trainAtime;

    private Date trainLtime;

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

    public String getTrainStation() {
        return trainStation;
    }

    public void setTrainStation(String trainStation) {
        this.trainStation = trainStation == null ? null : trainStation.trim();
    }

    public Date getTrainAtime() {
        return trainAtime;
    }

    public void setTrainAtime(Date trainAtime) {
        this.trainAtime = trainAtime;
    }

    public Date getTrainLtime() {
        return trainLtime;
    }

    public void setTrainLtime(Date trainLtime) {
        this.trainLtime = trainLtime;
    }
}