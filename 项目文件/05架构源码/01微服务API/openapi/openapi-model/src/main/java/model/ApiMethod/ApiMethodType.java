package model.ApiMethod;

/**
* @ClassName: MethodType
* @Description:API方法类型
* @author: wengtao
* @date: 2014-11-11 上午11:02:21
*
*/ 
public class ApiMethodType {
	
	private Integer id;
	private String cateCnName;
	private String cateDescription;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCateCnName() {
		return cateCnName;
	}
	public void setCateCnName(String cateCnName) {
		this.cateCnName = cateCnName;
	}
	public String getCateDescription() {
		return cateDescription;
	}
	public void setCateDescription(String cateDescription) {
		this.cateDescription = cateDescription;
	}
	

}
