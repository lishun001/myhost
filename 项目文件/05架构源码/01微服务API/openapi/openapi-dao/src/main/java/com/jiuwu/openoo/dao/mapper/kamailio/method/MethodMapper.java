package com.jiuwu.openoo.dao.mapper.kamailio.method;

import java.util.List;
import java.util.Map;

import model.ApiMethod.ApiMethod;
import model.ApiMethod.ApiMethodType;

/**
* @ClassName: MethodMapper
* @Description:API方法管理DAO层接口
* @author: wengtao
* @date: 2014-11-11 上午11:19:00
*
*/ 
public interface MethodMapper {
	
	public List<ApiMethodType> getMethodTypeList();
	
	public void saveMethod(ApiMethod method);
	
	public List<ApiMethod> getMethodList();
	
	public void deleteMethodById(int id);
	
	public List<ApiMethod> getMethodListByCondition(Map<String, Object> map);
	public ApiMethod getMethodById(int id);
	
	public void updateMethod(ApiMethod method);
	
	
	public List<ApiMethod> methodPageSelect(Map<String, Integer> map) throws Exception;

	public int methodConditionTotalRecord(Map<String, Object> map);

	public int methodTotalRecord() throws Exception;
	public List<ApiMethod> methodPageSelectByCondition(Map<String, Object> map);
}
