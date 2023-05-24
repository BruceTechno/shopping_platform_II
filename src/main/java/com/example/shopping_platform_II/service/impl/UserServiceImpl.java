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
    public RegisterResponse register(RegisterRequest request) {//todo ++ account & pwd 正規 done
        String account = request.getAccount();//todo 資料會一次新增兩筆 done
        String pwd = request.getPwd();
        String name = request.getName();
        String phone = request.getPhone();
        String address = request.getAddress();
        String patternPwd = "^(?=.+[\\p{Punct}])(?!.*[\\s\\t\\r\\n\\f])[\\p{Print}]{8,12}$";//8~12碼 至少包含一個特殊符號
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || !StringUtils.hasText(name) ||
                !StringUtils.hasText(phone) || !StringUtils.hasText(address)) {
            return new RegisterResponse(RtnCode.DATA_ERROR.getMessage());
        }
        if(!phone.matches("[0-9]{4}-[0-9]{6}") || !pwd.matches(patternPwd)){
            return new RegisterResponse(RtnCode.DATA_ERROR.getMessage());
        }

        int result = userDao.insertUserInfoWhereNotExists(account, pwd, name, address, phone);

        if (result == 0) {
            return new RegisterResponse(RtnCode.DATA_DUPLICATE.getMessage());
        }
        return new RegisterResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public LoginResponse active(LoginRequest request) {
        String account = request.getAccount();
        String pwd = request.getPwd();
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new LoginResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        User result = userDao.findByAccountAndPwd(account, pwd);
        if (result == null) {
            return new LoginResponse(RtnCode.NOT_FOUND.getMessage());
        }
        result.setActive(true);
        userDao.save(result);
        return new LoginResponse(RtnCode.SUCCESSFUL.getMessage(), result);
    }

    @Override
    public LoginResponse login(LoginRequest request) {//todo ++ Session done

        String account = request.getAccount();
        String pwd = request.getPwd();

        User result = userDao.findByAccountAndPwdAndActive(account, pwd, true);
        if (result == null) {
            return new LoginResponse(RtnCode.DATA_ERROR.getMessage());//登入失敗或未激活
        }
        return new LoginResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public UpdateResponse updatePwd(UpdateRequest request) {//todo updatePwd要符合正規才能update done
        String account = request.getAccount();
        String pwd = request.getPwd();
        String patternPwd = "^(?=.+[\\p{Punct}])(?!.*[\\s\\t\\r\\n\\f])[\\p{Print}]{8,12}$";//8~12碼 至少包含一個特殊符號

        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new UpdateResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        if(!pwd.matches(patternPwd)){
            return new UpdateResponse(RtnCode.DATA_ERROR.getMessage());
        }
        int result = userDao.updatePwdByAccount(pwd, account);
        if (result == 0) {
            return new UpdateResponse(RtnCode.DATA_ERROR.getMessage());
        }
        return new UpdateResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public UpdateResponse updateName(UpdateRequest request) {//todo name符合正規才能update
        String account = request.getAccount();
        String name = request.getName();
        if (!StringUtils.hasText(account) || !StringUtils.hasText(name)) {
            return new UpdateResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        int result = userDao.updateNameByAccount(name, account);
        if (result == 0) {
            return new UpdateResponse(RtnCode.DATA_ERROR.getMessage());
        }
        return new UpdateResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public UpdateResponse updateAddress(UpdateRequest request) {
        String account = request.getAccount();
        String address = request.getAddress();
        if (!StringUtils.hasText(account) || !StringUtils.hasText(address)) {
            return new UpdateResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        int result = userDao.updateAddressByAccount(address, account);
        if (result == 0) {
            return new UpdateResponse(RtnCode.DATA_ERROR.getMessage());
        }
        return new UpdateResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public UpdateResponse updatePhone(UpdateRequest request) {//todo phone符合正規才能update done
        String account = request.getAccount();
        String phone = request.getPhone();

        if (!StringUtils.hasText(account) || !StringUtils.hasText(phone)) {
            return new UpdateResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        if(!phone.matches("[0-9]{4}-[0-9]{6}")){
            return new UpdateResponse(RtnCode.DATA_ERROR.getMessage());
        }
        int result = userDao.updateAddressByAccount(phone, account);
        if (result == 0) {
            return new UpdateResponse(RtnCode.DATA_ERROR.getMessage());
        }
        return new UpdateResponse(RtnCode.SUCCESSFUL.getMessage());
    }
}

