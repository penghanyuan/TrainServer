package bit.service.impl;

import bit.dao.ServerMapper;
import bit.model.Comment;
import bit.model.Order;
import bit.model.Server;
import bit.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/10.
 */
@Service("serverService")
public class ServerServiceImpl implements ServerService {
    @Autowired
    private ServerMapper serverMapper;

    @Override
    public Server getServerbyId(int id) {
        return this.serverMapper.selectByPrimaryKey(id);
    }

    @Override
    public int logIn(String tel, String psw) {
        Server server;
        server = this.serverMapper.selectByUserName(tel);
        if(server!=null) {
            if (server.getServerPassword().equals(psw)) {
                return server.getServerId();
            } else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }

    @Override
    public int signUp(Server server) {
        serverMapper.insert(server);
        return server.getServerId();
    }

    @Override
    public int setServerCode(String servercode,String sid) {
        Server server = new Server();
        server.setServerCode(servercode);
        server.setServerId(Integer.valueOf(sid));
        return serverMapper.updateByPrimaryKeySelective(server);
    }

    @Override
    public List<Server> getServerbyStation(int station) {
        return serverMapper.selectByStation(station);
    }
}
