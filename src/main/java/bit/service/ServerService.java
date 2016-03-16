package bit.service;

import bit.model.Comment;
import bit.model.Order;
import bit.model.Server;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/10.
 */
public interface ServerService {
//    public Server getServerbyId(int id);
//    public int signUp(Server server);
        public int logIn(String tel,String psw);
        public List<Server> getOrderbyServerId(int serverid);
        public List<Server> getCommentbyServerId(int serverid);
}
