package com.springboottemplate.lock.dto;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/22 20:44
 */
public class UserNameUtil {

    int id;
    String name="zhangsan";


    public  String  setGetName(String  name) throws InterruptedException {
        this.name=name;
        Thread.sleep(1000);
        return  name;
    }
}
