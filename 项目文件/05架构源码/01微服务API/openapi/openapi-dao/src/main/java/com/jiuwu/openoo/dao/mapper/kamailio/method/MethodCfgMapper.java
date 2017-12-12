package com.jiuwu.openoo.dao.mapper.kamailio.method;

import java.util.List;
import java.util.Map;

import model.ApiMethod.ApiMethod;
import model.ApiMethod.ApiMethodCfg;

/**
* @ClassName: MethodCfgMapper
* @Description:API接口配置管理DAO层接口
* @author: wengtao
* @date: 2014-11-11 上午11:19:00
*
*/ 
public interface MethodCfgMapper {
	
	public void saveMethodCfg(ApiMethodCfg methodCfg);
	
	public List<ApiMethodCfg> getMethodCfgList();
	public List<ApiMethodCfg> getMethodCfgListByCondition(Map<String, Object> map);
	public void deleteMethodCfgById(int id);
	
	public ApiMethodCfg getMethodCfgById(int id);
	
	public void updateMethodCfg(ApiMethodCfg methodCfg);
	
	public List<ApiMethod> getMethodList();
	
	
	public List<ApiMethodCfg> methodcfgPageSelect(Map<String, Integer> map) throws Exception;

	public int methodcfgConditionTotalRecord(Map<String, Object> map);

	public int methodcfgTotalRecord() throws Exception;
	public List<ApiMethodCfg> methodcfgPageSelectByCondition(Map<String, Object> map);
}
