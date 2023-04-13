package com.example.ruanjiangongcheng.controller;

import com.example.ruanjiangongcheng.entity.dingqibiao;
import com.example.ruanjiangongcheng.service.IDingqiService;
import com.example.ruanjiangongcheng.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dingqi")
public class DingqiController extends BaseController{
    @Autowired()
    private IDingqiService dingqiService;

    @GetMapping("getAll")
    public JsonResult<List<dingqibiao>> getAll(String card_number){
        List<dingqibiao> lst_dingqi = dingqiService.getAll(card_number);
        return new JsonResult<>(Ok,lst_dingqi);
    }
    @GetMapping("getOne")
    public JsonResult<dingqibiao> getOne(int id){
        dingqibiao dq = dingqiService.getOne(id);
        return new JsonResult<>(Ok,dq);
    }
    @PostMapping("create")
    public JsonResult<Void> create(dingqibiao dq){
        int result = dingqiService.createNew(dq);
        return new JsonResult<>(Ok);
    }
    @PostMapping("delete")
    public JsonResult<Void> delete(int id){
        int result = dingqiService.deleteOne(id);
        return new JsonResult<>(Ok);
    }
}
