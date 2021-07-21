package com.springboottemplate.page1_100.jicheng;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/7/19 17:47
 */
public class TestJiCheng {

    public static void main(String[] args) {
        Student student = new Student();
        student.setA(1);

        student.setB(2);
        testJicheng(student);
        List<Student> students=new ArrayList();
        students.add(student);
    }


    public static void testJicheng(Person person) {
        System.out.println(person.a);
        System.out.println(JSON.toJSONString(person));
    }



    public static void testJicheng1(List<Person> person) {
        for (Person person1 : person) {
            System.out.println(JSON.toJSONString(person));
        }

    }
}
