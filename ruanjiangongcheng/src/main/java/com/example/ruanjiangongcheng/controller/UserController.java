package com.example.ruanjiangongcheng.controller;

import com.example.ruanjiangongcheng.entity.UserInfo;
import com.example.ruanjiangongcheng.service.IUserService;
import com.example.ruanjiangongcheng.service.impl.UserService;
import com.example.ruanjiangongcheng.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    @GetMapping
    public JsonResult<UserInfo> userLogin(UserInfo user) {
        UserInfo loginUser=userService.userLogin(user);
        return new JsonResult<>(Ok,loginUser);
    }
    @PostMapping
    public JsonResult<Void> userRegister(UserInfo user){
        userService.userRegister(user);
        return new JsonResult<>(Ok);
    }


}
