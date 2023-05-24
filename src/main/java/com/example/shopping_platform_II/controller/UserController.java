package com.example.shopping_platform_II.controller;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.service.ifs.UserService;
import com.example.shopping_platform_II.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "register")
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }
    @PostMapping(value = "active")
    public LoginResponse active(@RequestBody LoginRequest request){
        return userService.active(request);
    }
    @PostMapping(value = "login")
    public LoginResponse login(@RequestBody LoginRequest request , HttpSession session){
        LoginResponse result = userService.login(request);
        if (result.getMessage().equalsIgnoreCase(RtnCode.SUCCESSFUL.getMessage())){
            double random = Math.random() * 10000;
            int verifyCode = (int) Math.round(random);//round四捨五入
            session.setAttribute("verifyCode", verifyCode);
            session.setAttribute("account", request.getAccount());
            session.setAttribute("pwd",request.getPwd());
            session.setMaxInactiveInterval(60);//設定session存活時間 單位:秒
            result.setSessionId(session.getId());
            result.setVerifyCode(verifyCode);
        }
        return result;
    }
    @PostMapping(value = "update Pwd")
    public UpdateResponse updatePwd(@RequestBody  UpdateRequest request){
        return userService.updatePwd(request);
    }
    @PostMapping(value = "update name")
    public UpdateResponse updateName(@RequestBody UpdateRequest request){
        return userService.updateName(request);
    }
    @PostMapping(value = "update address")
    public UpdateResponse updateAddress(@RequestBody UpdateRequest request){
        return userService.updateAddress(request);
    }
    @PostMapping(value = "update phone")
    public UpdateResponse updatePhone(@RequestBody UpdateRequest request){
        return userService.updatePhone(request);
    }
}
