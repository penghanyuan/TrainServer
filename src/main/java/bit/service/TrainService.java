package bit.service;

import bit.model.Train;

/**
 * Created by penghanyuan on 16/3/10.
 */
public interface TrainService {
//    public Train getTrainbyId(int id);
    public Train getOrderbyTrainId(int trainid);
}
