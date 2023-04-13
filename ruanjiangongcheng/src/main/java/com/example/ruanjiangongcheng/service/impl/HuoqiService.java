package com.example.ruanjiangongcheng.service.impl;

import com.example.ruanjiangongcheng.entity.huoqibiao;
import com.example.ruanjiangongcheng.mapper.huoqiMapper;
import com.example.ruanjiangongcheng.service.IHuoqiService;
import com.example.ruanjiangongcheng.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HuoqiService implements IHuoqiService {
    @Autowired(required = false)
    private huoqiMapper huoqimapper;
    @Override
    public int deposit(double money, int id) {
        huoqibiao hq=huoqimapper.selectOneByID(id);
        double restMoney=hq.getMoney();
        restMoney=restMoney+money;
        hq.setMoney(restMoney);
        hq.setLast_time(new Date());
        int result = huoqimapper.updateHuoqi(hq);
        if(result==0){
            throw new UpdateException("存款失败");
        }
        return result;
    }

    @Override
    public int withdrawal(double money, int id) {
        huoqibiao hq=huoqimapper.selectOneByID(id);
        double restMoney=hq.getMoney();
        if(restMoney<money){
            throw new MoneyNotEnoughException("余额不足");
        }
        restMoney=restMoney-money;
        hq.setMoney(restMoney);
        hq.setLast_time(new Date());
        int result = huoqimapper.updateHuoqi(hq);
        if(result==0){
            throw new UpdateException("存款失败");
        }
        return result;
    }

    @Override
    public int createNewHuoqi(String card_number, double money) {
        Map params = new HashMap<>();
        params.put("card_number",card_number);
        params.put("create_time",new Date());
        params.put("money",money);
        params.put("last_time",new Date());
        int result = huoqimapper.insertNewHuoqi(params);
        return result;
    }

    @Override
    public int deleteHuoqi(int id) {
        huoqibiao hq=huoqimapper.selectOneByID(id);
        if(hq.getMoney()>0) {
            throw new HasMonryException("账户还有余额，不能删除");
        }
        int result = huoqimapper.deleteHuoqi(id);
        if(result==0){
            throw new deleteException("删除错误");
        }
        return result;
    }

    @Override
    public List<huoqibiao> getAllHuoqi(String card_number) {
        List<huoqibiao> lst_huoqi = huoqimapper.selectAllByCardNumber(card_number);
        if(lst_huoqi.size()==0){
            throw new ChuXuNullException("该账户当前没有活期储蓄");
        }
        return lst_huoqi;
    }
}
