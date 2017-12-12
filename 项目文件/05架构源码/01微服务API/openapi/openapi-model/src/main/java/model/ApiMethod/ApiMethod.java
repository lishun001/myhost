package model.ApiMethod;

import java.util.Date;

public class ApiMethod {
	
	private Integer id;
	//方法类型
	public Long methodType;
	//方法名称  eg :jiuwu.user.query
	public String method;
	//类方法名称
	public String methodName;
	//方法备注
	public String methodMemo;
	//每分钟最多调用次数
	public Integer invokeMinMaxNum;
	//每天最多调用次数
	public Integer invokeDayMaxNum;
	//调用级别
	public Integer authLevel;
	//创建时间
	public Date createTime;
	//修改时间
	public Date updateTime;
	
	//是否更新类接口
	public  Integer isUpdated;
	public String xmlResult;
	public String jsonResult;
	//是否增值接口
	public  Integer isExtras;
	//是否对外开放接口
	public  Integer isOpen;
	
	
	//接口方法类型
	private String cateDescription;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getMethodType() {
		return methodType;
	}
	public void setMethodType(Long methodType) {
		this.methodType = methodType;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getMethodMemo() {
		return methodMemo;
	}
	public void setMethodMemo(String methodMemo) {
		this.methodMemo = methodMemo;
	}
	public Integer getInvokeMinMaxNum() {
		return invokeMinMaxNum;
	}
	public void setInvokeMinMaxNum(Integer invokeMinMaxNum) {
		this.invokeMinMaxNum = invokeMinMaxNum;
	}
	public Integer getInvokeDayMaxNum() {
		return invokeDayMaxNum;
	}
	public void setInvokeDayMaxNum(Integer invokeDayMaxNum) {
		this.invokeDayMaxNum = invokeDayMaxNum;
	}
	public Integer getAuthLevel() {
		return authLevel;
	}
	public void setAuthLevel(Integer authLevel) {
		this.authLevel = authLevel;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getIsUpdated() {
		return isUpdated;
	}
	public void setIsUpdated(Integer isUpdated) {
		this.isUpdated = isUpdated;
	}
	public String getXmlResult() {
		return xmlResult;
	}
	public void setXmlResult(String xmlResult) {
		this.xmlResult = xmlResult;
	}
	public String getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
	public Integer getIsExtras() {
		return isExtras;
	}
	public void setIsExtras(Integer isExtras) {
		this.isExtras = isExtras;
	}
	public Integer getIsOpen() {
		return isOpen;
	}
	public String getCateDescription() {
		return cateDescription;
	}
	public void setCateDescription(String cateDescription) {
		this.cateDescription = cateDescription;
	}
	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}
}
