package com.springboottemplate.util;

import org.springframework.stereotype.Component;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/7 16:01
 */
@Component
public class ResultHandlerImplB implements  ResultHandler{
    @Override
    public int value() {
        return 0;
    }

    @Override
    public String execute(String body) {
       String result="ResultHandlerImplB"+body;
        return result;
    }

    @Override
    public boolean accept(String body) {
        if ("B".equals(body)){
            return true;
        }
        return false;
    }
}
