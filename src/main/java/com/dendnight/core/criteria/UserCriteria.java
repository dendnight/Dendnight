package com.dendnight.core.criteria;

import com.dendnight.core.Pagination;

/**
 * 用户信息查询条件
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年2月18日 下午9:49:18  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class UserCriteria extends Pagination {

	private static final long serialVersionUID = -5710522463905156204L;

	/** 是否删除 */
	private Integer deleted = 0;

	/** 用户名 */
	private String username;

	@Override
	public String getDefaultSort() {
		return "created_time";
	}

	@Override
	public String[] getValidSortFields() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserCriteria [deleted=" + deleted + "]";
	}

}
