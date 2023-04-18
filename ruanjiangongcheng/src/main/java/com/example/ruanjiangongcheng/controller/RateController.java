package com.example.ruanjiangongcheng.controller;

import com.example.ruanjiangongcheng.entity.huoqibiao;
import com.example.ruanjiangongcheng.entity.rate;
import com.example.ruanjiangongcheng.mapper.rateMapper;
import com.example.ruanjiangongcheng.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("rate")
@Api(tags = "利率操作")
public class RateController extends BaseController{
    @Autowired(required = false)
    private rateMapper rt;

    @GetMapping("getAll")
    @ApiOperation("获取所有利率")
    public JsonResult<List<rate>> getAllRate(){
        List<rate> lst_rate = rt.selectAllRate();
        return new JsonResult<>(Ok,lst_rate);
    }
    @PostMapping("update")
    @ApiOperation("修改利率")
    public JsonResult<String> updateRate(rate rat){

        int result = rt.updateRate(rat);
        if(result!=1){
            return new JsonResult<>(5010,"更新失败");
        }else{
            return new JsonResult<>(Ok,"更新成功");
        }
    }

}
