package com.springboottemplate.service.impl;

import java.util.List;

import com.springboottemplate.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboottemplate.mapper.UserMapper;
import com.springboottemplate.pojo.User;
import com.springboottemplate.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Override
	public List<User> findAll() {
		System.out.println(UserController.threadLocal.get());
		return null;
	}
//	@Autowired
//	private UserMapper userMapper;
//
//	@Override
//	public List<User> findAll() {
//		List<User> findAll = userMapper.findAll();
//		return findAll ;
//	}

}
