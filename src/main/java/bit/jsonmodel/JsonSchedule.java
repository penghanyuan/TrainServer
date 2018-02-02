package bit.jsonmodel;

import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by penghanyuan on 16/5/12.
 */
public class JsonSchedule {
    private Integer trainId;

    private String trainNum;

    private String trainStation;

    private String trainAtime;

    private String trainLtime;

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

    public String getTrainStation() {
        return trainStation;
    }

    public void setTrainStation(String trainStation) {
        this.trainStation = trainStation;
    }

    public String getTrainAtime() {
        return trainAtime;
    }

    public void setTrainAtime(String trainAtime) {
        this.trainAtime = trainAtime;
    }

    public String getTrainLtime() {
        return trainLtime;
    }

    public void setTrainLtime(String trainLtime) {
        this.trainLtime = trainLtime;
    }
}
