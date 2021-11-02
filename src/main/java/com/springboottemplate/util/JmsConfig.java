package com.springboottemplate.util;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/7 17:43
 */
public class JmsConfig {
    /**
     * Name Server 地址，因为是集群部署 所以有多个用 分号 隔开
     */
   // public static final String NAME_SERVER = "127.0.0.1:9876;30.117.116.11:9876";
    public static final String NAME_SERVER = "118.31.55.236:9876";
    /**
     * 主题名称 主题一般是服务器设置好 而不能在代码里去新建topic（ 如果没有创建好，生产者往该主题发送消息 会报找不到topic错误）
     */
    public static final String TOPIC_FAMILY = "topic_family";
}
