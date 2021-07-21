package com.springboottemplate.template.transaction;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: TemplateTransaction Template 的使用
 * @date 2021/7/21 16:38
 */
public class SpringBootTemplateTransactionTemplateTest {


    public Boolean test1() {
        //初始化bean，自己使用的时候，同@autowaire注入就行，不要new
        SpringBootTemplateTransactionTemplate springBootTemplateTransaction = new SpringBootTemplateTransactionTemplate();
        return springBootTemplateTransaction.execute(() -> {
            System.out.println("业务操作");
            return true;
        });
        //等效于下面 test2（）的写法

    }


    public Boolean test2() {
        SpringBootTemplateTransactionTemplate springBootTemplateTransaction = new SpringBootTemplateTransactionTemplate();

        return springBootTemplateTransaction.execute(new SpringBootTemplateAction<Boolean>() {
            @Override
            public Boolean execute() {
                System.out.println("业务操作");
                return Boolean.TRUE;
            }
        });
    }
}
