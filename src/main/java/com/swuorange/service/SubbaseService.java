package com.swuorange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.dao.SubbaseMapper;
import com.swuorange.data.ResultData;
import com.swuorange.dto.SubbaseDTO;
import com.swuorange.dto.SubbaseDelDTO;
import com.swuorange.util.StringUtil;

@Service
@Transactional
public class SubbaseService {
	
	@Autowired
	private SubbaseMapper subbaseMapper;
	
	
	//插入二级基地
	public String insert(JSONObject json){
		try {
			SubbaseDTO subbase = JSONObject.toJavaObject(json, SubbaseDTO.class);
			// 判断是否有id值
			if (subbase.getSubbaseId() != null) {// 如果有id则是修改调用更新即可
				//更新场地表
				System.out.println("执行了场地更新操作");
			} else {// 如果没有id则为新增调用保存即可
				//在场地表中插入数据
				System.out.println("执行了场地插入操作");
				subbaseMapper.insertSubbase(subbase);
				int subbaseId = subbase.getSubbaseId();
				System.out.println(subbaseId);
				//将生产记录者插入用户表中
				subbaseMapper.insertPR(subbase);
				int prUserId = subbase.getUserId();
				System.out.println(prUserId);
				//将任命的员工插入二级生产单位员工授权表中，场地负责人
				subbaseMapper.insert2ndStaffpc(subbase);
				//将任命的员工插入二级生产单位员工授权表中，生产记录者
				subbaseMapper.insert2ndStaffpr(subbase);
				//将任命的生产记录者插入userrole表中
				subbaseMapper.insertUserRole(subbase);
			}
			return ResultData.SUCCESS_CODE;
		} catch (Exception e) {
			return ResultData.FAIL_CODE;
		}
		
	}
	
	//更新二级基地
	public String update(JSONObject json){
		try {
			SubbaseDTO subbase = JSONObject.toJavaObject(json, SubbaseDTO.class);
			//更新场地表
			System.out.println("执行了场地更新操作");
			subbaseMapper.updateSubbase(subbase);
			//将生产记录者插入用户表中
			subbaseMapper.updatePR(subbase);
			//将任命的员工插入二级生产单位员工授权表中，场地负责人
			subbaseMapper.update2ndStaffpc(subbase);
			//将任命的员工插入二级生产单位员工授权表中，生产记录者
			subbaseMapper.update2ndStaffpr(subbase);
			
			return ResultData.SUCCESS_CODE;
		} catch (Exception e) {
			return ResultData.FAIL_CODE;
		}
		
	}
		
	//删除二级基地
	public String deleteSubbase(JSONObject json){
		
		SubbaseDTO subbase = JSONObject.toJavaObject(json, SubbaseDTO.class);
		//删除场地表
		subbaseMapper.deleteSubbase(subbase);
		//删除生产记录者在user表中的数据
		subbaseMapper.deleteUser(subbase);
		//删除场地关系表中数据
		subbaseMapper.deleteSss(subbase);
		//删除userrole关系表中的生产记录者
		subbaseMapper.deleteUserRole(subbase);
		return ResultData.SUCCESS_CODE;
	}
	
	//批量删除二级基地
	public String deleteSubbases(JSONObject json) {
		try {
			SubbaseDelDTO delDTO = JSONObject.toJavaObject(json, SubbaseDelDTO.class);
			int[] dels = StringUtil.convertIntArr(delDTO.getList());
			for (int i : dels) {
				subbaseMapper.delSubbaseById(i);
			}
			return ResultData.SUCCESS_CODE;
		} catch (Exception e) {
			return ResultData.FAIL_CODE;
		}
	}
	
	

}
