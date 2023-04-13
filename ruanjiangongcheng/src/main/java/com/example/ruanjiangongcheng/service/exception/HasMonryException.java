package com.example.ruanjiangongcheng.service.exception;

public class HasMonryException extends ServiceException{
    public HasMonryException(){super();}
    public HasMonryException(String message){
        super(message);
    }
    public HasMonryException(String message,Throwable cause){
        super(message,cause);
    }
    public HasMonryException(Throwable cause){
        super(cause);
    }
    public HasMonryException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
