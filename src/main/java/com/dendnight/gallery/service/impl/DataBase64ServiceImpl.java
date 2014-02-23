package com.dendnight.gallery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dendnight.gallery.mapper.DataBase64Mapper;
import com.dendnight.gallery.model.DataBase64;
import com.dendnight.gallery.service.DataBase64Service;

/**
 * base64接口实现
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月23日 下午5:30:38  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Service("DataBase64Service")
public class DataBase64ServiceImpl implements DataBase64Service {

	@Autowired
	private DataBase64Mapper dataBase64Mapper;

	public int add(DataBase64 dataBase64) {
		dataBase64Mapper.insertSelective(dataBase64);
		return dataBase64.getId();
	}

	public DataBase64 find(int id) {
		return dataBase64Mapper.selectByPrimaryKey(id);
	}

}
