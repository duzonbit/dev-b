package app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("origin-allowed=*")
@RequestMapping(value="/auth")
public class AuthController {
    //로그인 회원가입
}