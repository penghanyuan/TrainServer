package bit.service.impl;

import bit.dao.TrainMapper;
import bit.model.Train;
import bit.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/10.
 */
@Service("trainService")
public class TrainServiceImpl implements TrainService{
    @Autowired
    private TrainMapper trainMapper;

    @Override
    public Train getTrainbyId(int id) {
        return this.trainMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Train> getTrainbyClientId(int clientid) {
        return this.trainMapper.selectTrainbyClientid(clientid);
    }
}
