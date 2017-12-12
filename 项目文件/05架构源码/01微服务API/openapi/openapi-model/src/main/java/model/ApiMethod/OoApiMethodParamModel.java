package model.ApiMethod;

import java.util.Date;
import java.io.Serializable;


/**
 * OoApiMethodParam对象定义
 * 
 * 工具自动生成代码
 * 
 * @author Admin
 *
 */
public class OoApiMethodParamModel implements Serializable {

    /** uid */
	private static final long serialVersionUID = 1L;
    /**  */
    private Integer	id;
    /** 方法ID */
    private Integer	methodId;
    /** 参数名称 */
    private String	paramName;
    /** 参数类型 */
    private String	paramType;
    /** 是否必须(1是,0否) */
    private Integer	isNecessary;
    /** 示例值 */
    private String	example;
    /** 默认值 */
    private String	defaultValue;
    /** 参数描述 */
    private String	paramDescription;
    /** 参数类别(1应用级参数;2返回结果属性) */
    private Integer	 paramClass;
    /** 是否自定义对象(1是,0否) */
    private Integer 	isObject;
    /**  */
    private Date	createTime;
	
	
	/** 取得 */
	public Integer getId() {
		return id;
	}
	
	/** 设置 */
	public void setId(Integer id) {
		this.id = id;
	}
	/** 取得方法ID */
	public Integer getMethodId() {
		return methodId;
	}
	
	/** 设置方法ID */
	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}
	/** 取得参数名称 */
	public String getParamName() {
		return paramName;
	}
	
	/** 设置参数名称 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	/** 取得参数类型 */
	public String getParamType() {
		return paramType;
	}
	
	/** 设置参数类型 */
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	/** 取得是否必须(1是,0否) */
	public Integer getIsNecessary() {
		return isNecessary;
	}
	
	/** 设置是否必须(1是,0否) */
	public void setIsNecessary(Integer isNecessary) {
		this.isNecessary = isNecessary;
	}
	/** 取得示例值 */
	public String getExample() {
		return example;
	}
	
	/** 设置示例值 */
	public void setExample(String example) {
		this.example = example;
	}
	/** 取得默认值 */
	public String getDefaultValue() {
		return defaultValue;
	}
	
	/** 设置默认值 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	/** 取得参数描述 */
	public String getParamDescription() {
		return paramDescription;
	}
	
	/** 设置参数描述 */
	public void setParamDescription(String paramDescription) {
		this.paramDescription = paramDescription;
	}
	/** 取得参数类别(1应用级参数;2返回结果属性) */
	public Integer getParamClass() {
		return paramClass;
	}
	
	/** 设置参数类别(1应用级参数;2返回结果属性) */
	public void setParamClass(Integer paramClass) {
		this.paramClass = paramClass;
	}
	/** 取得是否自定义对象(1是,0否) */
	public Integer getIsObject() {
		return isObject;
	}
	
	/** 设置是否自定义对象(1是,0否) */
	public void setIsObject(Integer isObject) {
		this.isObject = isObject;
	}
	/** 取得 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/** 设置 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


}
