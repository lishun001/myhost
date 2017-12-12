package model.ApiMethod;



import java.util.Date;
import java.io.Serializable;


/**
 * OoApiMethodCfg对象定义
 * 
 * 工具自动生成代码
 * 
 * @author Admin
 *
 */
public class OoApiMethodCfgModel implements Serializable {

    /** uid */
	private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Integer	id;
    /**  */
    private Integer	methodId;
    /** 版本号 */
    private String	ver;
    /** 配置值 */
    private String	cfgValue;
    /** 删除标识。1：删除 0：未删除 */
    private Integer	isDeleted;
    /** 更新时间 */
    private Date	createTime;
    /** 更新时间 */
    private Date	updateTime;
    /** 创建者id */
    private Integer	createBy;
    /** 更新者id */
    private Integer	updateBy;
	
	
    
    
	public OoApiMethodCfgModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OoApiMethodCfgModel(Integer methodId,String cfgValue) {
		super();
		this.methodId = methodId;
		this.cfgValue = cfgValue;
	}

	/** 取得主键ID */
	public Integer getId() {
		return id;
	}
	
	/** 设置主键ID */
	public void setId(Integer id) {
		this.id = id;
	}
	/** 取得 */
	public Integer getMethodId() {
		return methodId;
	}
	
	/** 设置 */
	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}
	/** 取得版本号 */
	public String getVer() {
		return ver;
	}
	
	/** 设置版本号 */
	public void setVer(String ver) {
		this.ver = ver;
	}
	/** 取得配置值 */
	public String getCfgValue() {
		return cfgValue;
	}
	
	/** 设置配置值 */
	public void setCfgValue(String cfgValue) {
		this.cfgValue = cfgValue;
	}
	/** 取得删除标识。1：删除 0：未删除 */
	public Integer getIsDeleted() {
		return isDeleted;
	}
	
	/** 设置删除标识。1：删除 0：未删除 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	/** 取得更新时间 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/** 设置更新时间 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/** 取得更新时间 */
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/** 设置更新时间 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/** 取得创建者id */
	public Integer getCreateBy() {
		return createBy;
	}
	
	/** 设置创建者id */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/** 取得更新者id */
	public Integer getUpdateBy() {
		return updateBy;
	}
	
	/** 设置更新者id */
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}


}
