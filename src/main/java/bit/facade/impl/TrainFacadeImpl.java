package bit.facade.impl;

import bit.facade.TrainFacade;
import bit.model.Client;
import bit.model.Train;
import bit.service.ClientService;
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
    @Autowired
    ClientService clientService;
    @Override
    public List<Train> showClientTrainbyClientid(int clientid) {
        List<Train> trains = this.trainService.getTrainbyClientId(clientid);
        Client client = clientService.getClientbyId(clientid);
        if(trains!=null)
        {
            for(int i = 0; i < trains.size(); i++)
            {
                trains.get(i).setClient(client);
            }
            return trains;
        }
        else
            return null;
    }

    @Override
    public Train showTrainDetail(int trainid) {
        return trainService.getTrainbyId(trainid);
    }
}
