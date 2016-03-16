package bit.service.impl;

import bit.dao.ClientMapper;
import bit.model.Client;
import bit.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by penghanyuan on 16/3/10.
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;
    private Client client;

    @Override
    public Client getClientbyId(int id){

        client = clientMapper.selectByPrimaryKey(1);
        return client;
    }
}
