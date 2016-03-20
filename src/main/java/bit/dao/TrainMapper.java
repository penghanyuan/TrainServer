package bit.dao;

import bit.model.Train;

public interface TrainMapper {
    int deleteByPrimaryKey(Integer trainId);

    int insert(Train record);

    int insertSelective(Train record);

    Train selectByPrimaryKey(Integer trainId);

    int updateByPrimaryKeySelective(Train record);

    int updateByPrimaryKey(Train record);

    Train selectOrderbyTrainId(int trainid);//防止重复订单
}