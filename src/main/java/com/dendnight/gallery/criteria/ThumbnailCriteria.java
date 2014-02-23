package com.dendnight.gallery.criteria;

import com.dendnight.base.Pagination;

/**
 * 缩略图查询条件
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月23日 下午3:30:33  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class ThumbnailCriteria extends Pagination {

	private static final long serialVersionUID = 7196662967404436393L;

	@Override
	public String getDefaultSort() {
		return "created_time";
	}

	@Override
	public String[] getValidSortFields() {
		// TODO Auto-generated method stub
		return null;
	}

}
