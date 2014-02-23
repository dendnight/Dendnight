package com.dendnight.gallery.service;

import com.dendnight.gallery.model.DataBase64;

/**
 * base64数据接口
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月23日 下午5:28:46  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public interface DataBase64Service {

	/**
	 * 添加
	 * 
	 * @param dataBase64
	 * @return
	 */
	int add(DataBase64 dataBase64);

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */
	DataBase64 find(int id);
}
