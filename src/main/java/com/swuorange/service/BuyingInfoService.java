package com.swuorange.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.json.JsonArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.swuorange.dao.BuyingInfoMapper;
import com.swuorange.data.ResultData;
import com.swuorange.dto.BaseDelDTO;
import com.swuorange.dto.ListDTO;
import com.swuorange.po.BuyingInfo;
import com.swuorange.util.StringUtil;

@Service
@Transactional
public class BuyingInfoService {

	@Autowired
	private BuyingInfoMapper buyingInfoMapper;

	/*
	 * 
	 * @Description: 该方法根据是否有主键判断调用更新还是插入
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
	 * @date: 2019年3月13日 下午7:29:49
	 */
	public String updateOrInsert(JSONObject json) {
		try {
			BuyingInfo buyingInfo = JSONObject.toJavaObject(json, BuyingInfo.class);
			if (buyingInfo.getBuyId() != null) {
				buyingInfoMapper.updateBuy(buyingInfo);
			} else {
				buyingInfoMapper.insertBuy(buyingInfo);
			}
			return ResultData.SUCCESS_CODE;
		} catch (Exception e) {
			return ResultData.FAIL_CODE;
		}
	}

	/*
	 * 
	 * @Description: 该方法 删除数据
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
	 * @date: 2019年3月13日 下午7:30:30
	 */
	public String del(JSONObject json) {
		try {
			ListDTO listDTO = JSONObject.toJavaObject(json, ListDTO.class);
			List<Integer> list = JSONArray.parseArray(listDTO.getArr(), Integer.class);
			for (Integer integer : list) {
				buyingInfoMapper.deleteBuy(integer);
			}
			return ResultData.SUCCESS_CODE;
		} catch (Exception e) {
			return ResultData.FAIL_CODE;
		}
	}

}
