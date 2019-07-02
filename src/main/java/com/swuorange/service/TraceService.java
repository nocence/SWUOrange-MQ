package com.swuorange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.dao.TraceMapper;
import com.swuorange.data.ResultData;
import com.swuorange.dto.TraceCheckDTO;
import com.swuorange.dto.TraceDTO;

@Service
@Transactional
public class TraceService {
	
	@Autowired
	private TraceMapper traceMapper;
	
	public String insert(JSONObject json){
		try {
			TraceDTO trace = JSONObject.toJavaObject(json, TraceDTO.class);
			//在场地表中插入数据
			System.out.println("执行了溯源申请插入操作");
			traceMapper.insert(trace);
			return ResultData.SUCCESS_CODE;
		} catch (Exception e) {
			return ResultData.FAIL_CODE;
		}
		
	}
	
	public String update(JSONObject json){
		try {
			TraceCheckDTO trace = JSONObject.toJavaObject(json, TraceCheckDTO.class);
			//在场地表中插入数据
			System.out.println("执行了溯源申请审批操作");
			traceMapper.update(trace);
			return ResultData.SUCCESS_CODE;
		} catch (Exception e) {
			return ResultData.FAIL_CODE;
		}
		
	}

}
