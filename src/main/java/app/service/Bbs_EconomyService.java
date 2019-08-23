package app.service;

import java.util.List;
import java.util.Optional;

import app.model.bbs.Bbs_EconomyModel;
/**
 * BbsService
 */
public interface Bbs_EconomyService {

    public List<Bbs_EconomyModel> findAll();

    public void create(Bbs_EconomyModel bbs_EconomyModel);

    public Bbs_EconomyModel read(int idx);

    public boolean update(Bbs_EconomyModel bbs_EconomyModel, Optional<Integer> idx);

    public boolean delete(Bbs_EconomyModel bbs_EconomyModel, Optional<Integer> idx);
}