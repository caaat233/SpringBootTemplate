package com.springboottemplate.template.transaction;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/7/21 16:32
 */
public class SpringBootTemplateTransactionTemplate {


    @Transactional(rollbackFor = Exception.class)
    public <T> T execute(SpringBootTemplateAction<T> action) {
        return action.execute();
    }
}
