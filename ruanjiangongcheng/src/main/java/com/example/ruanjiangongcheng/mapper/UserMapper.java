package com.example.ruanjiangongcheng.mapper;

import com.example.ruanjiangongcheng.entity.UserInfo;

public interface UserMapper {
    UserInfo selectOneByCardNumber(String cardNumber);
    int addUser(UserInfo user);
}
