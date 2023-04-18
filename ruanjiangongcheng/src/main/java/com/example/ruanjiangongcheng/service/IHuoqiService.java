package com.example.ruanjiangongcheng.service;

import com.example.ruanjiangongcheng.entity.huoqibiao;
import com.example.ruanjiangongcheng.entity.retuen.huoqi;

import java.util.List;

public interface IHuoqiService {
    int deposit(double money,int id);
    int withdrawal(double money,int id);
    int createNewHuoqi(String card_number,double money);
    int deleteHuoqi(int id);
    List<huoqi> getAllHuoqi(String card_number);
    huoqi getOneHuoqi(Integer id);
}
