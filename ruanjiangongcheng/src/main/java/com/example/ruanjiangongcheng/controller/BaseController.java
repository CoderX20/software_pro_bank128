package com.example.ruanjiangongcheng.controller;

import com.example.ruanjiangongcheng.service.exception.*;
import com.example.ruanjiangongcheng.utils.JsonResult;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.bind.ValidationException;

public class BaseController {
    public static final int Ok=200;
    @ExceptionHandler({ServiceException.class, FileUploadException.class, ValidationException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result=new JsonResult<>(e);
        if(e instanceof UserDuplicateException){
            result.setStatus(4000);//表示用户已被注册
        }else if (e instanceof InsertException){
            result.setStatus(5001);//表示数据库插入用户出现问题
        }else if (e instanceof UserNotExistException){
            result.setStatus(5002);//表示用户不存在
        }else if (e instanceof deleteException){
            result.setStatus(5004);//表示删除错误
        }else if (e instanceof ChuXuNullException){
            result.setStatus(5005);//表示该账户活期储蓄为空
        }else if (e instanceof MoneyNotEnoughException){
            result.setStatus(5006);//表示余额不够
        }else if (e instanceof WrongPasswordException){
            result.setStatus(5007);//表示输入密码出现错误
        }else if (e instanceof UpdateException){
            result.setStatus(5008);//表示更新错误
        }else if (e instanceof HasMonryException){
            result.setStatus(5009);//表示账户还有余额，不能删除
        } else if (e instanceof  NotYetDueException) {
            result.setStatus(5010);//表示定期用户的储蓄还未到期
        }
        return result;
    }
}
