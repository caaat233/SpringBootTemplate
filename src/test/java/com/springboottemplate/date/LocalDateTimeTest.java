package com.springboottemplate.date;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @author 唐涛
 * @description:
 * @date 2021/5/28 15:46
 */

/**
 * mybatis 对mysql 时间类型的操作，：https://blog.csdn.net/ywb201314/article/details/83795265
 *
 *
 *
 * 注意：注意到LocalDateTime无法与时间戳进行转换，因为LocalDateTime没有时区，无法确定某一时刻。后面我们要介绍的ZonedDateTime相当于LocalDateTime加时区的组合，它具有时区，可以与long表示的时间戳进行转换。
 *
 */
public class LocalDateTimeTest {

    /**
     * pattern:yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(localDateTime.withNano(0));//去掉毫秒
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp);

        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
        System.out.println(dtf.format(LocalDateTime.now()));

    }

    @Test
    public void test2() {

    }
}
