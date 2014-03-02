package com.dendnight.core.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.base.BaseAction;

/**
 * 跳转页面
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年3月2日 下午2:01:12  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller("TransmitAction")
@Scope("prototype")
public class TransmitAction extends BaseAction {

	private static final long serialVersionUID = -4747941941981334134L;

	// 跳转至图库
	public String gallery() {
		return SUCCESS;
	}
}
