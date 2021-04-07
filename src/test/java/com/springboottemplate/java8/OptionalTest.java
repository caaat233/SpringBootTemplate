package com.springboottemplate.java8;

import com.springboottemplate.jihe.User;
import org.junit.Test;

import java.sql.Date;
import java.util.Optional;

/**
 * 学习链接
 * https://dalin.blog.csdn.net/article/details/106132531?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
 */
public class OptionalTest {


    /**
     * map()方法将对应Funcation函数式接口中的对象，进行二次运算，封装成新的对象然后返回在Optional中 源码：
     *
     * 说白了，j就是取出来User对象里面的属性
     * */

    @Test
    public void test5Map() {
        //下面是错误的,因为user.getPassword()会产生空指针
        User user = new User();
        user.setId(1);
        user.setUserName("张三");
        String aa = Optional.ofNullable(user).map(value -> value.getUserName()).orElse("name为空");
        System.out.println(aa);
    }

    /**
     * filter()方法大致意思是，接受一个对象，然后对他进行条件过滤，如果条件符合则返回Optional对象本身，如果不符合则返回空Optional
     */
    @Test
    public void test4Filter() {
        //下面是错误的,因为user.getPassword()会产生空指针
        User user = new User();
       user.setId(1);

        Optional<User> user1 = Optional.ofNullable(user).filter(p -> p.getId() > 50);
    }

    @Test
    public void test3IPresent() {
        //下面是错误的,因为user.getPassword()会产生空指针
        User user = null;

        Optional.ofNullable(user).ifPresent(value -> {
            String s = Optional.ofNullable(value.getPassword()).get();
            Date date = Optional.ofNullable(value.getCreateTime()).get();
        });
    }

    /**
     * 如果user.getPassword()不是空，执行if里面内容，否则不执行
     */
    @Test
    public void test2IsPresent() {
        //下面是错误的,因为user.getPassword()会产生空指针
        User user = null;
        if (Optional.ofNullable(user.getPassword()).isPresent()) {
            System.out.println("aaa");
        }
        System.out.println("bbbbbbb");
        ///正确的
        Optional.ofNullable(user).ifPresent(value -> {
            if (user.getPassword() != null) {
                System.out.println("aaaa");
            }

        });

    }

    /**
     * 如果对象不是空，则返回对象，否则，抛出  throw new NoSuchElementException("No value present");
     */
    @Test
    public void test1Get() {
        // User user=new User();
        User user = null;

        System.out.println(Optional.ofNullable(user).get());


    }


}
