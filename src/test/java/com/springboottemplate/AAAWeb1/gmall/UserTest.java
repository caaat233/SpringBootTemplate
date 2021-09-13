package com.springboottemplate.AAAWeb1.gmall;

import com.springboottemplate.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @description:springboot项目单元测试
 * @author: ttao
 * @create: 2020-06-28 20:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    public void contextLoads() {
    }

    @Test
    public void findAllTest() {
        System.out.println(userService.findAllUserFromDB());
    }


}
