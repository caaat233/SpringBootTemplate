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
        /**
         * 设置默认时区
         * 一般来说，JVM在哪里跑，默认时区就是哪。对于国内程序员来讲，一般只会接触到东八区，也就是北京时间（本地时间）。随着国际合作越来越密切，很多时候需要日期时间国际化处理，举个很实际的例子：同一份应用在阿里云部署、在AWS（海外）上也部署一份供海外用户使用，此时同一份代码部署在不同的时区了，怎么破？
         *
         * 倘若时区不同，那么势必影响到程序的运行结果，很容易带来计算逻辑的错误，很可能就乱套了。Java让我们有多种方式可以手动设置/修改默认时区：
         *
         * API方式： 强制将时区设为北京时区TimeZone.setDefault(TimeZone.getDefault().getTimeZone("GMT+8"));
         * JVM参数方式：-Duser.timezone=GMT+8
         * 运维设置方式：将操作系统主机时区设置为北京时区，这是推荐方式，可以完全对开发者无感，也方便了运维统一管理
         */
        long currentTimeMillis = System.currentTimeMillis();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(currentTimeMillis), ZoneId.of("GMT+7"));
        System.out.println(zonedDateTime);
        System.out.println(ZonedDateTime.now());
        System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS)));

    }



}
