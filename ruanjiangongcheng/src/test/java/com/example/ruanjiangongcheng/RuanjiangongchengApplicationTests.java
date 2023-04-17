package com.example.ruanjiangongcheng;

import com.example.ruanjiangongcheng.entity.dingqibiao;
import com.example.ruanjiangongcheng.utils.Jwt;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

//@SpringBootTest
class RuanjiangongchengApplicationTests {
    @Autowired
    private DataSource dataSource;


    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
    @Test
    void TestTime() throws IllegalAccessException {
//        Date time = new Date();
//        System.out.println(time);
//        Calendar rightNow = Calendar.getInstance();
//        rightNow.setTime(time);
//        rightNow.add(Calendar.YEAR,1);
//        Date result = rightNow.getTime();
//        System.out.println(result);
//        Date time=new Date();
//        Date time1=new Date();
//        System.out.println(time.equals(time1));
//        dingqibiao test1=new dingqibiao();
        test test1=new test();
        String token=Jwt.createToken(test1,200*1000);
        System.out.println(token);

        Claims claims = Jwt.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoibWlrZSIsImV4cCI6MTY4MTcyNzAwNCwiYWdlIjoxMH0.3cY-1FBbN-vRy2sUoyKD8jE_Srz0SBZwe5bj4iHiD2k");
        System.out.println(claims);
    }

}
