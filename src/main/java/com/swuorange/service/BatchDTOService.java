package com.swuorange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.dao.BatchMapper;
import com.swuorange.data.ResultData;
import com.swuorange.po.BatchDTO;

@Service
public class BatchDTOService {
	
	@Autowired
	private BatchMapper batchMapper;
	
	public String add(JSONObject json){
		BatchDTO batch = JSONObject.toJavaObject(json, BatchDTO.class);
		batchMapper.insertBatch(batch);
			return ResultData.SUCCESS_CODE;
	}
}
