package com.swuorange.dao;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.po.Base;

@Mapper
public interface BaseMapper {

	public void delBaseById(int i);

	public void updateBase(Base base);
	public void insertBase(Base base);

}
