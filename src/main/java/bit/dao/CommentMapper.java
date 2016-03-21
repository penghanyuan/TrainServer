package bit.dao;

import bit.model.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectCommentbyServerId(int serverid);
}