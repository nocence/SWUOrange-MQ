package com.swuorange.dao;

import org.springframework.stereotype.Repository;

import com.swuorange.po.Companyinfo;
import com.swuorange.po.User;


@Repository
public interface UserMapper {
	
	void insert(User user);
	
	Integer updateByUserId(Companyinfo companyinfo);
}
