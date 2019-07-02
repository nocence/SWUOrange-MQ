package com.swuorange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.dao.RecordMapper;
import com.swuorange.data.ResultData;
import com.swuorange.po.RecordDTO;
@Service
public class RecordDTOService {
	
	@Autowired
	private RecordMapper recordMapper;
	/**
	 * 
	 *
	 *@Description 根据controller发来的消息将信息存入生产记录表
	 *@return recordId，不为空时插入成功
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月16日 下午9:17:04
	 *
	 */
	public String insertDetail(JSONObject json) {
		RecordDTO recordDTO = JSONObject.toJavaObject(json, RecordDTO.class);
		Integer recordId = recordMapper.insertDetail(recordDTO);
		System.out.println("返回的ID:"+recordId);
		if(recordId!=null){
			return ResultData.SUCCESS_CODE;
		}else{
			return ResultData.FAIL_CODE;
		}
	}
}
