package model.ApiMethod;

import java.io.Serializable;

/**
 * OoApiMethodCategory对象定义
 * 
 * 工具自动生成代码
 * 
 * @author Admin
 *
 */
public class OoApiMethodCategoryModel implements Serializable {

    /** uid */
	private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Integer	id;
    /** 方法类别英文名称 */
    private String	cateEnName;
    /** 类别中文名称 */
    private String	cateCnName;
    /** 类别描述 */
    private String	cateDescription;
    /**  */
    private Integer	isDeleted;
	
	
	/** 取得主键ID */
	public Integer getId() {
		return id;
	}
	
	/** 设置主键ID */
	public void setId(Integer id) {
		this.id = id;
	}
	/** 取得方法类别英文名称 */
	public String getCateEnName() {
		return cateEnName;
	}
	
	/** 设置方法类别英文名称 */
	public void setCateEnName(String cateEnName) {
		this.cateEnName = cateEnName;
	}
	/** 取得类别中文名称 */
	public String getCateCnName() {
		return cateCnName;
	}
	
	/** 设置类别中文名称 */
	public void setCateCnName(String cateCnName) {
		this.cateCnName = cateCnName;
	}
	/** 取得类别描述 */
	public String getCateDescription() {
		return cateDescription;
	}
	
	/** 设置类别描述 */
	public void setCateDescription(String cateDescription) {
		this.cateDescription = cateDescription;
	}
	/** 取得 */
	public Integer getIsDeleted() {
		return isDeleted;
	}
	
	/** 设置 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}


}
