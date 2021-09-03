package com.springboottemplate.util;

import com.springboottemplate.aop.LogTestAop;
import groovy.util.logging.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/7 17:45
 */
@Component
public class Consumer {
    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    /**
     * 消费者实体对象
     */
    private DefaultMQPushConsumer consumer;
    /**
     * 消费者组
     */
    public static final String CONSUMER_GROUP = "test_consumer";

    /**
     * 通过构造函数 实例化对象
     */
    public Consumer() throws MQClientException {

        consumer = new DefaultMQPushConsumer(CONSUMER_GROUP);
        consumer.setNamesrvAddr(JmsConfig.NAME_SERVER);
        //消费模式:一个新的订阅组第一次启动从队列的最后位置开始消费 后续再启动接着上次消费的进度开始消费
        //消费模式，集群，一个组内，只有一台机器消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.setMessageModel(MessageModel.CLUSTERING);
        //订阅主题和 标签（ * 代表所有标签)下信息
        consumer.subscribe(JmsConfig.TOPIC, "*");
        // //注册消费的监听 bu，并返回消费的状态信息
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            // msgs中只收集同一个topic，同一个tag，并且key相同的message
            // 会把不同的消息分别放置到不同的队列中e
            try {
                for (Message msg : msgs) {
                    //消费者获取消息 这里只输出 不做后面逻辑处理
                    String body = new String(msg.getBody(), "utf-8");
                    logger.info("Consumer-获取消息-主题topic为={}, 消费消息为={}", msg.getTopic(), body);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                //
                /**
                 *         RocketMQ规定，以下三种情况统一按照消费失败处理并会发起重试。
                 *                 业务消费方返回ConsumeConcurrentlyStatus.RECONSUME_LATER
                 *                  业务消费方返回null
                 *                 业务消费方主动/被动抛出异常
                 *（推荐返回ConsumeConcurrentlyStatus.RECONSUME_LATER）
                 *
                 *                 链接：https://juejin.cn/post/6844903809186005000
                 */


                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();
        System.out.println("消费者 启动成功=======");
    }
}