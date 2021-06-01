package com.springboottemplate.date;

import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 唐涛
 * @description: DateTimeFormatterTest
 * @date 2021/5/28 17:12
 */
public class DateTimeFormatterTest {
    /**
     * pattern:yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * pattern:yyyy-MM-dd
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * long类型时间戳转换为字符串日期类型
     */
    @Test
    public void test1() {
        long currentTimeMillis = System.currentTimeMillis();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(currentTimeMillis), ZoneId.of("GMT+7"));
        System.out.println(zonedDateTime);
        System.out.println(ZonedDateTime.now());
        System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS)));

    }


}
