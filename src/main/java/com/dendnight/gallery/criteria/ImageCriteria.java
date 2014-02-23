package com.dendnight.gallery.criteria;

import com.dendnight.base.Pagination;

public class ImageCriteria extends Pagination {

	private static final long serialVersionUID = -997800092816498061L;

	@Override
	public String getDefaultSort() {
		return "created_time";
	}

	@Override
	public String[] getValidSortFields() {
		// TODO Auto-generated method stub
		return null;
	}

}
