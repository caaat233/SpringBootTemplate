package com.springboottemplate.eumn;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/28 16:01
 */
public enum OrderEum {
    READY("ready"),
    DELIVERED("delivered"),
    OVER("over");


    private String name;

    /**
     * 因为增加了name属性，所以必须增加构造器
     *
     * @param name
     */
    OrderEum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
