
package app.service.impl;

import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.bbs.BbsModel;
import app.model.bbs.Bbs_EntertainModel;
import app.repository.bbs.BbsRepo;
import app.repository.bbs.Bbs_EntertainRepo;
import app.service.Bbs_EntertainService;

@Service
public class Bbs_EntertainServiceimpl implements Bbs_EntertainService{

  @Autowired
  BbsRepo bbsRepo;
  
  @Autowired
  Bbs_EntertainRepo bbs_EntertainRepo;

  @Override
  public List<Bbs_EntertainModel> findAll() {
    return bbs_EntertainRepo.findAll();
  }

  @Override
  public void create(Bbs_EntertainModel bbs_EntertainModel) {
    Gson gson = new Gson();
    String tmp = gson.toJson(bbs_EntertainModel);
    BbsModel bbsModel = gson.fromJson(tmp, BbsModel.class);
   
    bbsRepo.saveAndFlush(bbsModel);

    int MAXidx = bbsRepo.findMAXidx();

    bbs_EntertainModel.setIdx(MAXidx);
    
    bbs_EntertainRepo.saveAndFlush(bbs_EntertainModel);
  }

  @Override
  public Bbs_EntertainModel read(int idx) {
    return bbs_EntertainRepo.findById(idx).orElse(null);
  }
  
  @Override
  public boolean update(Bbs_EntertainModel bbs_EntertainModel, Optional<Integer> idx) {
    Bbs_EntertainModel res= bbs_EntertainRepo.findById(idx.orElse(null)).orElse(null);
      
    if(res.getIdx()==bbs_EntertainModel.getIdx() &&res.getName().equals(bbs_EntertainModel.getName()) &&res.getPw().equals(bbs_EntertainModel.getPw())){
      Gson gson = new Gson();
      String tmp = gson.toJson(bbs_EntertainModel);
      BbsModel bbsModel = gson.fromJson(tmp, BbsModel.class);

      bbsRepo.save(bbsModel);

      bbs_EntertainRepo.save(bbs_EntertainModel);
      return true;
    }else{
      return false;
    }
  }

  @Override
  public boolean delete(Bbs_EntertainModel bbs_EntertainModel, Optional<Integer> idx){
    Bbs_EntertainModel res= bbs_EntertainRepo.findById(idx.orElse(null)).orElse(null);
    
    if(res.getIdx()==bbs_EntertainModel.getIdx() &&res.getPw().equals(bbs_EntertainModel.getPw())){
      bbsRepo.deleteById(bbs_EntertainModel.getIdx());
      return true;
    }else{
      return false;
    }
  }
}