package com.springboottemplate.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.springboottemplate.pojo.User;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public List<Map> findAll();

    public Map findUserById(@Param("id") int id);

    public List<Map> findUserByName(@Param("name") String name);

    public int updateUserById(@Param("id") int id, @Param("version") int version);

    public int countUser();


    /**
     * 分页查询，可以把数据排序，你可以加个日期，预热指的日期后的参数，我这边为了简单，主要是演示怎么分批预热
     *
     * @param id  上一批最后一条数据的id
     * @param start
     * @param limit
     * @return
     */
    public List<User> getAllUserByPageForPre(@Param("id") int id, @Param("start") int start, @Param("limit") int limit);

}