package bit.facade;

import bit.model.Server;
import bit.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by penghanyuan on 16/4/11.
 */

public interface ServerFacade {
    public int signUp(Server server);
    public int logIn(String tel, String psw);
}
