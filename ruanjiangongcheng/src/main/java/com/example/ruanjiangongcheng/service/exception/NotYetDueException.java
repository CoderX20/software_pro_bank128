package com.example.ruanjiangongcheng.service.exception;

public class NotYetDueException extends ServiceException{
    public NotYetDueException(){super();}
    public NotYetDueException(String message){
        super(message);
    }
    public NotYetDueException(String message,Throwable cause){
        super(message,cause);
    }
    public NotYetDueException(Throwable cause){
        super(cause);
    }
    public NotYetDueException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
