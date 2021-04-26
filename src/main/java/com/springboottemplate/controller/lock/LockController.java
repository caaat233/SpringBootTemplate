package com.springboottemplate.controller.lock;

import com.springboottemplate.util.LockMockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/26 10:06
 */
@Controller
public class LockController {

    @Autowired
    private LockMockUtil lockMockUtil;

    /**
     * 可以看见，多个线程访问这个方法，锁是能生效的。可以看见不同线程执行时间间隔是五秒
     * 但是不知道为什么，他们的方法执行耗时都是5s，不计算锁的等待时间
     * @return
     * @throws InterruptedException
     */
    @ResponseBody
    @RequestMapping("lock/getMethodRunTime")
    public String getName() throws InterruptedException {
        long start = System.currentTimeMillis();
        lockMockUtil.Sleep5s_single();
        long end = System.currentTimeMillis();
        double upTime = new BigDecimal(end - start).divide(new BigDecimal(1000)).doubleValue();//耗时(秒)
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String date = sdf.format(new Date());
        return "执行时间为：" + date + "  执行耗时：" + String.valueOf(upTime);
    }

//    @ResponseBody
//    @RequestMapping("lock/getMethodRunTime")
//    public String getName() throws InterruptedException {
//        lockMockUtil.Sleep5s();
////        long end = System.currentTimeMillis();
////        double upTime = new BigDecimal(end - start).divide(new BigDecimal(1000)).doubleValue();//耗时(秒)
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = sdf.format(new Date());
//        return "执行的开始时间为：" + date ;
//    }

}
