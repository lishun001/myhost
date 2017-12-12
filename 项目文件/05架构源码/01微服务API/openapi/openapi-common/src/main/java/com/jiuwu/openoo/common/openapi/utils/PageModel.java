package com.jiuwu.openoo.common.openapi.utils;

import java.util.List;

/**
 * 分页工具类
 * 
 * @param <T>
 * @author wengtao
 * @date：2014-9-9 上午10:55:23
 */
public final class PageModel<T> {

	private int currentPage;// 当前页
	private int pageSize;// 每页显示条数
	private int totalPage;// 总页数
	private int totalRecord;// 总记录数
	
	private List<T> dataList;// 分页数据

	private PageModel() {
	}

	private PageModel(final int pageSize, final String page,
			final int totalRecord) {
		// 初始化每页显示条数
		this.pageSize = pageSize;
		// 设置总记录数
		this.totalRecord = totalRecord;
		// 初始化总页数
		setTotalPage();
		// 初始化当前页
		setCurrentPage(page);

	}

	/*
	 * 外界获得PageModel实例
	 */
	@SuppressWarnings("unchecked")
	public static PageModel newPageModel(final int pageSize, final String page,
			final int totalRecord) {

		return new PageModel(pageSize, page, totalRecord);
	}

	// 设置当前请求页
	private void setCurrentPage(String page) {
		try {
			currentPage = Integer.parseInt(page);

		} catch (java.lang.NumberFormatException e) {
			// 这里异常不做处理，当前页默认为1
			currentPage = 1;
		}
		// 如果当前页小于第一页时，当前页指定到首页
		if (currentPage < 1) {

			currentPage = 1;
		}
//add by wengtao
/*		if (currentPage > totalPage) {

			currentPage = totalPage;

		}*/

	}

	private void setTotalPage() {
		if (totalRecord % pageSize == 0) {

			totalPage = totalRecord / pageSize;
		} else {
			totalPage = totalRecord / pageSize + 1;
		}
	}

	/*
	 * 获得当前页
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/*
	 * 获得总页数
	 */
	public int getTotalPage() {
		return totalPage;

	}

	/*
	 * 获得开始行数
	 */
	public int getStartRow() {
		return (currentPage - 1) * pageSize;
	}

	/*
	 * 获得结束行
	 */
	public int getEndRow() {
		return currentPage * pageSize;
	}

	/*
	 * 获得翻页数据
	 */
	public List<T> getDataList() {
		return dataList;
	}

	/*
	 * 设置翻页数据
	 */
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	// 首页
	public int getFirst() {

		return 1;
	}

	//
	// 上一页

	public int getPrevious() {

		return currentPage - 1;
	}

	// // 下一页
	public int getNext() {

		return currentPage + 1;
	}

	// // 尾页
	public int getLast() {

		return totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
}
