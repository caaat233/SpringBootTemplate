package com.springboottemplate.date;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/12/3 17:36
 * <p>
 * https://segmentfault.com/a/1190000039047353
 */

public class TimeZoneTest {


    @Test
    public void 了解TimeZone类() {


        // 北京时间（new出来就是默认时区的时间）
        Date bjDate = new Date();

        // 得到纽约的时区
        TimeZone newYorkTimeZone = TimeZone.getTimeZone("America/New_York");
        // 根据此时区 将北京时间转换为纽约的Date
        String patternStr = "yyyy-MM-dd HH:mm:ss";
        DateFormat newYorkDateFormat = new SimpleDateFormat(patternStr);
        newYorkDateFormat.setTimeZone(newYorkTimeZone);

        System.out.println("这是北京时间：" + new SimpleDateFormat(patternStr).format(bjDate));
        System.out.println("这是纽约时间：" + newYorkDateFormat.format(bjDate));
        //注意：两个时间表示的应该是同一时刻，也就是常说的时间戳值是相等的

    }

    @Test
    public void 了解Date类() {
        //new Date()所做的事情其实就是调用了System.currentTimeMillis()。
        // Date对象里存的是自格林威治时间（ GMT）1970年1月1日0点至Date所表示时刻所经过的毫秒数
//其实是一个毫秒值，根据时区/偏移量的不同可以展示多地的时间，这就证明了Date它的时区无关性。：
        Date currDate = new Date();
        System.out.println(currDate.toString());//本地时间，根据本地时区显示的时间格式，如果是北京就显示北京的时间，如果是日本，就显示日本当前的时间
        // 已经@Deprecated
        System.out.println(currDate.toLocaleString());//GTM时间，也就是格林威治这个时候的时间，可以看到它是凌晨2点（北京时间是上午10点哦）
        // 已经@Deprecated
        System.out.println(currDate.toGMTString());//GTM时间，也就是格林威治这个时候的时间，可以看到它是凌晨2点（北京时间是上午10点哦）

        // 第二个、第三个其实在JDK 1.1就都标记为@Deprecated过期了，基本禁止再使用。若需要转换为本地时间 or GTM时间输出的话，请使用格式化器java.text.DateFormat去处理。
    }
}
