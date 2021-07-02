package com.springboottemplate.string;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/7 16:20
 */
public class TestBigDecimal {


    /***
     *
     *  测试double精度问题
     *
     * 1.幂数不够表示了：这种情况往往出现在数字太大了，超过幂数所能承受的范围，
     * 那么这个数字就无法表示了。如幂数最大只能是10，但是这个数字用科学计数法表示时，幂数一定会超过10，就没办法了。
     *
     * 2.尾数不够表示了：这种情况往往出现在数字精度太长了，
     * 如1.3434343233332这样的数字，虽然很小，还不超过2，这种情况下幂数完全满足要求，但是尾数已经不能表示出来了这么长的精度。
     *
     * 综上：double类型转换成BigDecimal运算就完事了
     */
    @Test
    public void test2() {
        double quantity = 1;
        double paidPrice = 20.2;
        double number3 = 300.03;
        Double v = quantity + paidPrice + number3;
        System.out.println(v);//正确结果321.23；实际是321.22999999999996
        System.out.println(quantity + paidPrice + number3);//正确结果321.23；实际是321.22999999999996
        System.out.println(Double.valueOf(v));//正确结果321.23；实际是321.22999999999996
        System.out.println(paidPrice * quantity);//20.2
        BigDecimal quantityBigDecimal = BigDecimal.valueOf(quantity);
        BigDecimal paidPriceBigDecimal = BigDecimal.valueOf(paidPrice);
        BigDecimal number3BigDecimal = BigDecimal.valueOf(number3);
        BigDecimal addResultBigDecimal = quantityBigDecimal.add(paidPriceBigDecimal).add(number3BigDecimal);
        System.out.println(addResultBigDecimal);//321.23
        System.out.println(addResultBigDecimal.doubleValue());//321.23

    }

    /**
     * 测试加减乘除
     * 使用BigDecimal类构造方法传入double类型时，计算的结果也是不精确的！尽量是String
     */

    @Test
    public void test() {
        BigDecimal num1 = new BigDecimal(0.005);
        BigDecimal num2 = new BigDecimal(1000000);
        BigDecimal num3 = new BigDecimal(-1000000);
        //尽量用字符串的形式初始化,如下
       //  BigDecimal b = new BigDecimal(Double.toString(0.005));
        BigDecimal num12 = new BigDecimal("0.005");
        BigDecimal num22 = new BigDecimal("1000000");
        BigDecimal num32 = new BigDecimal("-1000000");

        //加法
        BigDecimal result1 = num1.add(num2);
        BigDecimal result12 = num12.add(num22);
        //减法
        BigDecimal result2 = num1.subtract(num2);
        BigDecimal result22 = num12.subtract(num22);
        //乘法
        BigDecimal result3 = num1.multiply(num2);
        BigDecimal result32 = num12.multiply(num22);
        //绝对值
        BigDecimal result4 = num3.abs();
        BigDecimal result42 = num32.abs();
        //除法
        BigDecimal result5 = num2.divide(num1, 20, BigDecimal.ROUND_HALF_UP);
        BigDecimal result52 = num22.divide(num12, 20, BigDecimal.ROUND_HALF_UP);

        System.out.println("加法用value结果：" + result1);
        System.out.println("加法用string结果：" + result12);

        System.out.println("减法value结果：" + result2);
        System.out.println("减法用string结果：" + result22);

        System.out.println("乘法用value结果：" + result3);
        System.out.println("乘法用string结果：" + result32);

        System.out.println("绝对值用value结果：" + result4);
        System.out.println("绝对值用string结果：" + result42);

        System.out.println("除法用value结果：" + result5);
        System.out.println("除法用string结果：" + result52);


    }
}
