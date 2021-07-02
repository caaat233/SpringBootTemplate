package com.springboottemplate.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class Stringformat {


    @Test
    public void test() {

        System.out.println(String.format("%s#%s#%s", "aaa", "bb", "cc"));
    }

    /**
     * 拼接字符串
     */
    @Test
    public void format1() {
        String downloadUrl = "http://%s:%s/tddp2/index.do?file_id=%s";
        String a = String.format(downloadUrl, "www.baidu.com", "80","111111111111");
        System.out.println(a);
    }

    /**
     * 拼接字符串
     */
    @Test
    public void format2() {
        String redis = String.format("%s.%s%s","LAZADA_ID", 1234455,"_11");
        System.out.println(redis);
    }

}
