package com.dendnight.gallery.service;

import com.dendnight.base.LoginInfo;
import com.dendnight.gallery.model.Image;

/**
 * 图片接口
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月23日 下午3:14:00  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public interface ImageService {

	/**
	 * 添加图片
	 * 
	 * @param image
	 * @param info
	 */
	void add(Image image, LoginInfo info);

	/**
	 * 查询图片
	 * 
	 * @param id
	 * @param info
	 * @return
	 */
	Image find(String id, LoginInfo info);
}
