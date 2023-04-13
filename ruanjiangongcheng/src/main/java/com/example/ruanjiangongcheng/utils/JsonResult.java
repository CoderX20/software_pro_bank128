package com.example.ruanjiangongcheng.utils;
//相应数据
public class JsonResult<E>{
    private int status;
    private String message;
    private E data;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(E data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public E getData() {
        return data;
    }

    public JsonResult(){}
    public JsonResult(int status){
        this.status=status;
    }
    public JsonResult(Throwable e){
        this.message=e.getMessage();
    }
    public JsonResult(int status,E data){
        this.status=status;
        this.data=data;
    }
}
