package com.example.ruanjiangongcheng;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class RuanjiangongchengApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
    @Test
    void TestTime(){
//        Date time = new Date();
//        System.out.println(time);
//        Calendar rightNow = Calendar.getInstance();
//        rightNow.setTime(time);
//        rightNow.add(Calendar.YEAR,1);
//        Date result = rightNow.getTime();
//        System.out.println(result);
        Date time=new Date();
        Date time1=new Date();
        System.out.println(time.equals(time1));
    }

}
