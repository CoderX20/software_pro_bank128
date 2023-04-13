package com.example.ruanjiangongcheng.service.impl;

import com.example.ruanjiangongcheng.entity.dingqibiao;
import com.example.ruanjiangongcheng.mapper.dingqiMapper;
import com.example.ruanjiangongcheng.service.IDingqiService;
import com.example.ruanjiangongcheng.service.exception.ChuXuNullException;
import com.example.ruanjiangongcheng.service.exception.InsertException;
import com.example.ruanjiangongcheng.service.exception.NotYetDueException;
import com.example.ruanjiangongcheng.service.exception.deleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DingqiService implements IDingqiService {
    @Autowired(required = false)
    private dingqiMapper dingqimapper;
    @Override
    public List<dingqibiao> getAll(String card_number) {
        List<dingqibiao> lst_dingqi = dingqimapper.selectAllDingqi(card_number);
        if(lst_dingqi.size()==0){
            throw new ChuXuNullException("该账户没有定期储蓄");
        }
        return lst_dingqi;
    }

    @Override
    public dingqibiao getOne(int id) {
        dingqibiao dq = dingqimapper.selectOneByID(id);

        return dq;
    }

    @Override
    public int createNew(dingqibiao dq) {
        String period = dq.getPeriod();
        switch (period){
            case "3个月":
                dq.setRate(0.0003f);
                break;
            case "6个月":
                dq.setRate(0.0006f);
                break;
            case "1年":
                dq.setRate(0.001f);
                break;
            case "3年":
                dq.setRate(0.003f);
                break;
            case "5年":
                dq.setRate(0.005f);
                break;
            default:
                dq.setRate(0f);
                break;
        }
        int result = dingqimapper.insertNewDingqi(dq);
        if(result==0){
            throw new InsertException("定期存款失败");

        }
        return result;
    }

    @Override
    public int deleteOne(int id) {
        dingqibiao dq = dingqimapper.selectOneByID(id);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dq.getCreate_time());
        String period = dq.getPeriod();
        switch (period){
            case "3个月":
               rightNow.add(Calendar.MONTH,3);
                break;
            case "6个月":
                rightNow.add(Calendar.MONTH,6);
                break;
            case "1年":
                rightNow.add(Calendar.YEAR,1);
                break;
            case "3年":
                rightNow.add(Calendar.YEAR,3);
                break;
            case "5年":
                rightNow.add(Calendar.YEAR,5);
                break;
            default:
                break;
        }
        Date resultTime = rightNow.getTime();
        if(!new Date().after(resultTime)){
            throw new NotYetDueException("储蓄还未到期");
        }
        int result = dingqimapper.deleteDingqi(id);
        if(result==0){
            throw new deleteException("删除失败");
        }
        return result;
    }
}
