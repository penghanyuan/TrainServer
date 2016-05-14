package bit.facade.impl;

import bit.facade.ServerFacade;
import bit.model.Server;
import bit.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by penghanyuan on 16/4/11.
 */
@Component("serverFacade")
public class ServerFacadeImpl implements ServerFacade {
    @Autowired
    ServerService serverService;
    @Override
    public int signUp(Server server) {
        return serverService.signUp(server);
    }

    @Override
    public int logIn(String tel, String psw) {
        return this.serverService.logIn(tel,psw);
    }

    @Override
    public int setPushCid(String cid, String sid) {
        return serverService.setServerCode(cid,sid);
    }

    @Override
    public Server getSrver(int serverid) {
        return serverService.getServerbyId(serverid);
    }
}
