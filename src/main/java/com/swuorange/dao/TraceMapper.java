package com.swuorange.dao;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.dto.TraceCheckDTO;
import com.swuorange.dto.TraceDTO;

@Mapper
public interface TraceMapper {
	
	//插入
	int insert(TraceDTO trace);
	
	//审批
	int update(TraceCheckDTO trace);

}
