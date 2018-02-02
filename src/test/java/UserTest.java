import bit.facade.OrderFacade;
import bit.facade.TrainFacade;
import bit.function.MyFunction;
import bit.model.*;
import bit.service.*;
import com.alibaba.fastjson.JSON;
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
    TrainFacade trainFacade;
    @Autowired
    private CommentService commentService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private OrderFacade orderFacade;
    @Autowired
    private MyFunction myFunction;
    @Autowired
    private ScheduleService scheduleService;
    @Test
    public void test1() {
      //  List<Server> user = serverService.getCommentbyServerId(serverService.logIn("12321232321",""));
      //  System.out.println(JSON.toJSONString(user.get(0)));
        List<Schedule> order= scheduleService.showSchedule("G123");
        System.out.println(JSON.toJSONString(order));


//        Train train = trainService.getOrderbyTrainId(1);
//        System.out.println(JSON.toJSONString(train));
    }
}
