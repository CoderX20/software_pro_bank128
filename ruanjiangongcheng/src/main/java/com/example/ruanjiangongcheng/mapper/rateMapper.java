package com.example.ruanjiangongcheng.mapper;

import com.example.ruanjiangongcheng.entity.rate;

import java.util.List;

public interface rateMapper {
    Double selectRateByType(String type);
    int updateRate(rate rt);
    List<rate> selectAllRate();
}
