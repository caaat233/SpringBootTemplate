package com.springboottemplate.string;

import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/6/2 11:10
 */
public class IntegerTest {


    @Test
    public void test_equal() {
        Integer integer=new Integer(0);
        System.out.println(integer==0);
        System.out.println(integer.equals(0));
    }
}
