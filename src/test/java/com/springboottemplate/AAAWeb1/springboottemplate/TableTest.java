package com.springboottemplate.AAAWeb1.springboottemplate;

import com.springboottemplate.pojo.TableTestDO;
import com.springboottemplate.service.TableTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 唐涛
 * @description: TableTest
 * @date 2021/5/28 14:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TableTest {

    @Autowired
    TableTestService tableTestService;

    @Test
    public void testFindAll() {
        List<TableTestDO> all = tableTestService.findAll();
        System.out.println(all.toString());
    }
}
