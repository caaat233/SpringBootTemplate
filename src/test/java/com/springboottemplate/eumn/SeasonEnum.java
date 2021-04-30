package com.springboottemplate.eumn;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/3/1214:28
 */
public enum SeasonEnum {

    SPRING(1, "春"),
    SUMMER(2, "夏"),
    AUTUMN(3, "秋"),
    WINTER(4, "冬");

    private int id;//自定义属性

    private String name;//自定义属性

    private SeasonEnum(int i, String name) {//自定义构造器
        this.id = i;
        this.name = name;
    }

    private SeasonEnum(String name) {//自定义构造器
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
