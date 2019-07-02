package com.swuorange.dao;


import org.springframework.stereotype.Repository;

import com.swuorange.po.Companyinfo;

/**
*@Description: 对公司信息表的增删改查
*
*@version: v1.0.0
*@author: Yiming
*@date: 2019年3月6日 下午4:12:24 
*/
@Repository
public interface CompanyinfoMapper {
    /**
     *
     *@Description 用户注册时候进行企业验证，将数据插入数据库等待审查
     *@return 返回值描述
     *@version v1.0.0
     *@author YiMing
     *@2019年3月6日 下午4:13:25
     *
     */
	Integer insertCompanyinfo(Companyinfo companyinfo);

}