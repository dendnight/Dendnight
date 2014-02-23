package com.dendnight.gallery.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dendnight.base.LoginInfo;
import com.dendnight.base.PaginatedList;
import com.dendnight.gallery.criteria.ThumbnailCriteria;
import com.dendnight.gallery.mapper.ThumbnailMapper;
import com.dendnight.gallery.model.Thumbnail;
import com.dendnight.gallery.service.ThumbnailService;

/**
 * 缩略图实现类
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月23日 下午3:43:14  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Service("ThumbnailService")
public class ThumbnailServiceImpl implements ThumbnailService {

	@Autowired
	private ThumbnailMapper thumbnailMapper;

	public int add(Thumbnail thumbnail, LoginInfo info) {
		thumbnail.setCreatedBy(info.getId());
		thumbnailMapper.insertSelective(thumbnail);
		return thumbnail.getId();
	}

	public void del(int id, LoginInfo info) {
		Thumbnail thumbnail = new Thumbnail();
		thumbnail.setId(id);
		thumbnail.setUpdatedBy(info.getId());

		thumbnail.setUpdatedTime(new Date());
		thumbnail.setDeleted(1);
		thumbnailMapper.updateByPrimaryKeySelective(thumbnail);

	}

	public Thumbnail find(int id, LoginInfo info) {
		return thumbnailMapper.selectByPrimaryKey(id);
	}

	public PaginatedList<Thumbnail> list(ThumbnailCriteria criteria, LoginInfo info) {
		PaginatedList<Thumbnail> result = new PaginatedList<Thumbnail>();
		List<Thumbnail> list = new ArrayList<Thumbnail>();

		if (0 < criteria.getPagesize()) {
			int count = thumbnailMapper.count(criteria);
			criteria.setTotal(count);
			if (count > 0) {
				list = thumbnailMapper.list(criteria);
			}
		} else {
			list = thumbnailMapper.list(criteria);
		}

		result.setPagination(criteria);
		result.setResult(list);
		return result;
	}

	public void update(Thumbnail thumbnail, LoginInfo info) {
		thumbnail.setUpdatedBy(info.getId());
		thumbnail.setUpdatedTime(new Date());
		thumbnailMapper.updateByPrimaryKeySelective(thumbnail);
	}

}
