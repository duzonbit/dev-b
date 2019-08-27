package app.service;

import java.util.List;

import app.model.bbs.BbsModel;

/**
 * BbsService
 */
public interface BbsService {

    public List<BbsModel> findAll();

    public void create(BbsModel bbsModel);

    public BbsModel read(int idx);

    public boolean update(BbsModel bbsModel);

    public boolean delete(BbsModel bbsModel);
}