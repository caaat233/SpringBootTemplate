package com.springboottemplate.mysql;

import com.springboottemplate.jihe.User;
import lombok.SneakyThrows;
import org.apache.commons.compress.utils.Lists;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author 唐涛
 * @description: 测试数据库隔离级别，以及脏读、幻读、虚读相关问题
 * @date 2021/7/12 17:18
 */
public class MysqlTransaction {

    private Connection connection;
    private PreparedStatement preparedStatement;

    {
        try {
            connection = JdbcUtil.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void test_testSelectForUpdate() throws Exception {
        //模拟两个线程
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                testSelectForUpdate(404);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                testSelectForUpdate(404);
            }
        });
        t1.setName("线程1");
        t1.start();
        t2.setName("线程2");
        t2.start();
        Thread.sleep(1000000000);

    }


    /**
     * 测试mysql的行锁
     */
    public void testSelectForUpdate(int userId) throws Exception {
        String sql = "select * from  tabletest where id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List userList = Lists.newArrayList();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("name"));
                userList.add(user);
            }
            System.out.println(Thread.currentThread().getName() + "开始打印" + userList.toString());
        } catch (Exception e) {
            System.out.println("查询失败" + e);
        }
    }


    /**
     * 测试select for update 语句
     */
    @Test
    public void test_testRowlock() throws Exception {
        try {
            connection.setAutoCommit(true);
            testSelectForUpdate(404);

            //模拟两个线程
            Thread t1 = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    testRowlock();
                }
            });
            t1.start();
            testSelectForUpdate(404);
        } catch (Exception e) {
            System.out.println("失败" + e);
        }


    }


    @Test
    public void testRowlock() throws Exception {
        String sql = "UPDATE `test`.`tabletest` SET  `name` = '琴咏2-2' WHERE `id` = 404";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute(sql);
            System.out.println(Thread.currentThread().getName() + "开始执行");
            connection.commit();
            System.out.println("修改完毕");
        } catch (Exception e) {
            System.out.println("更新失败" + e);
            connection.rollback();
        }


    }


}
