package com.example.ruanjiangongcheng.service;

import com.example.ruanjiangongcheng.entity.UserInfo;

public interface IUserService {
//    处理用户登录服务
    UserInfo userLogin(UserInfo user);
//    处理用户注册服务
    void userRegister(UserInfo user);
}
