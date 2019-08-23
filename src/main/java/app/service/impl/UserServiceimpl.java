package app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.user.UserModel;
import app.repository.user.UserRepo;
import app.service.UserService;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<UserModel> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void create(UserModel userDTO) {  //TODO 유효성 검사
        userRepo.saveAndFlush(userDTO);
    }

    @Override
    public UserModel read(int idx) {
        return userRepo.findById(idx).orElse(null);
    }

    @Override
    public boolean update(UserModel userDTO) {  //TODO 유효성 검사
        UserModel res = userRepo.findById(userDTO.getIdx()).orElse(null);

        if (res.getIdx() == userDTO.getIdx() && res.getName().equals(userDTO.getName())
                && res.getPw().equals(userDTO.getPw())) {
            userRepo.save(userDTO);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(UserModel userDTO) {
        UserModel res = userRepo.findById(userDTO.getIdx()).orElse(null);
        if (res.getIdx() == userDTO.getIdx() && res.getPw().equals(userDTO.getPw())) {
            userRepo.deleteById(userDTO.getIdx());
            return true;
        } else {
            return false;
        }
    }
}