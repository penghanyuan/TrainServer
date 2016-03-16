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
    public List<Server> getOrderbyServerId(int serverid) {
        return this.serverMapper.selectOrderbyServerId(serverid);
    }

    @Override
    public List<Server> getCommentbyServerId(int serverid) {
        return this.serverMapper.selectCommentbyServerId(serverid);
    }

    @Override
    public int logIn(String tel, String psw) {
        Server server;
        server = this.serverMapper.selectByUserName(tel);
        return server.getServerId();
    }
}
