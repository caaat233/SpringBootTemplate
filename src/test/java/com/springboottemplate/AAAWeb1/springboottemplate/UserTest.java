package com.springboottemplate.AAAWeb1.springboottemplate;

//import org.junit.jupiter.api.Test;
import com.springboottemplate.mapper.UserMapper;
import com.springboottemplate.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @description:
 * @author: ttao
 * @create: 2020-06-28 20:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public  void contextLoads() {
    }

    @Test
    public void optimisticLockest() {
        String s = userService.optimisticLock(406);
        System.out.println(s);
    }




}
