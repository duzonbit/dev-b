package app.service.impl;

import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.bbs.BbsModel;
import app.model.bbs.Bbs_EconomyModel;
import app.repository.bbs.BbsRepo;
import app.repository.bbs.Bbs_EconomyRepo;
import app.service.Bbs_EconomyService;

@Service
public class Bbs_EconomyServiceimpl implements Bbs_EconomyService {

  @Autowired
  BbsRepo bbsRepo;

  @Autowired
  Bbs_EconomyRepo bbs_EconomyRepo;

  @Override
  public List<Bbs_EconomyModel> findAll() {
    return bbs_EconomyRepo.findAll();
  }

  @Override
  public void create(Bbs_EconomyModel bbs_EconomyModel) {
    Gson gson = new Gson();
    String tmp = gson.toJson(bbs_EconomyModel);
    BbsModel bbsModel = gson.fromJson(tmp, BbsModel.class);
    
    bbsRepo.saveAndFlush(bbsModel);

    int MAXidx = bbsRepo.findMAXidx();

    bbs_EconomyModel.setIdx(MAXidx);

    bbs_EconomyRepo.saveAndFlush(bbs_EconomyModel);
  }

  @Override
  public Bbs_EconomyModel read(int idx) {
    return bbs_EconomyRepo.findById(idx).orElse(null);
  }

  @Override
  public boolean update(Bbs_EconomyModel bbs_EconomyModel, Optional<Integer> idx) {
    Bbs_EconomyModel res = bbs_EconomyRepo.findById(idx.orElse(null)).orElse(null);

    if (res.getIdx() == bbs_EconomyModel.getIdx() && res.getName().equals(bbs_EconomyModel.getName()) && res.getPw().equals(bbs_EconomyModel.getPw())) {
      Gson gson = new Gson();
      String tmp = gson.toJson(bbs_EconomyModel);
      BbsModel bbsModel = gson.fromJson(tmp, BbsModel.class);

      bbsRepo.save(bbsModel);

      bbs_EconomyRepo.save(bbs_EconomyModel);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean delete(Bbs_EconomyModel bbs_EconomyModel, Optional<Integer> idx) {
    Bbs_EconomyModel res = bbs_EconomyRepo.findById(idx.orElse(null)).orElse(null);

    if (res.getIdx() == bbs_EconomyModel.getIdx() && res.getPw().equals(bbs_EconomyModel.getPw())) { 
      bbsRepo.deleteById(bbs_EconomyModel.getIdx());
      return true;
    } else {
      return false;
    }
  }
}