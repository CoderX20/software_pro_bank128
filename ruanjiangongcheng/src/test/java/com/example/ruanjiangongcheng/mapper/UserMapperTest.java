package com.example.ruanjiangongcheng.mapper;

import com.example.ruanjiangongcheng.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    private DataSource dataSource;
    @Autowired(required = false)
    private UserMapper userMapper;
    @Test
    public void TestSelectOneByCardnumber() throws SQLException {
        UserInfo user = new UserInfo();
        user.setCard_number("123455");
        UserInfo user1= userMapper.selectOneByCardNumber("123455");
        System.out.println(user1);

    }
}
