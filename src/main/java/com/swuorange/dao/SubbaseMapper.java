package com.swuorange.dao;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.dto.SubbaseDTO;

@Mapper
public interface SubbaseMapper {
	
	//插入新场地（二级基地）
	int insertSubbase(SubbaseDTO subbase);
	//在user中插入生产记录者
	int insertPR(SubbaseDTO subbase);
	//在二级基地与员工关系对应表中插入场地负责人
	int insert2ndStaffpc(SubbaseDTO subbase);
	//在二级基地与员工关系对应表中插入生产记录者
	int insert2ndStaffpr(SubbaseDTO subbase);
	//将任命的生产记录者插入userrole表中
	int insertUserRole(SubbaseDTO subbase);
			
	
	//修改场地
	int updateSubbase(SubbaseDTO subbase);
	//修改用户表中的生产记录者
	int updatePR(SubbaseDTO subbase);
	//修改二级基地关系表中的场地负责人
	int update2ndStaffpc(SubbaseDTO subbase);
	//修改二级基地关系表中的生产记录者
	int update2ndStaffpr(SubbaseDTO subbase);
	
	
	//删除场地（二级基地）
	int deleteSubbase(SubbaseDTO subbase);
	//删除生产记录者在user表中的数据
	int deleteUser(SubbaseDTO subbase);
	//删除场地关系表中的数据 
	int deleteSss(SubbaseDTO subbase);
	//删除userrole中的生产记录者
	int deleteUserRole(SubbaseDTO subbase);
	//批量删除场地
	int delSubbaseById(Integer i);
	
}
