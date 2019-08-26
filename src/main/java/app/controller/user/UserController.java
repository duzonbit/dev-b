package app.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.user.UserModel;
import app.repository.user.UserRepo;
import app.service.impl.UserServiceimpl;

/**
 * MemberA
 */
@RestController
@CrossOrigin("origin-allowed=*")  // 접근? 인증?
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserServiceimpl us;

    @Autowired
    UserRepo ur;

    //! 회원가입
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> insert(@RequestBody UserModel userModel) {
        Map<String, String> map = new HashMap<String, String>();
        us.create(userModel);
        map.put("message", "success");
        return map;
    }

    //! 로그인
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, String> login(@RequestBody UserModel userModel) {
        System.out.println("11111111111111111111111" + userModel);
        Map<String, String> map = new HashMap<String, String>();
        String msg = us.login(userModel.getUser_id(), userModel.getPw()) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }

    //! 아이디 중복체크
    @RequestMapping(value = "/check/{id}", method = RequestMethod.POST)
    public Map<String, String> loginCheck(@PathVariable String id) {
        System.out.println(id);
        Map<String, String> map = new HashMap<String, String>();
        String msg = us.loginCheck(id) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }

    //! 회원 수정
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Map<String, String> update(@RequestBody UserModel userModel) {
        Map<String, String> map = new HashMap<String, String>();
        String msg = us.update(userModel) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }
    
    //! 회원 삭제
    @RequestMapping(value = { "/" }, method = RequestMethod.DELETE)
    public Map<String, String> delete(@RequestBody UserModel userModel) {
        Map<String, String> map = new HashMap<String, String>();
        String msg = us.delete(userModel) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }
}