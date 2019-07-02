package com.swuorange.dao;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.po.BatchDTO;

/**
*@Description: 对生产批次表的添加
*
*@version: v1.0.0
*@author: Yiming
*@date: 2019年3月14日 下午4:07:07 
*/
@Mapper
public interface BatchMapper {
	
	void insertBatch(BatchDTO batchDTO);
}
