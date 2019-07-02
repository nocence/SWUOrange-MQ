package com.swuorange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.dao.BaseMapper;
import com.swuorange.data.ResultData;
import com.swuorange.dto.BaseDelDTO;
import com.swuorange.po.Base;
import com.swuorange.util.StringUtil;

@Service
@Transactional
public class BaseService {

	@Autowired
	private BaseMapper baseMapper;

	/*
	 * 
	 * @Description: 该方法根据前端所传数组进行批量或单个删除
	 *
	 * @param json
	 * 
	 * @return
	 * 
	 * @return：返回值描述
	 * 
	 * @version: v1.0.0
	 * 
	 * @author: Randy
	 * 
	 * @date: 2019年3月10日 下午10:56:28
	 */
	public String del(JSONObject json) {
		try {
			BaseDelDTO delDTO = JSONObject.toJavaObject(json, BaseDelDTO.class);
			int[] dels = StringUtil.convertIntArr(delDTO.getList());
			for (int i : dels) {
				baseMapper.delBaseById(i);
			}
			return ResultData.SUCCESS_CODE;
		} catch (Exception e) {
			return ResultData.FAIL_CODE;
		}
	}

	/*
	 * 
	 * @Description: 该方法用于保存base,如果有id者更新,如果没有id者插入
	 *
	 * @param json
	 * 
	 * @return
	 * 
	 * @return：返回值描述
	 * 
	 * @version: v1.0.0
	 * 
	 * @author: Randy
	 * 
	 * @date: 2019年3月10日 下午10:58:07
	 */
	public String updateOrInsert(JSONObject json) {
		try {
			Base base = JSONObject.toJavaObject(json, Base.class);
			// 判断是否有id值
			if (base.getBaseId() != null) {// 如果有id则是修改调用更新即可
				
				System.out.println("执行了基地更新操作");
				baseMapper.updateBase(base);
			} else {// 如果没有id则为新增调用保存即可
				System.out.println("执行了基地插入操作");
				baseMapper.insertBase(base);
			}
			return ResultData.SUCCESS_CODE;
		} catch (Exception e) {
			return ResultData.FAIL_CODE;
		}
	}
}
