package com.example.ruanjiangongcheng.controller;

import com.example.ruanjiangongcheng.entity.huoqibiao;
import com.example.ruanjiangongcheng.service.IHuoqiService;
import com.example.ruanjiangongcheng.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("huoqi")
@Api(tags = "活期操作")
public class HuoqiController extends BaseController{
    @Autowired
    private IHuoqiService huoqiService;

    @GetMapping("getAll")
    @ApiOperation("获取到账户下所有的活期")
    public JsonResult<List<huoqibiao>> getAllHuoqi(String card_number){
        List<huoqibiao> lst_huoqi = huoqiService.getAllHuoqi(card_number);
        return new JsonResult<>(Ok,lst_huoqi);

    }
    @PostMapping("deposit")
    @ApiOperation("存款操作")

    public JsonResult<Void> deposit(int id ,double money){
        huoqiService.deposit(money,id);
        return new JsonResult<>(Ok);

    }
    @PostMapping("withdrawal")
    @ApiOperation("取款操作")

    public JsonResult<Void> withdrawal(int id ,double money){
        huoqiService.withdrawal(money,id);
        return new JsonResult<>(Ok);

    }
    @PostMapping("createNew")
    @ApiOperation("创建新的活期")

    public JsonResult<Void> createNew(String cardNumber ,double money){
        huoqiService.createNewHuoqi(cardNumber,money);
        return new JsonResult<>(Ok);

    }
    @PostMapping("delete")
    @ApiOperation("删除活期")

    public JsonResult<Void> delete(int id){
        huoqiService.deleteHuoqi(id);
        return new JsonResult<>(Ok);

    }

}
