package com.dendnight.gallery.extend;

import java.io.Serializable;

public class UploadProgressInfo implements Serializable {

	private static final long serialVersionUID = 2840241306527214712L;

	private long readedBytes = 0L;
	private long totalBytes = 0L;
	private int currentItem = 0;

	public long getReadedBytes() {
		return readedBytes;
	}

	public void setReadedBytes(long readedBytes) {
		this.readedBytes = readedBytes;
	}

	public long getTotalBytes() {
		return totalBytes;
	}

	public void setTotalBytes(long totalBytes) {
		this.totalBytes = totalBytes;
	}

	public int getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(int currentItem) {
		this.currentItem = currentItem;
	}

}
