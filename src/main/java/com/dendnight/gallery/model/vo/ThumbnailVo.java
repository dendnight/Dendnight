package com.dendnight.gallery.model.vo;

import com.dendnight.gallery.model.Thumbnail;

public class ThumbnailVo extends Thumbnail {

	/** base64数据 */
	private String dataBase64;

	public String getDataBase64() {
		return dataBase64;
	}

	public void setDataBase64(String dataBase64) {
		this.dataBase64 = dataBase64;
	}

}
