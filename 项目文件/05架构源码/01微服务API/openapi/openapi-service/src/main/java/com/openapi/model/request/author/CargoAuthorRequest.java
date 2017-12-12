package com.openapi.model.request.author;

import com.jiuwu.openoo.common.openapi.FileItem;
import com.jiuwu.openoo.common.openapi.request.Request;

public class CargoAuthorRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 231612212902363399L;
	private Integer userId;		//'申请人'
	private String authorName;	//认证名
	private String idCard;		//'身份证号'
	private FileItem idCardPic;	//'身份证照片'
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
	
}
