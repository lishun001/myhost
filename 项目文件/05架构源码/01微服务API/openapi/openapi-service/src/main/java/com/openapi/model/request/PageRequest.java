package com.openapi.model.request;

import com.jiuwu.openoo.common.openapi.request.Request;

/**
 * 分页 Request
 * 
 * @author eason
 */
public class PageRequest extends Request {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5978972533503756942L;
	
	/** 当前页数*/
	private Integer position; 
	/**每页显示数量*/
	private Integer pageSize; 


	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}
