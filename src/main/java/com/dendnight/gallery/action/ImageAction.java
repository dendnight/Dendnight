package com.dendnight.gallery.action;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.base.BaseAction;
import com.dendnight.gallery.model.Image;
import com.dendnight.gallery.service.ImageService;

/**
 * 图片业务
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年2月24日 下午7:57:57  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller("ImageAction")
@Scope("prototype")
public class ImageAction extends BaseAction {

	private static final long serialVersionUID = 4395866955703891802L;

	@Autowired
	private ImageService imageService;

	/** 图片ID */
	private String imageId;

	public String execute() {

		json = new HashMap<String, Object>();

		if (timeout) {
			json.put(T, 1);
			return JSON;
		}
		Image image = imageService.find(imageId, info());

		if (null == image || image.getCreatedBy().intValue() != info().getId()) {
			json.put(S, 0);
			json.put(M, "图片不存在");
			return JSON;
		}
		json.put(S, 0);
		json.put(O, image.getFilePath());
		return JSON;
	}
}
