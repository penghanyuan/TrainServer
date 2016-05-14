package bit.service;

import bit.model.Schedule;

import java.util.List;


/**
 * Created by penghanyuan on 16/5/10.
 */

public interface ScheduleService {
    public List<Schedule> showSchedule(String trainnum);
}
