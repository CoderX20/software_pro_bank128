package com.example.ruanjiangongcheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.ruanjiangongcheng.mapper")
public class RuanjiangongchengApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuanjiangongchengApplication.class, args);
    }

}
