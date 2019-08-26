package app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.bbs.BbsModel;
import app.repository.bbs.BbsRepo;

/**
 * BbsServiceimpl
 */
@Service
public class BbsServiceimpl {

    @Autowired
    BbsRepo bRepo;

    public List<BbsModel> findAll() {
        return bRepo.findAll();
    }

    public void create(BbsModel bbsModel) {
        bRepo.saveAndFlush(bbsModel);
    }

    public BbsModel read(int idx) {
        return bRepo.findById(idx).orElse(null);
    }

    public boolean update(BbsModel bbsModel) {
        BbsModel res = bRepo.findById(bbsModel.getIdx()).orElse(null);

        if (res.getIdx() == bbsModel.getIdx() && res.getName().equals(bbsModel.getName())
                && res.getPw().equals(bbsModel.getPw())) {
            bRepo.save(bbsModel);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(BbsModel bbsModel) {
        BbsModel res = bRepo.findById(bbsModel.getIdx()).orElse(null);
        if (res.getIdx() == bbsModel.getIdx() && res.getPw().equals(bbsModel.getPw())) {
            bRepo.deleteById(bbsModel.getIdx());
            return true;
        } else {
            return false;
        }
    }
}