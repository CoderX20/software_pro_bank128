package com.example.ruanjiangongcheng;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class test {
    @Value("${mybatis.mapper-locations}")
    private String name="123";
}
