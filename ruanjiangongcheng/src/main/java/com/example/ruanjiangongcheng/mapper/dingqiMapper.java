package com.example.ruanjiangongcheng.mapper;

import com.example.ruanjiangongcheng.entity.dingqibiao;

import java.util.List;

public interface dingqiMapper {
    List<dingqibiao> selectAllDingqi(String cardNumber);
    int insertNewDingqi(dingqibiao dq);
    int deleteDingqi(int id);
    dingqibiao selectOneByID(int id);
}
