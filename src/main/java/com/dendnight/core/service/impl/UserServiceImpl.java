package com.dendnight.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dendnight.base.LoginInfo;
import com.dendnight.base.PaginatedList;
import com.dendnight.core.criteria.UserCriteria;
import com.dendnight.core.mapper.UserMapper;
import com.dendnight.core.model.User;
import com.dendnight.core.service.UserService;
import com.dendnight.utils.Md5Utils;

/**
 * 用户信息接口实现
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年2月18日 下午10:07:40  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public int add(User user, LoginInfo info) throws Exception {
		user.setPassword(Md5Utils.getMd5ByStr(user.getPassword()));
		userMapper.insertSelective(user);
		return user.getId();
	}

	public void del(int id, LoginInfo info) {
		User user = new User();
		user.setId(id);
		user.setDeleted(1);

		user.setUpdatedBy(info.getId());
		user.setUpdatedTime(new Date());
		userMapper.updateByPrimaryKeySelective(user);
	}

	public PaginatedList<User> list(UserCriteria criteria, LoginInfo info) {
		PaginatedList<User> result = new PaginatedList<User>();
		List<User> list = new ArrayList<User>();

		if (0 < criteria.getPagesize()) {
			int count = userMapper.count(criteria);
			criteria.setTotal(count);
			if (count > 0) {
				list = userMapper.list(criteria);
			}
		} else {
			list = userMapper.list(criteria);
		}

		result.setPagination(criteria);
		result.setResult(list);
		return result;
	}

	public User find(int id, LoginInfo info) {
		return userMapper.selectByPrimaryKey(id);
	}

	public void update(User user, LoginInfo info) {
		user.setUpdatedBy(info.getId());
		user.setUpdatedTime(new Date());
		userMapper.updateByPrimaryKeySelective(user);
	}

}
