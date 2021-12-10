package com.springboottemplate.jvm;

/**
 * @author 唐涛
 * @description: java 值传递、引用传递的问题
 * @date 2021/9/24 14:24
 */

import org.junit.Test;

/**
 * 如果参数是基本类型的话，很简单，传递的就是基本类型的字面量值的拷贝，会创建副本。
 * 如果参数是引用类型，传递的就是实参所引用的对象在堆中地址值的拷贝，同样也会创建副本。(说白了，新创建了一个引用，只是这个引用也指向同一个内存对象罢了)
 * #参考：https://javaguide.cn/java/basis/why-there-only-value-passing-in-java/#%E6%A1%88%E4%BE%8B3-%E4%BC%A0%E9%80%92%E5%BC%95%E7%94%A8%E7%B1%BB%E5%9E%8B%E5%8F%82%E6%95%B02
 * <p>
 * String表现为值传递，主要是因为这个玩意儿是不可变的！如何理解不可变？我们一般说的改变一个String变量，
 * 其实并不是改变的这个String本身，而是用一个新的String去替换掉原来的，原来的String本身并没有变。
 */
public class JavaValueTransfer {


    public static void main(String[] args) {
        String name = new String("张三");
        System.out.println(name);
        modifyString(name);
    }


    public static void modifyString(String value) {
        System.out.println(value);
        value = "lisi";
    }

    /**
     *
     */
    @Test
    public void objectUserRefer() {
        User user = new User();
        System.out.println(user);
        modifyUser(user);//com.springboottemplate.jvm.User@4c98385c

    }

    @Test
    public void objectUserReferA() {
        User user = new User();
        user.setId("1");
        user.setEmail("123@qq.com");
        User userA=user;
        userA.setId("2");
        System.out.println(user);
        System.out.println(userA);

    }

    public void modifyUser(User user) {
        System.out.println(user);//com.springboottemplate.jvm.User@4c98385c
    }


}

class User {
    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}