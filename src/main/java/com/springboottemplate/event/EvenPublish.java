package com.springboottemplate.event;

import com.springboottemplate.event.event.FamilyMessageEvent;
import com.springboottemplate.util.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 唐涛
 * @description: EvenPublish，发送指定事件
 * @date 2021/10/15 11:12
 */

@Component
public class EvenPublish {
    private Logger logger = LoggerFactory.getLogger(EvenPublish.class);
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 发布接受到topic=family的消息
     *
     * @param text
     */
    public  void pubAcceptFamilyMessageEvent(String text) {
        FamilyMessageEvent insertEvent = new FamilyMessageEvent(this, text);
        logger.info("消费者接受到消息后，发送family事件成功");
        applicationEventPublisher.publishEvent(insertEvent);

    }


}
