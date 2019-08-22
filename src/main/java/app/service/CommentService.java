package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.CommentModel;
import app.repository.CommentRepo;

/**
 * CommentS
 */
@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    public void create(CommentModel commentModel) {
        commentRepo.saveAndFlush(commentModel);
    }

    public List<CommentModel> read(int bbs_idx) {
        return commentRepo.findByBbs_idx(bbs_idx);
    }

    public boolean update(CommentModel commentModel) {
        CommentModel res = commentRepo.findById(commentModel.getIdx()).orElse(null);

        if (res.getIdx() == commentModel.getIdx() &&
            res.getUser_idx() == commentModel.getUser_idx() && 
            res.getBbs_idx() == commentModel.getBbs_idx()) {
            commentRepo.save(commentModel);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(CommentModel commentModel) {
        commentRepo.deleteById(commentModel.getIdx());
        return true;
    }
}