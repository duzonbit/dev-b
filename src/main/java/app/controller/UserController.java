package app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.UserModel;
import app.repository.UserRepo;
import app.service.UserService;

/**
 * MemberA
 */
@RestController
@CrossOrigin("origin-allowed=*")  // 접근? 인증?
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService us;

    @Autowired
    UserRepo ur;

    @GetMapping(value = { "/read/{index}" })
    public UserModel read(@PathVariable int index) {
        UserModel um = us.read(index);
        return um;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> insert(@RequestBody UserModel um) {
        Map<String, String> map = new HashMap<String, String>();
        us.create(um);
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Map<String, String> update(@RequestBody UserModel mm) {
        Map<String, String> map = new HashMap<String, String>();
        String msg = us.update(mm) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }

    @RequestMapping(value = { "/" }, method = RequestMethod.DELETE)
    public Map<String, String> delete(@RequestBody UserModel mm) {
        Map<String, String> map = new HashMap<String, String>();
        String msg = us.delete(mm) ? "success" : "fail";
        map.put("message", msg);
        return map;
    }
}