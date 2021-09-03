package com.springboottemplate.util;

import groovy.util.logging.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/7 17:44
 */

@Component
public class Producer {
    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    private String producerGroup = "test_producer";
    private DefaultMQProducer producer;

    public Producer(){
        //示例生产者
        producer = new DefaultMQProducer(producerGroup);
        //不开启vip通道 开通口端口会减2
        producer.setVipChannelEnabled(false);
        //绑定name server
        producer.setNamesrvAddr(JmsConfig.NAME_SERVER);
        /**同步发送消息，如果3秒内没有发送成功，则重试3次*/
        producer.setRetryTimesWhenSendFailed(3);
        logger.info("生产者注册成功");
        start();
    }
    /**
     * 对象在使用之前必须要调用一次，只能初始化一次
     */
    public void start(){
        try {


            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public DefaultMQProducer getProducer(){
        return this.producer;
    }
    /**
     * 一般在应用上下文，使用上下文监听器，进行关闭
     */
    public void shutdown(){
        this.producer.shutdown();
    }
}