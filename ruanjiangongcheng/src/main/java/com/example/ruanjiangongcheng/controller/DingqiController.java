package com.example.ruanjiangongcheng.controller;

import com.example.ruanjiangongcheng.entity.dingqibiao;
import com.example.ruanjiangongcheng.service.IDingqiService;
import com.example.ruanjiangongcheng.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("dingqi")
@Api(tags = "定期操作")

public class DingqiController extends BaseController{
    @Autowired()
    private IDingqiService dingqiService;

    @GetMapping("getAll")
    @ApiOperation("获取到账户下所有的定期")

    public JsonResult<List<dingqibiao>> getAll(String card_number){
        List<dingqibiao> lst_dingqi = dingqiService.getAll(card_number);
        return new JsonResult<>(Ok,lst_dingqi);
    }
    @GetMapping("getOne")
    @ApiOperation("获取到账户下某一个定期")

    public JsonResult<dingqibiao> getOne(int id){
        dingqibiao dq = dingqiService.getOne(id);
        return new JsonResult<>(Ok,dq);
    }
    @PostMapping("create")
    @ApiOperation("创建一个定期")

    public JsonResult<Void> create(dingqibiao dq){
        int result = dingqiService.createNew(dq);
        return new JsonResult<>(Ok);
    }
    @PostMapping("delete")
    @ApiOperation("删除定期")

    public JsonResult<Void> delete(int id){
        int result = dingqiService.deleteOne(id);
        return new JsonResult<>(Ok);
    }
}
