package bit.service;

import bit.model.Client;

/**
 * Created by penghanyuan on 16/3/10.
 */
public interface ClientService {
    public Client getClientbyId(int id);
    //所有操作数据库的方法都写在这里,每个service只操作一张表,命名稍微有意义点
}
