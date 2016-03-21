package bit.service;

import bit.model.Comment;

import java.util.List;

/**
 * Created by penghanyuan on 16/3/10.
 */
public interface CommentService {
    public Comment getCommentbyId(int id);
    public List<Comment> getCommentbyServerId(int serverid);
}
