package com.example.shopping_platform_II.service.ifs;

import com.example.shopping_platform_II.vo.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface UserService {
    public RegisterResponse register (RegisterRequest request);
    public LoginResponse active (LoginRequest request);
    public LoginResponse login (LoginRequest request);
    public UpdateResponse updatePwd (HttpSession session ,UpdateRequest request);
    public UpdateResponse updateName(HttpSession session ,UpdateRequest request);
    public UpdateResponse updateAddress(HttpSession session ,UpdateRequest request);
    public UpdateResponse updatePhone(HttpSession session ,UpdateRequest request);
    public LoginResponse logout (HttpSession session);
    public GetUserResponse getUserInfoGetUserResponse (HttpSession session);

    public RegisterResponse addUserImg(HttpSession session, AddImageRequest request) throws IOException;
}
