package app.service;

import java.util.List;

import app.model.user.UserModel;
/**
 * UserService
 */
public interface UserService {

    public List<UserModel> findAll();

    public void create(UserModel userDTO);

    public UserModel read(int idx);

    public boolean update(UserModel userDTO);

    public boolean delete(UserModel userDTO);
}