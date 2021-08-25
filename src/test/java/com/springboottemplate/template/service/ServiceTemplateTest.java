package com.springboottemplate.template.service;

import com.springboottemplate.java8.PairTest;
import com.springboottemplate.pojo.User;
import com.springboottemplate.template.Result;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/7/16 11:31
 */
public class ServiceTemplateTest {
    ServiceTemplateImpl serviceTemplate = new ServiceTemplateImpl();
    TransactionTemplate transactionTemplate;

    public static void main(String[] args) {

    }

    @Test
    public void test_test_serviceTemplate_exction() throws Exception {
        User user = new User();
        user.setId("1");
        test_serviceTemplate_exction(user);
    }

    public Result test_serviceTemplate_exction(User user) throws Exception {
        return serviceTemplate.exction(new ServiceCallback<User>() {
            @Override
            public void paramCheck() {
                if (user == null) {
                    PairTest pairTest = new PairTest();
                    pairTest.validateFields((Pair.of("user", user)));
                }
            }

            @Override
            public Result executeAction() throws Exception {
                //可以给user里面的属性赋值，但是不能改变user引用,因为user是final类型
                user.setEmail("92397249");
                return Result.success(user);
            }
        }, "ServiceTemplateTest.test");
    }

    /**
     * 临时
     * @param user
     * @return
     * @throws Exception
     */
    public Result test_serviceTemplate_exction2(User user) throws Exception {
        return serviceTemplate.exction(new ServiceCallback<User>() {
            @Override
            public void paramCheck() {
                if (user == null) {
                    PairTest pairTest = new PairTest();
                    pairTest.validateFields((Pair.of("user", user)));
                }
            }

            @Override
            public Result executeAction() throws Exception {
                //可以给user里面的属性赋值，但是不能改变user引用,因为user是final类型
                user.setEmail("92397249");
                return Result.success(user);
            }
        }, "ServiceTemplateTest.test");
    }
}
