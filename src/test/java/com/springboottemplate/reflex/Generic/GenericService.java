package com.springboottemplate.reflex.Generic;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/28 11:14
 */
public class GenericService {
    GenericInterface<String> genericInterfaceClear;
    GenericInterface genericInterfaceFuzzy;

    public void getTest1() {
        String method = genericInterfaceClear.method();
    }

    public void getTest2() {
        Object method = genericInterfaceFuzzy.method();
    }


}
