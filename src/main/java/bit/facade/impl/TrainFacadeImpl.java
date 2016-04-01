package bit.facade.impl;

import bit.facade.TrainFacade;
import bit.model.Train;
import bit.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/29.
 */
@Component("trainFacade")
public class TrainFacadeImpl implements TrainFacade {
    @Autowired
    TrainService trainService;
    @Override
    public List<Train> showClientTrainbyClientid(int clientid) {
        return this.trainService.getTrainbyClientId(clientid);
    }
}
