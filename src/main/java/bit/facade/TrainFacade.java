package bit.facade;

import bit.model.Train;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/29.
 */
public interface TrainFacade {
    public List<Train> showClientTrainbyClientid(int clientid);
    public Train showTrainDetail(int trainid);
}
