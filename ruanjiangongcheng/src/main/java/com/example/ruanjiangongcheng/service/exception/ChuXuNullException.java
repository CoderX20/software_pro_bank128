package com.example.ruanjiangongcheng.service.exception;

public class ChuXuNullException extends ServiceException{
    public ChuXuNullException(){super();}
    public ChuXuNullException(String message){
        super(message);
    }
    public ChuXuNullException(String message,Throwable cause){
        super(message,cause);
    }
    public ChuXuNullException(Throwable cause){
        super(cause);
    }
    public ChuXuNullException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
