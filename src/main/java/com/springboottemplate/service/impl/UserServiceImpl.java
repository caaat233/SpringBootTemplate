package com.springboottemplate.service.impl;

import com.alibaba.fastjson.JSON;
import com.springboottemplate.constant.RedisPrefixKeyConstants;
import com.springboottemplate.controller.RocketMQController;
import com.springboottemplate.mapper.UserMapper;
import com.springboottemplate.service.UserService;
import com.springboottemplate.util.UserThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * @author 唐涛
 * @description: userServiceMysqlImpl
 * @date 2021/8/31 19:09
 */

/**
 * 这个service主要是查询数据库的
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    Jedis jedis;


    @Override
    public List<Map> findAllUserFromDB() {
        List<Map> allMap = userMapper.findAll();
        for (Map map : allMap) {
            long id = (long) map.get("id");
            jedis.setex(RedisPrefixKeyConstants.USER_INFO + "_" + id, 300, JSON.toJSONString(map));
        }
        //这样用threadLocal，不好，最好专门弄一个工具类
        System.out.println(RocketMQController.threadLocal.get());
        return allMap;
    }


    @Override
    public Map findUserByIdFromDB(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<Map> findUserByNameFromDB(String name) {
        System.out.println(UserThreadLocalUtil.getUserInfo());
        return userMapper.findUserByName(name);
    }

    @Override
    public String findUserByIdFromRedis(int id) {
        String userInfo = jedis.get(RedisPrefixKeyConstants.USER_INFO + "_" + String.valueOf(id));

        return userInfo;
    }

    /**
     * 数据库隔离级别：可重复读，事务传递方式默认的，有事务就加入，没有就创建
     *所以你会有问题：
     *  问：mysql既然是可重复读，我一个事务读取的版本号都是一样的啊。为什么 乐观锁可以生效？
     * 		 答案：1、如果你更新失败不重试。可以使用乐观锁，因为update user set userName=zhangsan where id=1 and version=1.这个是当前读取
     * 			  2、如果你更新失败要重试，你必须下调事务或者数据库的隔离级别到读已提交，因为select是快照读，你递归重试的时候，还是一个事务，
     * 			  获取到的版本号不会改变，所以你永远不会更新成功。
     *
     *
     *
     * @param id
     * @return
     */
    //isolation = Isolation.READ_COMMITTED 是因为可重复读读不到更新的版本号，要改成read_commotted
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    @Override
    public String optimisticLock(int id) {
        int retryCount = 0;
        //先查询用户信息以及当前版本号
        Map user = userMapper.findUserById(id);
        while (retryCount < 3) {
            int version = (int) user.get("version");
            //这个updateUserById方法里面的sql是：update user set username=#{usernmae} where id=id and version=#{version}
            int count = userMapper.updateUserById(id, version);
            if (count == 0) {
                retryCount++;
                //如果失败了就递归重试三次
                //在可重复读的隔离级别下会造成自旋每次查出来的数据都不是最新数据，从而导致自旋失败的问题（所以，隔离级别需要下调到读已提交，或者别重试，直接抛出异常）
                return optimisticLock(id);
            } else {
                System.out.println("更新成功");
            }
        }
        return "更新失败";
    }

}