package com.springboottemplate.p273_329;

import com.springboottemplate.xsd.Student;

public class test {
    public static void main(String[] args) {
        String dd = "hello";
        String aa = "hello";
        String cc = aa;
        String bb = new String("hello");
        System.out.println(aa == bb);//false
        System.out.println(aa == cc);//true
        System.out.println(aa == dd);//true
        Student s = new Student();
        Student s1=s;
        Student s2=s;
		System.out.println(s==s1);//true
		System.out.println(s==s2);//true


    }

}
