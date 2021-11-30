package com.springboottemplate.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 唐涛
 * @description: Stream流常用操作
 * <p>
 * https://www.fanchenio.com/dev/354.html
 * @date 2021/11/23 11:34
 */
public class StreamCommonUsed {


    /**
     * 提取
     */
    @Test
    public void testSort() {
        List<Student> studentList = returnTestData();
// 按score正序排序
        List<Student> resultList = studentList.stream().sorted(Comparator.comparing(Student::getScore)).collect(Collectors.toList());
// 输出
        for (Student student : resultList) {
            System.out.println(student);
        }


        // 按score倒序排序
        List<Student> resultList2 = studentList.stream().sorted(Comparator.comparing(Student::getScore, Comparator.reverseOrder())).collect(Collectors.toList());
// 输出
        for (Student student : resultList2) {
            System.out.println(student);
        }
    }

    /**
     * 提取
     */
    @Test
    public void testExtract() {
        List<Student> studentList = returnTestData();
// 提取name字段
        List<String> nameList = studentList.stream().map(Student::getName).collect(Collectors.toList());
// 输出
        for (String name : nameList) {
            System.out.print(name + ",");
        }
    }

    /**
     * 去重
     */
    @Test
    public void testFilter() {
        List<Student> studentList = returnTestData();
// 过滤掉100分的对象
        List<Student> resultList = studentList.stream().filter(s -> s.getScore() < 100).collect(Collectors.toList());
// 输出
        for (Student student : resultList) {
            System.out.println(student);
        }
    }


    /**
     * 去重
     */
    @Test
    public void testDistact() {
        List<Student> studentList = returnTestData();
// 按分数去重
        List<Student> resultList = studentList
                .stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getScore))), ArrayList::new));
// 输出
        for (Student student : resultList) {
            System.out.println(student);
        }
    }

    /**
     * 分组并统计
     */
    @Test
    public void testGroupSum() {
        List<Student> studentList = returnTestData();
// 按grade分组并按score统计
        Map<Integer, IntSummaryStatistics> groupByGradeMap =
                studentList.stream()
                        .collect(Collectors.groupingBy(Student::getGrade, Collectors.summarizingInt(Student::getScore)));
// 输出
        for (Map.Entry<Integer, IntSummaryStatistics> entry : groupByGradeMap.entrySet()) {
            System.out.println("grade：" + entry.getKey() + "，求和：" + entry.getValue().getSum());
            System.out.println("grade：" + entry.getKey() + "，最大：" + entry.getValue().getMax());
            System.out.println("grade：" + entry.getKey() + "，最小：" + entry.getValue().getMin());
            System.out.println("grade：" + entry.getKey() + "，平均：" + entry.getValue().getAverage());
            System.out.println("grade：" + entry.getKey() + "，总数：" + entry.getValue().getCount());
            System.out.println("---------------------------------");
        }

    }

    /**
     * 统计
     */
    @Test
    public void testSum() {
        List<Student> studentList = returnTestData();
        // 统计score字段
        IntSummaryStatistics intSummaryStatistics = studentList.stream().collect(Collectors.summarizingInt(Student::getScore));
// 输出
        System.out.println("求和：" + intSummaryStatistics.getSum());
        System.out.println("最大：" + intSummaryStatistics.getMax());
        System.out.println("最小：" + intSummaryStatistics.getMin());
        System.out.println("平均：" + intSummaryStatistics.getAverage());
        System.out.println("总数：" + intSummaryStatistics.getCount());

    }

    /**
     * 分组
     */
    @Test
    public void testGroup() {
        List<Student> studentList = returnTestData();

        //按grade分组
        Map<Integer, List<Student>> groupByGradeMap = studentList.stream().collect(Collectors.groupingBy(value -> value.getGrade()));
        // 输出
        for (Map.Entry<Integer, List<Student>> entry : groupByGradeMap.entrySet()) {
            if (entry.getValue().size() > 2) {
                System.out.println("error");
            }
        }
    }


    /**
     * 测试数据。
     *
     * @return
     */
    public List<Student> returnTestData() {
        // 测试数据
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("小1", 100, 1));
        studentList.add(new Student("小2", 90, 2));
        studentList.add(new Student("小3", 100, 3));
        studentList.add(new Student("小4", 60, 4));
        studentList.add(new Student("小5", 50, 1));
        studentList.add(new Student("小6", 80, 2));
        studentList.add(new Student("小7", 10, 3));
        studentList.add(new Student("小8", 40, 4));
        studentList.add(new Student("小9", 90, 1));
        studentList.add(new Student("小10", 55, 2));
        studentList.add(new Student("小11", 61, 3));
        studentList.add(new Student("小12", 83, 4));
        studentList.add(new Student("小13", 81, 1));
        studentList.add(new Student("小14", 62, 2));
        studentList.add(new Student("小15", 20, 3));
        studentList.add(new Student("小16", 78, 4));
        studentList.add(new Student("小16", 78, null));
        return studentList;
    }
}


// 实体类
class Student {

    /**
     * 名称
     */
    private String name;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 年级
     */
    private Integer grade;

    public Student(String name, Integer score, Integer grade) {
        this.name = name;
        this.score = score;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", grade=" + grade +
                '}';
    }
}