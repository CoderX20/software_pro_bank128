package com.example.ruanjiangongcheng.controller;

import com.example.ruanjiangongcheng.entity.UserInfo;
import com.example.ruanjiangongcheng.service.IUserService;
import com.example.ruanjiangongcheng.service.impl.UserService;
import com.example.ruanjiangongcheng.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("user")
@Api(tags = "用户操作")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    @GetMapping
    @ApiOperation("登录服务")
    public JsonResult<UserInfo> userLogin(UserInfo user) {
        UserInfo loginUser=userService.userLogin(user);
        return new JsonResult<>(Ok,loginUser);
    }
    @PostMapping
    @ApiOperation("注册服务")
    public JsonResult<Void> userRegister(UserInfo user){
        userService.userRegister(user);
        return new JsonResult<>(Ok);
    }


}
