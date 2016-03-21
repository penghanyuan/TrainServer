package bit.service.impl;

import bit.dao.CommentMapper;
import bit.model.Comment;
import bit.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/10.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Comment getCommentbyId(int id) {
        return this.commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Comment> getCommentbyServerId(int serverid) {
        return this.commentMapper.selectCommentbyServerId(serverid);
    }
}
