package com.example.ruanjiangongcheng.service;

import com.example.ruanjiangongcheng.entity.dingqibiao;
import com.example.ruanjiangongcheng.entity.retuen.dingqi;

import java.util.List;

public interface IDingqiService {
    List<dingqi> getAll(String card_number);
    dingqi getOne(int id);
    int createNew(dingqibiao dq);
    int deleteOne(int id);
}
