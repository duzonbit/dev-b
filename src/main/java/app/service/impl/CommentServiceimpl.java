package app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.comment.CommentModel;
import app.repository.comment.CommentRepo;
import app.service.CommentService;

@Service
public class CommentServiceimpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Override
    public void create(CommentModel commentModel) {
        commentRepo.saveAndFlush(commentModel);
    }

    @Override
    public List<CommentModel> read(int bbs_idx) {
        return commentRepo.findByBbs_idx(bbs_idx);
    }

    @Override
    public boolean update(CommentModel commentModel) {
        CommentModel res = commentRepo.findById(commentModel.getIdx()).orElse(null);

        if (res.getIdx() == commentModel.getIdx() && res.getUser_idx() == commentModel.getUser_idx()
                && res.getBbs_idx() == commentModel.getBbs_idx()) {
            commentRepo.save(commentModel);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(CommentModel commentModel) {
        commentRepo.deleteById(commentModel.getIdx());
        return true;
    }

    @Override
    public List<CommentModel> count(int bbs_idx, int curpage) {
        int pagestart = curpage * 10;
        return commentRepo.findBycount(bbs_idx, pagestart);
    }

    @Override
    public int maxpage(int bbs_idx) {
        int count = commentRepo.findBycount(bbs_idx);
        System.out.println(count + "   111111111111111111");
        System.out.println(bbs_idx + "   22222222222222222");
        int maxpage = (int) Math.ceil(count / 10);
        System.out.println(maxpage + "   333333333333333333");
        if (maxpage == 0) {
            return 1;
        } else {
            return maxpage;
        }
    }
}