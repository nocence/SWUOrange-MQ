package com.swuorange.dao;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.po.RecordDTO;

@Mapper
public interface RecordMapper {
	
	Integer insertDetail(RecordDTO recordDTO );
}
