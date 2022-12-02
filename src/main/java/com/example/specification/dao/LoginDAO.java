package com.example.specification.dao;

import com.example.specification.login.dto.LoginReq;
import com.example.specification.login.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDAO {

    public UserVO getUserInfo(LoginReq loginReq);
    public int updateUserLogin(UserVO user);
}
