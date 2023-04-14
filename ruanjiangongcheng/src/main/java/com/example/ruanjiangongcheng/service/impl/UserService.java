package com.example.ruanjiangongcheng.service.impl;

import com.example.ruanjiangongcheng.entity.UserInfo;
import com.example.ruanjiangongcheng.mapper.UserMapper;
import com.example.ruanjiangongcheng.service.IUserService;
import com.example.ruanjiangongcheng.service.exception.InsertException;
import com.example.ruanjiangongcheng.service.exception.UserDuplicateException;
import com.example.ruanjiangongcheng.service.exception.UserNotExistException;
import com.example.ruanjiangongcheng.service.exception.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Override
    public UserInfo userLogin(UserInfo user) {
        System.out.println(user);
        //获取到传入参数中的身份证号和密码
        String cardNumber=user.getCard_number();
        String password=user.getPassword();
        //用传入的身份证号在数据库中查询对应的用户信息
        UserInfo userInfo=userMapper.selectOneByCardNumber(cardNumber);
        //查询为空则说明数据库中没有该用户
        if(userInfo==null){
            throw new UserNotExistException("该用户不存在");
        }
        //查询出的用户信息的密码与输入的密码不一致

        if(!userInfo.getPassword().equals(password)){
            throw new WrongPasswordException("密码错误");
        }
        //返回查询到的用户信息
        return userInfo;
    }

    @Override
    public void userRegister(UserInfo user) {
        //先判断传入和数据在数据库中是否已经存在
        UserInfo userInfo=userMapper.selectOneByCardNumber(user.getCard_number());
        //如果存在就抛出异常
        if(userInfo!=null){
            throw new UserDuplicateException("用户已被注册");
        }
        //否则将传入的数据存储到数据库中
        int result=userMapper.addUser(user);
        //由于数据库操作或服务器可能会出现异常，所以根据返回值来进行判断操作是否成功，如果返回值为1则说明数据存储成功
        if(result==0){
            throw new InsertException("注册失败");
        }
    }
}
