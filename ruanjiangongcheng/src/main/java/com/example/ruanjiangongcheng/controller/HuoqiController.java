package com.example.ruanjiangongcheng.controller;

import com.example.ruanjiangongcheng.entity.huoqibiao;
import com.example.ruanjiangongcheng.service.IHuoqiService;
import com.example.ruanjiangongcheng.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("huoqi")
public class HuoqiController extends BaseController{
    @Autowired
    private IHuoqiService huoqiService;

    @GetMapping("getAll")
    public JsonResult<List<huoqibiao>> getAllHuoqi(String card_number){
        List<huoqibiao> lst_huoqi = huoqiService.getAllHuoqi(card_number);
        return new JsonResult<>(Ok,lst_huoqi);

    }
    @PostMapping("deposit")
    public JsonResult<Void> deposit(int id ,double money){
        huoqiService.deposit(money,id);
        return new JsonResult<>(Ok);

    }
    @PostMapping("withdrawal")
    public JsonResult<Void> withdrawal(int id ,double money){
        huoqiService.withdrawal(money,id);
        return new JsonResult<>(Ok);

    }
    @PostMapping("createNew")
    public JsonResult<Void> createNew(String cardNumber ,double money){
        huoqiService.createNewHuoqi(cardNumber,money);
        return new JsonResult<>(Ok);

    }
    @PostMapping("delete")
    public JsonResult<Void> delete(int id){
        huoqiService.deleteHuoqi(id);
        return new JsonResult<>(Ok);

    }

}
