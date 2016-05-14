package bit.dao;

import bit.model.Schedule;

import java.util.List;

public interface ScheduleMapper {
    int deleteByPrimaryKey(Integer trainId);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer trainId);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

    List<Schedule> selectByTrainNum(String trainnum);
}