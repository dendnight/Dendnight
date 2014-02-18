package com.dendnight.basis.service;

import com.dendnight.LoginInfo;
import com.dendnight.PaginatedList;
import com.dendnight.basis.criteria.UserCriteria;
import com.dendnight.basis.model.User;

/**
 * 用户信息服务接口
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月18日 下午9:41:48  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public interface UserService {

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @param info
	 * @return
	 * @throws Exception
	 */
	int add(User user, LoginInfo info) throws Exception;

	/**
	 * 删除用户信息
	 * 
	 * @param id
	 * @param info
	 */
	void del(int id, LoginInfo info);

	/**
	 * 查询用户列表
	 * 
	 * @param criteria
	 * @param info
	 * @return
	 */
	PaginatedList<User> list(UserCriteria criteria, LoginInfo info);

	/**
	 * 查询单个用户信息
	 * 
	 * @param id
	 * @param info
	 * @return
	 */
	User find(int id, LoginInfo info);

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @param info
	 */
	void update(User user, LoginInfo info);

}
