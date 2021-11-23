package com.springboottemplate.task.preheat;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.springboottemplate.constant.RedisPrefixKeyConstants;
import com.springboottemplate.mapper.UserMapper;
import com.springboottemplate.pojo.User;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author 唐涛
 * @description: 预热user表的缓存
 * @date 2021/10/29 15:48
 */

/**
 * 预热逻辑，
 * 1、如果数据库数据量不大，直接把所有数据查询出来（记得排序），然后进行预热
 * 2、如果数据量过大，就需要分页查询.分批预热，见下面的实现
 *
 * @author 唐涛
 */
//我们这里就不弄定时任务了，不方便，直接controller 调用
@Component
public class UserPreheatServiceImpl implements IPreheatService<User> {

    @Autowired
    UserMapper userMapper;

    @Autowired
    Jedis jedis;


    @Override
    public void prepareRedisCache() {
        //每次查询开始的userId
        int startUserId = 0;
        //统计一共预热的数量
        int count = 0;
        List<User> allUserByPageForPreList = null;
        do {
            allUserByPageForPreList = userMapper.getAllUserByPageForPre(startUserId, 0, 10);
            if (CollectionUtils.isEmpty(allUserByPageForPreList)) {
                System.out.println("不存在数据，不需要预热");
                return;
            }
            allUserByPageForPreList.stream().forEach(d -> {

                try {
                    int id = Integer.valueOf(d.getId());
                    String redisKey = RedisPrefixKeyConstants.USER_INFO + "_" + id;
                    jedis.set(redisKey, JSON.toJSONString(d));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    throw e;
                }
            });
            startUserId = Integer.valueOf(allUserByPageForPreList.get(allUserByPageForPreList.size() - 1).getId());
            count += allUserByPageForPreList.size();
        } while (allUserByPageForPreList.size() == 10); //如果能查到10条数据，说明还有数据没预热，还进入循环

        System.out.println("总预热的数据：" + count);

    }

    @Override
    public boolean accept(String name) {
        if ("user".equals(name)) {
            return true;
        }
        return false;
    }


}
