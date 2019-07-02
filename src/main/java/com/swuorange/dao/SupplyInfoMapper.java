package com.swuorange.dao;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.po.SupplyInfo;

@Mapper
public interface SupplyInfoMapper {

	public void insertSupplyInfo(SupplyInfo supplyInfo);

	public void updateSupplyInfo(SupplyInfo supplyInfo);

	public void deleteSupplyInfo(Integer id);

}
