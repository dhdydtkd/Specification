package com.example.specification.login.service;

import com.example.specification.dao.LoginDAO;
import com.example.specification.login.dto.LoginReq;
import com.example.specification.login.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginService {
    @Autowired
    private LoginDAO loginDAO;

    public UserVO getUserInfo(LoginReq loginReq){
        UserVO user = loginDAO.getUserInfo(loginReq);
        if(user == null){
            return null;
        }else{
            loginDAO.updateUserLogin(user);
            return user;
        }

    }
}
