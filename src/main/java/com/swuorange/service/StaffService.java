package com.swuorange.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.dao.StaffMapper;
import com.swuorange.dao.UserRoleMapper;
import com.swuorange.po.Staff;

@Service
public class StaffService {

	@Autowired
	private StaffMapper staffMapper;
	
	
	public String addStaff(JSONObject json) {
		Staff staff = JSONObject.toJavaObject(json, Staff.class);
		System.out.println(staff);
		
		
		staffMapper.insert(staff);
		
		
		System.out.println(staff);
		return "200";
		
	}
	
	
	
	
}
