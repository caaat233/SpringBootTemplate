package com.springboottemplate.template.transaction;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: TemplateTransaction Template 的使用
 * @date 2021/7/21 16:38
 */
public class SpringBootTemplateTransactionTemplateTest {


    public Boolean test() {
        SpringBootTemplateTransactionTemplate springBootTemplateTransaction = new SpringBootTemplateTransactionTemplate();
        return springBootTemplateTransaction.execute(() -> {
            System.out.println("业务操作");
            return true;
        });

    }
}
