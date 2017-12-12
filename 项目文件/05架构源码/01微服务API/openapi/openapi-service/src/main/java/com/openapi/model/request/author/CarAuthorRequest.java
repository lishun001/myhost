package com.openapi.model.request.author;

import com.jiuwu.openoo.common.openapi.FileItem;
import com.jiuwu.openoo.common.openapi.request.Request;

public class CarAuthorRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 231612212902363399L;
	private Integer userId;		//'申请人'
	private String authorName;	//认证名
	private Integer carId;		//车辆id
	private String idCard;		//'身份证号'
	private FileItem idCardPic;	//'身份证照片'
	private FileItem operationCardPic;	//'运营证照片'
	private FileItem carCardPic; //'驾驶证照片'
	
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
	public FileItem getOperationCardPic() {
		return operationCardPic;
	}
	public void setOperationCardPic(FileItem operationCardPic) {
		this.operationCardPic = operationCardPic;
	}
	public FileItem getCarCardPic() {
		return carCardPic;
	}
	public void setCarCardPic(FileItem carCardPic) {
		this.carCardPic = carCardPic;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
}
