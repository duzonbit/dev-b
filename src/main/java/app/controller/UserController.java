package app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.UserModel;
import app.service.UserService;

@RestController
@CrossOrigin("origin-allowed=*") 
@RequestMapping(value = "/user")
public class UserController {
    //관리자 삭제 및 유저 컨트롤
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> signUp(@RequestBody UserModel userModel) {
        Map<String, String> map = new HashMap<String, String>();
        userService.create(userModel);
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, String> signIn(@RequestBody UserModel userModel) {
        System.out.println();
        Map<String, String> map = new HashMap<String, String>();
        String msg = userService.login(userModel.getUser_id(), userModel.getPw()) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }

    @RequestMapping(value = "/check/{id}", method = RequestMethod.POST)
    public Map<String, String> loginCheck(@PathVariable String id) {
        System.out.println(id);
        Map<String, String> map = new HashMap<String, String>();
        String msg = userService.loginCheck(id) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Map<String, String> update(@RequestBody UserModel mm) {
        Map<String, String> map = new HashMap<String, String>();
        String msg = userService.update(mm) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }

    @RequestMapping(value = { "/" }, method = RequestMethod.DELETE)
    public Map<String, String> delete(@RequestBody UserModel mm) {
        Map<String, String> map = new HashMap<String, String>();
        String msg = userService.delete(mm) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }
}