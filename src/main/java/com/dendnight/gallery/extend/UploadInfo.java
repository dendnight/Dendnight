package com.dendnight.gallery.extend;

import java.io.Serializable;

public class UploadInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String STATUS_START = "start";
	public static final String STATUS_PROGRESS = "progress";
	public static final String STATUS_DONE = "done";
	private long totalSize = 0;
	private long bytesRead = 0;
	private long elapsedTime = 0;
	private String status = STATUS_DONE;

	private int fileIndex = 0;

	public int getFileIndex() {
		return fileIndex;
	}

	public void setFileIndex(int fileIndex) {
		this.fileIndex = fileIndex;
	}

	public UploadInfo() {
	}

	public UploadInfo(long totalSize, long bytesRead, long elapsedTime, String status) {
		this.totalSize = totalSize;
		this.bytesRead = bytesRead;
		this.elapsedTime = elapsedTime;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public long getBytesRead() {
		return bytesRead;
	}

	public void setBytesRead(long bytesRead) {
		this.bytesRead = bytesRead;
	}

	public long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public boolean isInProgress() {
		return STATUS_PROGRESS.equals(status) || STATUS_START.equals(status);
	}
}
