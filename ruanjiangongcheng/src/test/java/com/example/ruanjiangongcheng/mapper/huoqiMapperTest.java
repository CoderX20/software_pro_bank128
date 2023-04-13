package com.example.ruanjiangongcheng.mapper;

import com.example.ruanjiangongcheng.entity.huoqibiao;
import com.example.ruanjiangongcheng.service.IHuoqiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class huoqiMapperTest {
    @Autowired(required = false)
    private huoqiMapper huoqiMapper1;
    @Autowired
    private IHuoqiService huoqiService;

    @Test
    public void selectAllByCardNumber(){
        List<huoqibiao> lst_huoqi=huoqiMapper1.selectAllByCardNumber("123");
        for(int i=0;i<lst_huoqi.size();i++){
            System.out.println(lst_huoqi.get(i));
        }
    }

    @Test
    public void Addhuoqi(){
        Map params =new HashMap<>();
        params.put("card_number",123);
        params.put("create_time",new Date());
        params.put("money",5555);
        params.put("last_time",new Date());
        int a = huoqiMapper1.insertNewHuoqi(params);
        System.out.println(a);
    }
    @Test
    public void serviceTest(){

        int result= huoqiService.createNewHuoqi("123",1000);
        System.out.println(result);
    }
}
