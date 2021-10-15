package com.springboottemplate.event.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author 唐涛
 * @description: 接受family topic 的消息后，发送的事件
 * @date 2021/10/15 11:14
 */
public class FamilyMessageEvent extends ApplicationEvent {

    //一个人称谓的字符串
    String text;


    public FamilyMessageEvent(Object source, String text) {
        super(source);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
