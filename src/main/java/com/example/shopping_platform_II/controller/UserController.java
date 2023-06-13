package com.example.shopping_platform_II.controller;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.service.ifs.UserService;
import com.example.shopping_platform_II.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "register")
	public RegisterResponse register(@RequestBody RegisterRequest request) {
		return userService.register(request);
	}

	@PostMapping(value = "active")
	public LoginResponse active(@RequestBody LoginRequest request) {
		return userService.active(request);
	}



    @PostMapping(value = "update_session_interval")
    public void updateSessionInterval(HttpSession session){
        session.setMaxInactiveInterval(1800);
    }

	@PostMapping(value = "login")
	public LoginResponse login(@RequestBody LoginRequest request, HttpSession session) {
		LoginResponse result = userService.login(request);
		if (result.getMessage().equalsIgnoreCase(RtnCode.SUCCESSFUL.getMessage())) {
			double random = Math.random() * 10000;
			int verifyCode = (int) Math.round(random);// round四捨五入
			session.setAttribute("verifyCode", verifyCode);
			session.setAttribute("account", request.getAccount());
			session.setAttribute("pwd", request.getPwd());
			session.setMaxInactiveInterval(6000);// 設定session存活時間 單位:秒
			result.setSessionId(session.getId());
			result.setVerifyCode(verifyCode);

		}
		return result;
	}

	@PostMapping(value = "update_Pwd")
	public UpdateResponse updatePwd(@RequestBody UpdateRequest request, HttpSession session) {
		return userService.updatePwd(session, request);
	}

	@PostMapping(value = "update_name")
	public UpdateResponse updateName(@RequestBody UpdateRequest request, HttpSession session) {
		return userService.updateName(session, request);
	}

	@PostMapping(value = "update_address")
	public UpdateResponse updateAddress(HttpSession session, @RequestBody UpdateRequest request) {
		return userService.updateAddress(session, request);
	}

	@PostMapping(value = "update_phone")
	public UpdateResponse updatePhone(HttpSession session, @RequestBody UpdateRequest request) {
		return userService.updatePhone(session, request);
	}

	@PostMapping(value = "log_out")
	public LoginResponse logOut(HttpSession session) {

		return userService.logout(session);
	}

	@PostMapping(value = "get_user_info")
	public GetUserResponse getUserInfoGetUserResponse(HttpSession session) {
		return userService.getUserInfoGetUserResponse(session);
	}
}
