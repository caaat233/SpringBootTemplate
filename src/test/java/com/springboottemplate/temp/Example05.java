package com.springboottemplate.temp;

import java.util.Scanner;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/10/28 16:41
 */

public class Example05 {

    public static void main(String[] args) {
        //声明你写的类
        System.out.println("代码已经运行，请输入数字");
        ScannerDemo scannerDemo = new ScannerDemo();
        scannerDemo.guessNumber();//通过类，调用你写的方法


    }
}

class ScannerDemo {//这个类的名称改成ScannerDemo，是因为，你要用别人的类获取键盘输入的值，别人的类叫 Scanner 。到时候你写的类还是Scanner，用的时候不知道是你的还是他的，所以改成ScannerDemo

    public void guessNumber() {//方法名起的显而易见，Guessnumber 翻译过来就是猜数字
        //number要猜的数字的值是啥
        int number = 5;
        //声明你要用的这个类
        Scanner scanner = new Scanner(System.in);
        while (true) {// while (true) 代表会一直循环，直到你输入正确，你也可以控制输入的次数，
            //通过这个方法获取到你键盘输入的值,你看一下，这个方法返回值是int，所以你只能输入数字，你输入字符串要换其他方法，不然报错
            int value = scanner.nextInt();
            if (value > 5) {
                System.out.println("sorry,你猜大了");
            } else if (value < 5) {
                System.out.println("sorry,你猜小了");
            } else {
                //一共就三种情况，要么比5大，要么比5小，要么就是5
                System.out.println("恭喜你猜中了");
                return;//这个返回，是因为，他猜中了，就可以退出程序了，你要不想推出程序，return 删除就行了
            }

        }
    }
}