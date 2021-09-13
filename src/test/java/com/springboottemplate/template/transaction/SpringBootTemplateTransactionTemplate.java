package com.springboottemplate.template.transaction;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/7/21 16:32
 */

/**
 * ：此前，我们主要通过XML配置Spring来托管事务。在SpringBoot则非常简单，只需在业务层添加事务注解(@Transactional )即可快速开启事务。虽然事务很简单，
 * 但对于数据方面是需要谨慎对待的，识别常见坑点对我们开发有帮助。
 *
 * 作者：一只袜子
 * 链接：https://www.jianshu.com/p/380a9d980ca5
 * 来源：简书
 */
public class SpringBootTemplateTransactionTemplate {

/*
注意：事务的异常可以捕获，但是捕获后记得抛出runtimeException异常，或者@Transactional(rollbackFor=Exception.class)，
    否则会导致事务失效，数据commit造成数据不一致，所以有些时候try catch反倒会画蛇添足。
 */
    @Transactional(rollbackFor = Exception.class)
    public <T> T execute(SpringBootTemplateAction<T> action) {
        return action.execute();
    }
}
