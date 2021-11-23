package com.springboottemplate.temp;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/11/10 10:54
 */
public class Student {
    public static void main(String[] args) {
        Student student1=new Student();
        System.out.println(student1.toString());//这个是无参构造器new的对象，构造器里面没有对属性赋值，所有打印的值都是空
        student1.setName("张三");
        student1.setSex("男");
        System.out.println(student1.toString());//我上面通过set方法赋值之后，这个student1对象就有值了
        System.out.println(student1.getName());//通过getset方法也能获取到值，
        System.out.println(student1.getSex());


    }


    private String name;
    private String sex;
    private int age;

    public Student() {
    }

    public Student(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        //不要总是再方法里面system.out。这个代码尽量再mian方法中打印出来
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 这个方法是打印对象的值的
     * @return
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
