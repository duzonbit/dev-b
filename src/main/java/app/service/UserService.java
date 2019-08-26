package app.service;

import java.util.List;

import app.model.user.UserModel;
/**
 * UserService
 */
public interface UserService {

    public boolean login(String id, String pw);

    public boolean loginCheck(String id);

    public UserModel read(int idx);

    public boolean update(UserModel userDTO);

    public boolean delete(UserModel userDTO);
}