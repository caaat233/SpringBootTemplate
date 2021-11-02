package com.springboottemplate.util;

import groovy.util.logging.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

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

    public Producer() {
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
    public void start() {
        try {


            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public DefaultMQProducer getProducer() {
        return this.producer;
    }

    /**
     * 一般在应用上下文，使用上下文监听器，进行关闭
     */
    public void shutdown() {
        this.producer.shutdown();
    }


    /**
     * Metaq 消息发送
     *
     * @param msgTopic 消息Topic
     * @param msgTag   消息Tag
     * @param msgBody  消息对象
     */
    public String sendMessage(String msgTopic, String msgTag, String msgKey, byte[] msgBody) {
        try {
            Message message = new Message(msgTopic, msgTag, msgKey, msgBody);
            // 消息发送
            SendResult sendResult = producer.send(message);
            String msgId = null;
            if (sendResult.getSendStatus().equals(SendStatus.SEND_OK)) {
                msgId = sendResult.getMsgId();
                logger.info(MessageFormat.format("消息发送成功, "
                        + "msgId:{0}, topic:{1}, msgTags:{2}, msgKeys:{3}, msgBody:{4}", msgId, msgTopic, msgTag, msgKey, new String(msgBody)));
            } else {
                logger.error(MessageFormat.format(":消息发送失败, "
                        + "topic:{0}, msgTags:{1}, msgKeys:{2}, msgBody:{3}", msgTopic, msgTag, msgKey, new String(msgBody)));
            }
            return msgId;
        } catch (Exception e) {
            logger.error(MessageFormat.format("消息发送异常, "
                    + "topic:{0}, msgTags:{1}, msgKeys:{2}, msgBody:{3}, exception:{4}", msgTopic, msgTag, msgKey, new String(msgBody), e.getMessage()));
            logger.error(MessageFormat.format("消息发送异常, "
                    + "topic:{0}, msgTags:{1}, msgKeys:{2}, msgBody:{3}", msgTopic, msgTag, msgKey, new String(msgBody)), e);
            return null;
        }
    }
}