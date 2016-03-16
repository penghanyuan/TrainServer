import bit.model.*;
import bit.service.ClientService;
import bit.service.OrderService;
import bit.service.ServerService;
import com.alibaba.fastjson.JSON;
import org.aspectj.weaver.ast.Or;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

import java.util.List;

/**
 * Created by penghanyuan on 15/12/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class UserTest {
    @Autowired
    private ServerService serverService;
    @Autowired
    private OrderService orderService;
    @Test
    public void test1() {
      //  List<Server> user = serverService.getCommentbyServerId(serverService.logIn("12321232321",""));
      //  System.out.println(JSON.toJSONString(user.get(0)));
        Order order = orderService.getTrainbyOrderId(1);
        System.out.println(JSON.toJSONString(order));
    }
}
