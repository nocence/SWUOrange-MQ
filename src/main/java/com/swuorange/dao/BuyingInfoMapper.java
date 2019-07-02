package com.swuorange.dao;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.po.BuyingInfo;

@Mapper
public interface BuyingInfoMapper {

	public void updateBuy(BuyingInfo buyingInfo);

	public void insertBuy(BuyingInfo buyingInfo);
	
	public void deleteBuy(Integer id);
	
}
