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
    UserServiceimpl userServiceimpl;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> insert(@RequestBody UserModel userModel) {
        Map<String, String> map = new HashMap<String, String>();
        userServiceimpl.create(userModel);
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, String> login(@RequestBody UserModel userModel) {
        Map<String, String> map = new HashMap<String, String>();
        String msg = userServiceimpl.login(userModel.getUser_id(), userModel.getPw()) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }

    @RequestMapping(value = "/check/{id}", method = RequestMethod.POST)
    public Map<String, String> loginCheck(@PathVariable String id) {
        Map<String, String> map = new HashMap<String, String>();
        String msg = userServiceimpl.loginCheck(id) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Map<String, String> update(@RequestBody UserModel userModel) {
        Map<String, String> map = new HashMap<String, String>();
        String msg = userServiceimpl.update(userModel) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }
    
    @RequestMapping(value = { "/" }, method = RequestMethod.DELETE)
    public Map<String, String> delete(@RequestBody UserModel userModel) {
        Map<String, String> map = new HashMap<String, String>();
        String msg = userServiceimpl.delete(userModel) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }
}