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

    public void create(UserModel userModel) {
        userRepo.saveAndFlush(userModel);
    }

    public boolean login(String id, String pw) {
        UserModel userModel = userRepo.findByUserId(id);
        if(userModel == null) {
            return false;
        }
        if(!userModel.getPw().equals(pw)){
            return false;
        }
        return true;
    }

    public boolean loginCheck(String id) {
        UserModel userModel = userRepo.findByUserId(id);
        System.out.println(userModel);
        if (userModel == null) {
			return true; // 입력한 아이디가 이미 존재함
		} else {
			return false; // 아이디 사용 가능
		}
    }

    public UserModel read(int idx) {
        return userRepo.findById(idx).orElse(null);
    }

    public boolean update(UserModel userModel) {
        UserModel res = userRepo.findById(userModel.getIdx()).orElse(null);

        if (res.getIdx() == userModel.getIdx() && res.getName().equals(userModel.getName())
                && res.getPw().equals(userModel.getPw())) {
            userRepo.save(userModel);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(UserModel userModel) {
        UserModel res = userRepo.findById(userModel.getIdx()).orElse(null);
        if (res.getIdx() == userModel.getIdx() && res.getPw().equals(userModel.getPw())) {
            userRepo.deleteById(userModel.getIdx());
            return true;
        } else {
            return false;
        }
    }
}