package com.dendnight.gallery.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.base.BaseAction;
import com.dendnight.base.PaginatedList;
import com.dendnight.gallery.criteria.ThumbnailCriteria;
import com.dendnight.gallery.model.vo.ThumbnailVo;
import com.dendnight.gallery.service.ThumbnailService;

/**
 * 图库信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年2月20日 下午9:29:05  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller("GalleryAction")
@Scope("prototype")
public class GalleryAction extends BaseAction {

	private static final long serialVersionUID = 7099263402897874899L;

	@Autowired
	private ThumbnailService thumbnailService;

	/** 页码 */
	private Integer page = 1;

	public String listOneself() {
		json = new HashMap<String, Object>();

		if (timeout) {
			json.put(T, 1);
			return JSON;
		}

		ThumbnailCriteria criteria = new ThumbnailCriteria();
		criteria.setPage(page);
		criteria.setUserId(info().getId());

		PaginatedList<ThumbnailVo> list = thumbnailService.list(criteria, info());

		// 处理数据，去除不必要的字段及内容
		List<Map<String, Object>> thumbnail = new ArrayList<Map<String, Object>>();

		if (null != list && null != list.getResult() && 0 < list.getResult().size()) {
			Map<String, Object> map = null;

			for (ThumbnailVo it : list.getResult()) {
				map = new HashMap<String, Object>();
				map.put("imageId", it.getImageId());
				map.put("filePath", it.getFilePath());

				map.put("base64", it.getDataBase64());
				thumbnail.add(map);
			}
		}

		json.put(S, 1);
		json.put(O, thumbnail);
		return JSON;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

}
