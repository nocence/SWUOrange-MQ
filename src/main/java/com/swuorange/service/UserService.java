package com.swuorange.service;


import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.dao.UserMapper;
import com.swuorange.dao.UserRoleMapper;
import com.swuorange.po.User;
import com.swuorange.po.UserRole;
import com.swuorange.service.UserService;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	

	public String add(JSONObject json) {
		User user = JSONObject.toJavaObject(json, User.class);
		System.out.println(user);
		
		user.setRegistTime(new Timestamp(System.currentTimeMillis()));
		user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		userMapper.insert(user);
		
		//获取新注册用户的id
		int userid=user.getUserId();
		UserRole userRole = new UserRole();
		userRole.setUserId(userid);
		userRole.setRoleId(1);
		userRoleMapper.insert(userRole);
		
		System.out.println(user);
		return "200";
	}
	

}
