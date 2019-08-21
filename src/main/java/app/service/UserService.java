package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repository.UserRepo;
import app.model.UserModel;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<UserModel> findAll() {
        return userRepo.findAll();
    }

    public void create(UserModel userDTO) {  //TODO 유효성 검사
        userRepo.saveAndFlush(userDTO);
    }

    public UserModel read(int idx) {
        return userRepo.findById(idx).orElse(null);
    }

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