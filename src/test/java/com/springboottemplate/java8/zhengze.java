package com.springboottemplate.java8;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author 唐涛
 * @description: https://blog.csdn.net/qq_25835645/article/details/89315957   经纬度校验波博客
 * @date 2021/7/6 11:16
 * <p>
 * <p>
 * 正则常用符号学习
 * https://tool.oschina.net/uploads/apidocs/jquery/regexp.html
 * https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Guide/Regular_Expressions
 */
public class zhengze {


    /**
     * demo
     * ^[0-9]+abc$
     * ^ 为匹配输入字符串的开始位置。
     * [0-9]+匹配多个数字， [0-9] 匹配单个数字，+ 匹配一个或者多个。
     * abc$匹配字母 abc 并以 abc 结尾，$ 为匹配输入字符串的结束位置。
     */
    @Test
    public void demo() {
        String str = "123abc";
        String patt1 = "^[0-9]+abc$";
        System.out.println(str.matches(patt1));
    }

    /**
     * 校验经度（整数部分为 -180.0～+180.0，小数位数最多保留6位，）
     *
     * @param lng
     * @return
     */
    public boolean validateLng(String lng) {
        String regex = "^(\\-|\\+)?(((\\d|[1-9]\\d|1[0-7]\\d|0{1,3})\\.\\d{0,6})|(\\d|[1-9]\\d|1[0-7]\\d|0{1,3})|180\\.0{0,6}|180)$";
        return lng.matches(regex);

    }

    /**
     * 校验经度（整数部分为 -90.0～+90.0，小数位数最多保留6位，）
     *
     * @param lag
     * @return
     */
    public boolean validateLag(String lag) {
        String regex = "^[\\-\\+]?([0-8]?\\d{1}(\\.\\d{1,6})*|90(\\.0{1,6})*)$";
        return lag.matches(regex);

    }


    @Test
    public void lng() {
        //经度：整数部分为 -180.0～+180.0，小数位数最多保留6位，或者输fun入整数部分也可以
        // String patt1 = "^[\\-\\+]?(0?\\d{1,2}(\\.\\d{1,5})*|1[0-7]?\\d{1}(\\.\\d{1,5})*|180(\\.0{1,5})*)$";
        String patt1 = "^(\\-|\\+)?(((\\d|[1-9]\\d|1[0-7]\\d|0{1,3})\\.\\d{0,6})|(\\d|[1-9]\\d|1[0-7]\\d|0{1,3})|180\\.0{0,6}|180)$";
        System.out.println(validateLng("-180"));
        System.out.println(validateLng("+180"));
        System.out.println(validateLng("+90"));
        System.out.println(validateLng("-90"));
        System.out.println(validateLng("90"));
        System.out.println(validateLng("-179.123456"));
        System.out.println(validateLng("-180.000000"));



    }

    @Test
    public void lag() {
        //纬度：整数部分为 -90.0～+90.0，小数位数最多保留6位，或者输入整数部分也可以，如【-90.000000,90.000000
        String lag = "^[\\-\\+]?([0-8]?\\d{1}(\\.\\d{1,6})*|90(\\.0{1,6})*)$";
        System.out.println(validateLag("+90"));
        System.out.println(validateLag("-90"));
        System.out.println(validateLag("0"));
        System.out.println(validateLag("00.123"));
        System.out.println(validateLag("1.2"));
        System.out.println(validateLag("89.123456"));
        System.out.println(validateLag("-89.123456"));
        System.out.println(validateLag("90.000000"));

    }

}
