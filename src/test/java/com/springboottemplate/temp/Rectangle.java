package com.springboottemplate.temp;

import com.springboottemplate.designpattern.adapter.classes.Source;

import java.util.Scanner;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/11/5 10:52
 */
public class Rectangle {


    public static void main(String[] args) {
        /**
         * 1、第一步，获取到键盘输入的长宽高
         */
        System.out.println("请输入矩形的宽和高");
        Scanner scanner = new Scanner(System.in);
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        /**
         * 2、new Rectangle（）,调用计算面积，周长的方法，然后把值打印在控制台上
         */

        Rectangle rectangle = new Rectangle();

        System.out.println("周长为：" + rectangle.getLength(height, width));
        System.out.println("面积为：" + rectangle.getArea(height, width));



    }


    private double height;

    private double width;


    public double getArea(double height, double width) {

        return height * width;
    }

    public double getLength(double height, double width) {

        return (height + width) * 2;
    }
}
