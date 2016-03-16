package bit.service;

import bit.model.Client;
import bit.model.Order;
import bit.model.Train;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/10.
 */
public interface ClientService {
    public Client getClientbyId(int id);
    public List<Client> getOrderbyClientId(int clientid);
    public List<Client> getTrainbyClientId(int clientid);
}
