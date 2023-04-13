package com.example.ruanjiangongcheng.mapper;

import com.example.ruanjiangongcheng.entity.huoqibiao;

import java.util.List;
import java.util.Map;

public interface huoqiMapper {
    List<huoqibiao> selectAllByCardNumber(String cardNumber);
    int insertNewHuoqi(Map params);
    huoqibiao selectOneByID(int id);
    int updateHuoqi(huoqibiao hq);
    int deleteHuoqi(int id);
}
