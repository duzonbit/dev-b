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

    public void create(UserModel userDTO) {
        userRepo.saveAndFlush(userDTO);
    }

    public boolean login(String id, String pw) {  //! 로그인---------
        UserModel user = userRepo.findByUserId(id);
        if(user == null) {
            return false;
        }
        if(!user.getPw().equals(pw)){
            return false;
        }
        return true;
    }

    public boolean loginCheck(String id) {  //! 아이디 중복 체크---------
        UserModel user = userRepo.findByUserId(id);
        System.out.println(user);
        if (user == null) {
			return true; // 입력한 아이디가 이미 존재함
		} else {
			return false; // 아이디 사용 가능
		}
    }

    public UserModel read(int idx) {
        return userRepo.findById(idx).orElse(null);
    }

    public boolean update(UserModel userDTO) {
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