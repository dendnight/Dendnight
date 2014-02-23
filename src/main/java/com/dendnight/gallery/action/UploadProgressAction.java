package com.dendnight.gallery.action;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.base.BaseAction;
import com.dendnight.base.Commons;
import com.dendnight.gallery.extend.UploadInfo;

/**
 * 上传进度
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年2月23日 上午2:38:03  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller("UploadProgressAction")
@Scope("prototype")
public class UploadProgressAction extends BaseAction {

	private static final long serialVersionUID = -8612812298817388417L;

	public String execute() {

		json = new HashMap<String, Object>();
		json.put(S, 0);

		HttpSession session = ServletActionContext.getRequest().getSession();
		UploadInfo progressInfo = (UploadInfo) session.getAttribute(Commons.IMAGE_PROGRESS_INFO);

		if (progressInfo != null) {
			json.put(S, 1);
			json.put(Commons.IMAGE_PROGRESS_INFO, progressInfo);
		}

		return JSON;
	}

}
