package model.ApiMethod;



import java.util.Date;
import java.io.Serializable;


/**
 * OoAppInfo对象定义
 * 
 * 工具自动生成代码
 * 
 * @author Admin
 *
 */
public class OoAppInfoModel implements Serializable {

    /** uid */
	private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Integer	id;
    /** app名称 */
    private String	appName;
    /** app key */
    private String	appKey;
    /** app secret */
    private String	appSecret;
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
    /** 最低版本 */
    private String	lowestVersion;
	
	
	/** 取得主键ID */
	public Integer getId() {
		return id;
	}
	
	/** 设置主键ID */
	public void setId(Integer id) {
		this.id = id;
	}
	/** 取得app名称 */
	public String getAppName() {
		return appName;
	}
	
	/** 设置app名称 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/** 取得app key */
	public String getAppKey() {
		return appKey;
	}
	
	/** 设置app key */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	/** 取得app secret */
	public String getAppSecret() {
		return appSecret;
	}
	
	/** 设置app secret */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
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

	public String getLowestVersion() {
		return lowestVersion;
	}

	public void setLowestVersion(String lowestVersion) {
		this.lowestVersion = lowestVersion;
	}


}
