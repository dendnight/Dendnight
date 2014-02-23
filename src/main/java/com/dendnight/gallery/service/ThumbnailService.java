package com.dendnight.gallery.service;

import com.dendnight.base.LoginInfo;
import com.dendnight.base.PaginatedList;
import com.dendnight.gallery.criteria.ThumbnailCriteria;
import com.dendnight.gallery.model.Thumbnail;

/**
 * 缩略图接口
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月23日 下午3:17:07  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public interface ThumbnailService {

	/**
	 * 添加缩略图
	 * 
	 * @param thumbnail
	 * @param info
	 * @return
	 */
	int add(Thumbnail thumbnail, LoginInfo info);

	/**
	 * 删除
	 * 
	 * @param id
	 * @param info
	 */
	void del(int id, LoginInfo info);

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @param info
	 * @return
	 */
	Thumbnail find(int id, LoginInfo info);

	/**
	 * 查询缩略图列表
	 * 
	 * @param criteria
	 * @param info
	 * @return
	 */
	PaginatedList<Thumbnail> list(ThumbnailCriteria criteria, LoginInfo info);

	/**
	 * 修改缩略图
	 * 
	 * @param thumbnail
	 * @param info
	 */
	void update(Thumbnail thumbnail, LoginInfo info);
}
