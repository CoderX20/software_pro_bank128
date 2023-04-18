package com.example.ruanjiangongcheng.controller;

import com.example.ruanjiangongcheng.entity.huoqibiao;
import com.example.ruanjiangongcheng.entity.retuen.huoqi;
import com.example.ruanjiangongcheng.service.IHuoqiService;
import com.example.ruanjiangongcheng.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("huoqi")
@Api(tags = "活期操作")
public class HuoqiController extends BaseController{
    @Autowired
    private IHuoqiService huoqiService;

    @GetMapping("getAll")
    @ApiOperation("获取到账户下所有的活期")
    public JsonResult<List<huoqi>> getAllHuoqi(String card_number){
        List<huoqi> lst_huoqi = huoqiService.getAllHuoqi(card_number);
        return new JsonResult<>(Ok,lst_huoqi);

    }

    @GetMapping("getOne")
    @ApiOperation("获取到账户下某一个活期")
    public JsonResult<huoqi> getOneHuoqi(Integer id){
        huoqi hq = huoqiService.getOneHuoqi(id);
        return new JsonResult<>(Ok,hq);

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
