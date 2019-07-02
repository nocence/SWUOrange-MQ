package com.swuorange.dao;

import org.springframework.stereotype.Repository;

import com.swuorange.po.User;
import com.swuorange.po.UserRole;

@Repository
public interface UserRoleMapper {
	
	void insert(UserRole userRole);
}
