package com.example.ruanjiangongcheng.mapper;

import com.example.ruanjiangongcheng.entity.dingqibiao;
import com.example.ruanjiangongcheng.entity.retuen.dingqi;
import com.example.ruanjiangongcheng.service.IDingqiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class dingqiMapperTest {
    @Autowired
    private IDingqiService dingqiService;
    @Autowired(required = false)
    private dingqiMapper dingqimapper;

    @Test
    public void testService(){
//        List<dingqi> lst_dingqi = dingqiService.getAll("123");
        //List<dingqibiao> lst_dingqi = dingqimapper.selectAllDingqi("123");
//        for(int i = 0;i<lst_dingqi.size();i++){
//            System.out.println(lst_dingqi.get(i));
//        }
        dingqi dq = dingqiService.getOne(8);
        System.out.println(dq);
//        dingqibiao dq = new dingqibiao();
//        dq.setCard_number("123");
//        dq.setCreate_time(new Date());
//        dq.setMoney(1000d);
//        dq.setPeriod("1年");
//        int result = dingqiService.createNew(dq);
//        System.out.println(result);
    }
}
