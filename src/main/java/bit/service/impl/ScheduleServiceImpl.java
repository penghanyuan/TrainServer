package bit.service.impl;

import bit.dao.ScheduleMapper;
import bit.model.Schedule;
import bit.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by penghanyuan on 16/5/10.
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleMapper scheduleMapper;
    @Override
    public List<Schedule> showSchedule(String trainnum) {
        return scheduleMapper.selectByTrainNum(trainnum);
    }
}
