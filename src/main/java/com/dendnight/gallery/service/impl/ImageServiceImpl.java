package com.dendnight.gallery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dendnight.base.LoginInfo;
import com.dendnight.gallery.mapper.ImageMapper;
import com.dendnight.gallery.model.Image;
import com.dendnight.gallery.service.ImageService;

/**
 * 图片接口实现
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月23日 下午6:44:39  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Service("ImageService")
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageMapper imageMapper;

	public void add(Image image, LoginInfo info) {
		image.setCreatedBy(info.getId());
		imageMapper.insertSelective(image);
	}

	public Image find(String id, LoginInfo info) {
		return imageMapper.selectByPrimaryKey(id);
	}
}
