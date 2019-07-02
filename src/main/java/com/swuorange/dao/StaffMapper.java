package com.swuorange.dao;

import org.springframework.stereotype.Repository;

import com.swuorange.po.Staff;



@Repository
public interface StaffMapper {
	
	
	void insert(Staff staff);
}
