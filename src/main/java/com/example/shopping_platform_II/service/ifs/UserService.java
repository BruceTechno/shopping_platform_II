package com.example.shopping_platform_II.service.ifs;

import com.example.shopping_platform_II.vo.*;

public interface UserService {
    public RegisterResponse register (RegisterRequest request);
    public LoginResponse active (LoginRequest request);
    public LoginResponse login (LoginRequest request);
    public UpdateResponse updatePwd (UpdateRequest request);
    public UpdateResponse updateName(UpdateRequest request);
    public UpdateResponse updateAddress(UpdateRequest request);
    public UpdateResponse updatePhone(UpdateRequest request);

}
