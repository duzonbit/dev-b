package app.service;

import java.util.List;

import app.model.comment.CommentModel;

/**
 * CommentService
 */
public interface CommentService {
    public void create(CommentModel commentModel);

    public List<CommentModel> read(int bbs_idx);

    public boolean update(CommentModel commentModel);

    public boolean delete(CommentModel commentModel);

    public List<CommentModel> count(int bbs_idx, int curpage);

    public int maxpage(int bbs_idx);
    
}