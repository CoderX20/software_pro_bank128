package com.example.ruanjiangongcheng.service.exception;

public class MoneyNotEnoughException extends ServiceException{
    public MoneyNotEnoughException(){super();}
    public MoneyNotEnoughException(String message){
        super(message);
    }
    public MoneyNotEnoughException(String message,Throwable cause){
        super(message,cause);
    }
    public MoneyNotEnoughException(Throwable cause){
        super(cause);
    }
    public MoneyNotEnoughException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
