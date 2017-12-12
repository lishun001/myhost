package com.openapi.model.request.author;

import com.jiuwu.openoo.common.openapi.FileItem;
import com.jiuwu.openoo.common.openapi.request.Request;

public class CarCompanyAuthorRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 231612212902363399L;
	private Integer userId;		//'申请人'
	private String companyName;	//'企业名称'
	private String businessNo;	//'企业登记号'
	private String legalPerson;	//法人姓名
	private String legalPhone;	//法人电话 
	private String idCard;		//'身份证号'
	private FileItem idCardPic;	//'身份证照片'
	private FileItem businessPic;	//'企业的营业执照'
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLegalPhone() {
		return legalPhone;
	}
	public void setLegalPhone(String legalPhone) {
		this.legalPhone = legalPhone;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public FileItem getIdCardPic() {
		return idCardPic;
	}
	public void setIdCardPic(FileItem idCardPic) {
		this.idCardPic = idCardPic;
	}
	public FileItem getBusinessPic() {
		return businessPic;
	}
	public void setBusinessPic(FileItem businessPic) {
		this.businessPic = businessPic;
	}
	
	
	
}
