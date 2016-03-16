package bit.service.impl;

import bit.dao.ClientMapper;
import bit.model.Client;
import bit.model.Order;
import bit.model.Train;
import bit.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/10.
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Client getClientbyId(int id){
        return  this.clientMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<Client> getOrderbyClientId(int clientid) {
        return this.clientMapper.selectOrderbyClientId(clientid);
    }

    @Override
    public List<Client> getTrainbyClientId(int clientid) {
        return this.clientMapper.selectTrainbyClientId(clientid);
    }
}
