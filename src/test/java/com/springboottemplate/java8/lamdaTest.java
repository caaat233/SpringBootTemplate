package com.springboottemplate.java8;

import com.google.common.collect.Lists;
import com.springboottemplate.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class lamdaTest {


    @Test
    public void test1(){
        String text = "test";
        text="test change";
        List<Integer> list = Arrays.asList(1,2);
        List<Integer> list2 = new ArrayList<>();
        //list.forEach();
        list.forEach(value -> {
            System.out.println(value);
            list2.add(value);
        });



    }

    @Test
    public void testFilter() {
        List<User> list = createList();
        //只留下满足条件的
        List<User> collect = list.stream().filter(value -> StringUtils.equals(value.getId(), "1")).collect(Collectors.toList());
        System.out.println(collect);
        //转换成set
        Set<User> collect1 = list.stream().filter(value -> StringUtils.equals(value.getId(), "1")).collect(Collectors.toSet());
        System.out.println(collect1);
        List<User> collect2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect2);


    }


    public static List<User> createList() {

        User user = new User("1", "", "");
        User user1 = new User("2", "", "");
        User user2 = new User("3", "", "");
        User user3 = new User("3", "", "");
        List<User> userList = Lists.newArrayList(user, user1, user2);
        return userList;

    }

}

