package com.example.ruanjiangongcheng.service;

import com.example.ruanjiangongcheng.entity.dingqibiao;

import java.util.List;

public interface IDingqiService {
    List<dingqibiao> getAll(String card_number);
    dingqibiao getOne(int id);
    int createNew(dingqibiao dq);
    int deleteOne(int id);
}
