package com.example.ruanjiangongcheng.service.impl;

import com.example.ruanjiangongcheng.entity.huoqibiao;
import com.example.ruanjiangongcheng.entity.retuen.huoqi;
import com.example.ruanjiangongcheng.mapper.huoqiMapper;
import com.example.ruanjiangongcheng.mapper.rateMapper;
import com.example.ruanjiangongcheng.service.IHuoqiService;
import com.example.ruanjiangongcheng.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class HuoqiService implements IHuoqiService {
    @Autowired(required = false)
    private huoqiMapper huoqimapper;
    @Autowired(required = false)
    private rateMapper rt;

    //存款
    @Override
    public int deposit(double money, int id) {
        //根据ID获取到活期储蓄信息
        huoqibiao hq=huoqimapper.selectOneByID(id);
        //将该储蓄信息的金额加上要存入的金额
        double restMoney=hq.getMoney();
        restMoney=restMoney+money;
        hq.setMoney(restMoney);
        hq.setLast_time(new Date());
        //将新的活期储蓄信息保存到数据库中
        int result = huoqimapper.updateHuoqi(hq);
        if(result==0){
            throw new UpdateException("存款失败");
        }
        return result;
    }

    //取款
    @Override
    public int withdrawal(double money, int id) {

        huoqibiao hq=huoqimapper.selectOneByID(id);
        double restMoney=hq.getMoney();
        //将储蓄信息的余额与要取的金额进行比较，如果要取的金额大于余额，则提示余额不足，否则就可以进行取款
        if(restMoney<money){
            throw new MoneyNotEnoughException("余额不足");
        }
        //修改储蓄信息
        restMoney=restMoney-money;
        hq.setMoney(restMoney);
        hq.setLast_time(new Date());
        //将修改的储蓄信息保存到数据库中，返回值：0代表失败，1代表成功
        int result = huoqimapper.updateHuoqi(hq);
        if(result==0){
            throw new UpdateException("存款失败");
        }
        return result;
    }

    //创建新的活期储蓄
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

    //删除活期储蓄
    @Override
    public int deleteHuoqi(int id) {
        //在数据库中找到要删除的储蓄信息
        huoqibiao hq=huoqimapper.selectOneByID(id);
        //若该储蓄信息上还有余额，则不能删除，提示账户还有余额，不能删除，否则就可以进行删除
        if(hq.getMoney()>0) {
            throw new HasMonryException("账户还有余额，不能删除");
        }
        //进行储蓄信息的删除，返回值：0代表失败，1代表成功
        int result = huoqimapper.deleteHuoqi(id);
        if(result==0){
            throw new deleteException("删除错误");
        }
        return result;
    }

    //根据身份证号获取到该账户下所有的活期信息
    @Override
    public List<huoqi> getAllHuoqi(String card_number) {
        //在数据库中找到该账户下的所有活期信息
        List<huoqibiao> lst_huoqi = huoqimapper.selectAllByCardNumber(card_number);
        //如果没有活期信息，就提示  该账户下没有活期储蓄
        if(lst_huoqi.size()==0){
            throw new ChuXuNullException("该账户当前没有活期储蓄");
        }
        Double r=rt.selectRateByType("活期");
        List<huoqi> lst_hq=new ArrayList<>();
        for (huoqibiao hq:lst_huoqi ) {
            huoqi hqq=new huoqi(hq.getId(),hq.getCard_number(),hq.getCreate_time(),hq.getMoney(),hq.getLast_time(),r);
            lst_hq.add(hqq);
        }
        return lst_hq;
    }

    @Override
    public huoqi getOneHuoqi(Integer id) {
        huoqibiao hq=huoqimapper.selectOneByID(id);
        Double r = rt.selectRateByType("活期");
        return new huoqi(hq.getId(),hq.getCard_number(),hq.getCreate_time(),hq.getMoney(),hq.getLast_time(),r);
    }
}
