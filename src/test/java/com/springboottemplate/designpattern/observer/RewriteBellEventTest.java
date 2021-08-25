package com.springboottemplate.designpattern.observer;

import java.util.EventObject;
import java.util.Observable;

/**
 * @author 唐涛
 * @description: 在 Java 中，通过 java.util.Observable 类和 java.util.Observer 接口定义了观察者模式，
 * 只要实现它们的子类就可以编写观察者模式实例。这里重写一下铃声通知老师学生上课的观察者模式
 * @date 2021/8/23 17:44
 */
public class RewriteBellEventTest {
    public static void main(String[] args) {
        RingEvent1 ringEvent1 = new RingEvent1();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        ringEvent1.addObserver(observer1);
        ringEvent1.addObserver(observer2);
        ringEvent1.setaBoolean(true);//打铃
        ringEvent1.setaBoolean(false);//关铃
    }

}

//铃声事件类：用于封装事件源及一些与事件相关的参数
class RingEvent1 extends Observable {
    boolean aBoolean = false;

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {

        this.aBoolean = aBoolean;
        super.setChanged();  //设置内部标志位，注明数据发生变化
        super.notifyObservers(aBoolean);    //通知观察者价格改变了
    }
}

class Observer1 implements java.util.Observer {


    @Override
    public void update(Observable o, Object arg) {
        boolean aBoolean = ((RingEvent1) o).aBoolean;
        if (aBoolean) {
            System.out.println("老师上课了");
        } else {
            System.out.println("老师下课了");
        }
    }
}

class Observer2 implements java.util.Observer {


    @Override
    public void update(Observable o, Object arg) {
        boolean aBoolean = ((RingEvent1) o).isaBoolean();
        if (aBoolean) {
            System.out.println("学生上课了");
        } else {
            System.out.println("学生下课了");
        }
    }
}