package com.springboottemplate.lock;

import com.springboottemplate.lock.dto.UserNameUtil;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/22 20:46
 */
public class SynchronizedTest {
    public static void main(String[] args) throws InterruptedException {

        UserNameUtil dto = new UserNameUtil();
        System.out.println(dto.setGetName("藏三1"));
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });


    }
}
