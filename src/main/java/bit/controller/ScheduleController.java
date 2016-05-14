package bit.controller;

import bit.function.MyFunction;
import bit.jsonmodel.JsonOrder;
import bit.jsonmodel.JsonSchedule;
import bit.model.Order;
import bit.model.Schedule;
import bit.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Contended;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by penghanyuan on 16/5/10.
 */
@Controller
@RequestMapping("/scheduleController")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    MyFunction myFunction;
    @RequestMapping("/{trainnum}/showSchedule")
    @ResponseBody
    public Map<String,Object> showSchedule(@PathVariable String trainnum, HttpServletRequest request) {
        Map<String,Object> rmap = new HashMap<String, Object>();
        List<Schedule> schedules = this.scheduleService.showSchedule(trainnum);
        List<JsonSchedule> jsonSchedule = myFunction.fomartSchedules(schedules);
        if(schedules!=null)
        {
            rmap.put("status",1);
            rmap.put("data",jsonSchedule);
        }
        else {
            rmap.put("status",0);
        }
        return rmap;
    }
}
