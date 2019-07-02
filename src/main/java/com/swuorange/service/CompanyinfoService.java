package com.swuorange.service;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuorange.dao.CompanyinfoMapper;
import com.swuorange.dao.UserMapper;
import com.swuorange.data.ActiveMQData;
import com.swuorange.data.ResultData;
import com.swuorange.po.Companyinfo;
import com.swuorange.po.User;

@Service
public class CompanyinfoService {
	@Autowired
	private CompanyinfoMapper companyinfoMapper;
	
	@Autowired
	private UserMapper userMapper;
	 /**
	  * 
	  *
	  *@Description 用户进行企业验证之后将申请信息存入数据库等待审批，同时修改用户表的企业信息ID
	  *@return 返回值描述
	  *@version v1.0.0
	  *@author YiMing
	  *@2019年3月11日 下午6:59:30
	  *
	  */
	public String add(JSONObject json){
		System.out.println("json-MQ:"+json.toString());
		Companyinfo companyinfo = JSONObject.toJavaObject(json, Companyinfo.class);
		Integer companyId = companyinfoMapper.insertCompanyinfo(companyinfo);
		if(companyId!=null){
			Integer userId = userMapper.updateByUserId(companyinfo);
			if(userId!=null){
				return ResultData.SUCCESS_CODE;
			}else{
				return ResultData.FAIL_CODE;
			}
		}else{
			
			return ResultData.FAIL_CODE;
		}
	}
}
