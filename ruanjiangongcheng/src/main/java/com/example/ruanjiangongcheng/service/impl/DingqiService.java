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

    //根据身份证号获取该账户下所有的定期信息
    @Override
    public List<dingqibiao> getAll(String card_number) {
        //从数据库中获取到所有的定期信息
        List<dingqibiao> lst_dingqi = dingqimapper.selectAllDingqi(card_number);
        //如果没有返回的数据
        if(lst_dingqi.size()==0){
            throw new ChuXuNullException("该账户没有定期储蓄");
        }
        //返回查询到的数据
        return lst_dingqi;
    }

    @Override
    public dingqibiao getOne(int id) {
        //根据ID找到唯一的定期储蓄信息
        dingqibiao dq = dingqimapper.selectOneByID(id);
        return dq;
    }

    //根据传过来的信息创建新的定期储蓄
    @Override
    public int createNew(dingqibiao dq) {
        //获取到存款的时间，用于得到存款的利率
        String period = dq.getPeriod();
        //根据不同的存款时间来得到不同的利率
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
        dq.setCreate_time(new Date());
        //向数据库中插入新的定期储蓄信息，返回值为1时，表示插入成功，为0时，表示插入失败
        int result = dingqimapper.insertNewDingqi(dq);
        if(result==0){
            throw new InsertException("定期存款失败");

        }
        //返回结果
        return result;
    }

    //删除定期账户
    @Override
    public int deleteOne(int id) {
        //根据id获取到对应的定期信息
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
        //判断定期储蓄信息的到期时间，如果还没到期，就不能删除账户
        if(!new Date().after(resultTime)){
            throw new NotYetDueException("储蓄还未到期");
        }
        //如果到期了，就删除数据库中的储蓄信息，返回值为1时表示成功，为0时表示失败
        int result = dingqimapper.deleteDingqi(id);
        if(result==0){
            throw new deleteException("删除失败");
        }
        return result;
    }
}
