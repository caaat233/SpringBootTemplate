package com.springboottemplate.service;


import java.util.List;
import java.util.Map;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/8/31 19:17
 */
public interface UserService {
    /**
     * 从DB查所有用户
     *
     * @return
     */
    public List<Map> findAllUserFromDB();

    /**
     * 通过id 用户
     *
     * @param id
     * @return
     */
    public Map findUserByIdFromDB(int id);

    /**
     * 通过name用户
     *
     * @param name
     * @return
     */
    public List<Map> findUserByNameFromDB(String name);



    /**
     * 通过name用户
     *
     * @param id
     * @return
     */
    public String findUserByIdFromRedis(int id);

    /**
     * 更新用户信息，有乐观锁的逻辑
     * @param id
     * @return
     */

    public String optimisticLock(int id);
}
