package model.ApiMethod;



import java.util.Date;
import java.io.Serializable;


/**
 * OoApiMethod对象定义
 * 
 * 工具自动生成代码
 * 
 * @author Admin
 *
 */
public class OoApiMethodModel implements Serializable {

    /** uid */
	private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Integer	id;
    /** 方法类别ID */
    private Integer	methodType;
    /** 方法名称 */
    private String	method;
    /** 方法中文名称 */
    private String	methodName;
    /** 方法备注 */
    private String	methodMemo;
    /**  */
    private Integer	invokeMinMaxNum;
    /**  */
    private Integer	invokeDayMaxNum;
    /** 调用等级 */
    private Integer	authLevel;
    /** 是否更新类接口(1是;0否) */
    private Integer	isUpdated;
    /** XML数据格式示例 */
    private String	xmlResult;
    /** JSON数据格式示例 */
    private String	jsonResult;
    /**  */
    private Date	createTime;
    /**  */
    private Date	updateTime;
    /** 更新人ID */
    private Integer	updateBy;
    /** 创建人ID */
    private Integer	createBy;
    /** 是否增值接口（0：开放，1：增值 默认是0） */
    private Integer	isExtras;
    /** 是否对外开放接口 */
    private Integer	isOpen;
    
    
    
    private String methodVer;
    private String methodCfg;
	
    
    
    
    
	public OoApiMethodModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OoApiMethodModel(Integer methodType, String method,
			String methodName, String methodMemo,Integer authLevel) {
		super();
		this.methodType = methodType;
		this.method = method;
		this.methodName = methodName;
		this.methodMemo = methodMemo;
		this.authLevel = authLevel;
	}

	public String getMethodVer() {
		return methodVer;
	}

	public void setMethodVer(String methodVer) {
		this.methodVer = methodVer;
	}

	public String getMethodCfg() {
		return methodCfg;
	}

	public void setMethodCfg(String methodCfg) {
		this.methodCfg = methodCfg;
	}

	/** 取得主键ID */
	public Integer getId() {
		return id;
	}
	
	/** 设置主键ID */
	public void setId(Integer id) {
		this.id = id;
	}
	/** 取得方法类别ID */
	public Integer getMethodType() {
		return methodType;
	}
	
	/** 设置方法类别ID */
	public void setMethodType(Integer methodType) {
		this.methodType = methodType;
	}
	/** 取得方法名称 */
	public String getMethod() {
		return method;
	}
	
	/** 设置方法名称 */
	public void setMethod(String method) {
		this.method = method;
	}
	/** 取得方法中文名称 */
	public String getMethodName() {
		return methodName;
	}
	
	/** 设置方法中文名称 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	/** 取得方法备注 */
	public String getMethodMemo() {
		return methodMemo;
	}
	
	/** 设置方法备注 */
	public void setMethodMemo(String methodMemo) {
		this.methodMemo = methodMemo;
	}
	/** 取得 */
	public Integer getInvokeMinMaxNum() {
		return invokeMinMaxNum;
	}
	
	/** 设置 */
	public void setInvokeMinMaxNum(Integer invokeMinMaxNum) {
		this.invokeMinMaxNum = invokeMinMaxNum;
	}
	/** 取得 */
	public Integer getInvokeDayMaxNum() {
		return invokeDayMaxNum;
	}
	
	/** 设置 */
	public void setInvokeDayMaxNum(Integer invokeDayMaxNum) {
		this.invokeDayMaxNum = invokeDayMaxNum;
	}
	/** 取得 */
	public Integer getAuthLevel() {
		return authLevel;
	}
	
	/** 设置 */
	public void setAuthLevel(Integer authLevel) {
		this.authLevel = authLevel;
	}
	/** 取得是否更新类接口(1是;0否) */
	public Integer getIsUpdated() {
		return isUpdated;
	}
	
	/** 设置是否更新类接口(1是;0否) */
	public void setIsUpdated(Integer isUpdated) {
		this.isUpdated = isUpdated;
	}
	/** 取得XML数据格式示例 */
	public String getXmlResult() {
		return xmlResult;
	}
	
	/** 设置XML数据格式示例 */
	public void setXmlResult(String xmlResult) {
		this.xmlResult = xmlResult;
	}
	/** 取得JSON数据格式示例 */
	public String getJsonResult() {
		return jsonResult;
	}
	
	/** 设置JSON数据格式示例 */
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
	/** 取得 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/** 设置 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/** 取得 */
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/** 设置 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/** 取得更新人ID */
	public Integer getUpdateBy() {
		return updateBy;
	}
	
	/** 设置更新人ID */
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	/** 取得创建人ID */
	public Integer getCreateBy() {
		return createBy;
	}
	
	/** 设置创建人ID */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/** 取得是否增值接口（0：开放，1：增值 默认是0） */
	public Integer getIsExtras() {
		return isExtras;
	}
	
	/** 设置是否增值接口（0：开放，1：增值 默认是0） */
	public void setIsExtras(Integer isExtras) {
		this.isExtras = isExtras;
	}
	/** 取得是否对外开放接口 */
	public Integer getIsOpen() {
		return isOpen;
	}
	
	/** 设置是否对外开放接口 */
	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}


}
