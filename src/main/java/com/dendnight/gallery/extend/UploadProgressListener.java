package com.dendnight.gallery.extend;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.ProgressListener;

import com.dendnight.base.Commons;

public class UploadProgressListener implements ProgressListener {

	private long megaBytes = -1;
	HttpServletRequest request = null;
	UploadInfo progressInfo = null;

	public UploadProgressListener(HttpServletRequest request) {
		this.request = request;
		progressInfo = (UploadInfo) request.getSession().getAttribute(Commons.IMG_PROGRESS_INFO);
		if (null == progressInfo) {
			progressInfo = new UploadInfo();
			// uploadInfo
			request.getSession().setAttribute(Commons.IMG_PROGRESS_INFO, progressInfo);
		}
	}

	public void update(long pBytesRead, long pContentLength, int pItems) {

		long mBytes = pBytesRead / (16 * 1024);

		if (megaBytes == mBytes) {
			return;
		}
		megaBytes = mBytes;
		if (pContentLength == -1) {
			progressInfo.setStatus(UploadInfo.STATUS_DONE);
		} else {
			progressInfo.setFileIndex(pItems);
			progressInfo.setTotalSize(pContentLength);
			progressInfo.setBytesRead(pBytesRead);
			progressInfo.setStatus(UploadInfo.STATUS_PROGRESS);
		}
	}

}
