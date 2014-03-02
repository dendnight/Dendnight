package com.dendnight.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单字典
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月23日 上午12:35:23  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class Commons {

	/** 图片上传进度信息 */
	public static final String IMAGE_PROGRESS_INFO = "progress";

	/** 图片类型 */
	public static final List<String> IMAGETYPE = new ArrayList<String>();
	static {
		IMAGETYPE.add("image/jpg");
		IMAGETYPE.add("image/jpeg");
		IMAGETYPE.add("image/gif");
		IMAGETYPE.add("image/bmp");
		IMAGETYPE.add("image/png");
		IMAGETYPE.add("image/pjpeg");
		IMAGETYPE.add("image/x-icon");
	}

	/** 图片文件最大值 5MB */
	public static final Long IMAGE_MAX_SIZE = 5242880L;

	/** 图片根目录 */
	public static final String IMAGE_ROOT = "/home/dendnight/";
}
