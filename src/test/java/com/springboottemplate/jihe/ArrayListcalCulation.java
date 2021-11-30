package com.springboottemplate.jihe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/11/24 15:44
 */
public class ArrayListcalCulation {




    @Test
    public void 判断有没有重复元素(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("小1", 100, 1));
        studentList.add(new Student("小2", 90, 2));
        studentList.add(new Student("小2", 100, 3));
        studentList.add(new Student("小1", 100, 1));
        long count = studentList.stream().distinct().count();
        System.out.println(count);

    }

    @Test
    public void 差集(){

        List<Student> students = returnTestDataA();
        students.stream().forEach(value->value.setName("1"));
        System.out.println(students);

    }
    /**
     * 测试数据。
     *
     * @return
     */
    public List<Student> returnTestDataA() {
        // 测试数据
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("小1", 100, 1));
        studentList.add(new Student("小2", 90, 2));
        studentList.add(new Student("小3", 100, 3));
        return studentList;
    }
    /**
     * 测试数据。
     *
     * @return
     */
    public List<Student> returnTestDataB() {
        // 测试数据
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("小1", 100, 1));
        studentList.add(new Student("小2", 90, 2));
        studentList.add(new Student("小3", 100, 3));
        studentList.add(new Student("小4", 100, 3));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) &&
                score.equals(student.score) &&
                grade.equals(student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, grade);
    }
}