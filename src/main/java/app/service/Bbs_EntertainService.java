package app.service;

import java.util.List;
import java.util.Optional;

import app.model.bbs.Bbs_EntertainModel;

/**
 * BbsService
 */
public interface Bbs_EntertainService {

    public List<Bbs_EntertainModel> findAll();

    public void create(Bbs_EntertainModel bbs_EntertainModel);

    public Bbs_EntertainModel read(int idx);

    public boolean update(Bbs_EntertainModel bbs_EntertainModel, Optional<Integer> idx);

    public boolean delete(Bbs_EntertainModel bbs_EntertainModel, Optional<Integer> idx);
}