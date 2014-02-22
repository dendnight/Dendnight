package com.dendnight.base;

import java.io.Serializable;
import java.util.List;

/**
 * 分页集合
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2014  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月16日 下午3:10:06  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class PaginatedList<T> implements Serializable {

	private static final long serialVersionUID = -2582060677791599460L;

	/**
	 * 分页结果集
	 */
	private List<T> result;

	/**
	 * 分页信息
	 */
	private Pagination pagination;

	/**
	 * @return the result
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(List<T> result) {
		this.result = result;
	}

	/**
	 * @return the pagination
	 */
	public Pagination getPagination() {
		return pagination;
	}

	/**
	 * @param pagination
	 *            the pagination to set
	 */
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
