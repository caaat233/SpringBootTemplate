package com.springboottemplate.event.listener;

import com.springboottemplate.event.event.FamilyMessageEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 唐涛
 * @description: 监听器，监听到事件后，做处理
 * @date 2021/10/15 11:21
 */
@Component
public class FamilyMessageListener implements ApplicationListener<FamilyMessageEvent> {
    @Override
    public void onApplicationEvent(FamilyMessageEvent familyMessageEvent) {
        String text = familyMessageEvent.getText();
        System.out.println("监听器监听到了faimly 事件，获取的值为：" + text + "，后续会做出业务处理");
    }
}
