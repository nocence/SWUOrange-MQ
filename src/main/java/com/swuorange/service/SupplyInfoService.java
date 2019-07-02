package com.swuorange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.swuorange.dao.SupplyInfoMapper;
import com.swuorange.data.ResultData;
import com.swuorange.dto.ListDTO;
import com.swuorange.po.SupplyInfo;

@Service
@Transactional
public class SupplyInfoService {

	@Autowired
	private SupplyInfoMapper supplyInfoMapper;

	public String insertOrUpdate(JSONObject json) {

		try {
			SupplyInfo supplyInfo = JSONObject.toJavaObject(json, SupplyInfo.class);
			System.err.println(supplyInfo + "1111111111111111111111111111111111111111111111111111111111");
			if (supplyInfo.getSupplyId() != null) {
				supplyInfoMapper.updateSupplyInfo(supplyInfo);
			} else {
				supplyInfoMapper.insertSupplyInfo(supplyInfo);
			}

			return ResultData.SUCCESS_CODE;
		} catch (Exception e) {
			return ResultData.FAIL_CODE;
		}

	}

	public String del(JSONObject json) {
		try {
			ListDTO listDTO = JSONObject.toJavaObject(json, ListDTO.class);
			List<Integer> list = JSONArray.parseArray(listDTO.getArr(), Integer.class);
			for (Integer integer : list) {
				supplyInfoMapper.deleteSupplyInfo(integer);
			}
			return ResultData.SUCCESS_CODE;
		} catch (Exception e) {
			return ResultData.FAIL_CODE;
		}
	}

}
