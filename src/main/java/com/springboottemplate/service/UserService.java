package com.springboottemplate.service;

import java.util.List;
import java.util.Map;

import com.springboottemplate.pojo.User;

public interface UserService {
	public List<User> findAll();


	public List<Map>  findAllDB();


}
