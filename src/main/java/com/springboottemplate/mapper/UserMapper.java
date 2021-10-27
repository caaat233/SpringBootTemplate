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


	public int updateUserById(@Param("id") int id,@Param("version") int version);
}