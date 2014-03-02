package com.dendnight.gallery.model.vo;

import com.dendnight.gallery.model.Thumbnail;

public class ThumbnailVo extends Thumbnail {

	/** base64数据 */
	private String dataBase64;

	/** 图片路径 */
	private String imagePath;

	public String getDataBase64() {
		return dataBase64;
	}

	public void setDataBase64(String dataBase64) {
		this.dataBase64 = dataBase64;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "ThumbnailVo [dataBase64=" + dataBase64 + ", imagePath=" + imagePath + ", getId()=" + getId()
				+ ", getImageId()=" + getImageId() + ", getFilePath()=" + getFilePath() + ", getBase64Id()="
				+ getBase64Id() + ", getPublish()=" + getPublish() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getCreatedTime()=" + getCreatedTime() + ", getUpdatedBy()=" + getUpdatedBy()
				+ ", getUpdatedTime()=" + getUpdatedTime() + ", getDeleted()=" + getDeleted() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
