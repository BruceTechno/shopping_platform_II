package com.example.shopping_platform_II.service.impl;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.User;
import com.example.shopping_platform_II.repository.UserDao;
import com.example.shopping_platform_II.service.ifs.UserService;
import com.example.shopping_platform_II.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public RegisterResponse register(RegisterRequest request) {//todo ++ account & pwd 正規
        String account = request.getAccount();//todo 資料會一次新增兩筆
        String pwd = request.getPwd();
        String name = request.getName();
        String phone = request.getPhone();
        String address = request.getAddress();
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || !StringUtils.hasText(name) ||
                !StringUtils.hasText(phone) || !StringUtils.hasText(address)) {
            return new RegisterResponse(RtnCode.DATA_ERROR.getMessage());
        }
            int result = userDao.insertUserInfoWhereNotExists(account, pwd, name, address, phone);

            if (result == 0) {
                return new RegisterResponse(RtnCode.DATA_DUPLICATE.getMessage());
            }
            if (result == 1) {
                User userResult = new User(account, pwd, name, address, phone);
                userDao.save(userResult);
            }
            return new RegisterResponse(RtnCode.SUCCESSFUL.getMessage());
        }

    @Override
    public LoginResponse active(LoginRequest request) {
        String account = request.getAccount();
        String pwd = request.getPwd();
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)){
            return new LoginResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        User result = userDao.findByAccountAndPwd(account, pwd);
        if (result == null){
            return new LoginResponse(RtnCode.NOT_FOUND.getMessage());
        }
        result.setActive(true);
        userDao.save(result);
        return new LoginResponse(RtnCode.SUCCESSFUL.getMessage(),result);
    }

    @Override
    public LoginResponse login(LoginRequest request) {//todo ++ Session

        String account = request.getAccount();
        String pwd = request.getPwd();

        User result = userDao.findByAccountAndPwdAndActive(account, pwd, true);
        if (result == null){
            return new LoginResponse(RtnCode.DATA_ERROR.getMessage());//登入失敗或未激活
        }
        return new LoginResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public UpdateResponse updatePwd(UpdateRequest request) {
        String account = request.getAccount();
        String pwd = request.getPwd();
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) ){
            return new UpdateResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
    if (userDao.existsByAccount(account)){
      userDao.updatePwdByAccount(account,pwd);
        return new UpdateResponse("test succelslasdfuly");
    }else {
        return new UpdateResponse(RtnCode.NOT_FOUND.getMessage());
    }



    }

    @Override
    public UpdateResponse updateName(UpdateRequest request) {
        return null;
    }

    @Override
    public UpdateResponse updateAddress(UpdateRequest request) {
        return null;
    }

    @Override
    public UpdateResponse updatePhone(UpdateRequest request) {
        return null;
    }
}

