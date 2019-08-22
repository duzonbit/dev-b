
package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.BbsModel;
import app.repository.BbsRepo;

@Service
public class BbsService {

  @Autowired
  BbsRepo boardRepo;

  public List<BbsModel> findAll() {
    return boardRepo.findAll();
  }

  public void create(BbsModel bbsModel) {
    boardRepo.saveAndFlush(bbsModel);
  }

  public BbsModel read(int idx) {
    return boardRepo.findById(idx).orElse(null);
  }

  public boolean update(BbsModel bbsModel, Optional<Integer> idx) {
    BbsModel res = boardRepo.findById(idx.orElse(null)).orElse(null);

    if (res.getIdx() == bbsModel.getIdx() && res.getName().equals(bbsModel.getName())
        && res.getPw().equals(bbsModel.getPw())) {
      boardRepo.save(bbsModel);
      return true;
    } else {
      return false;
    }
  }

  public boolean delete(BbsModel bbsModel, Optional<Integer> idx) {
    BbsModel res = boardRepo.findById(idx.orElse(null)).orElse(null);

    if (res.getIdx() == bbsModel.getIdx() && res.getPw().equals(bbsModel.getPw())) {
      boardRepo.deleteById(bbsModel.getIdx());
      return true;
    } else {
      return false;
    }
  }
}