package com.dendnight.gallery.extend;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.ProgressListener;

import com.dendnight.base.Commons;

public class UploadProgressListener implements ProgressListener {

	HttpServletRequest request = null;
	UploadProgressInfo info = null;

	public UploadProgressListener(HttpServletRequest request) {
		this.request = request;
		info = (UploadProgressInfo) request.getSession().getAttribute(Commons.IMAGE_PROGRESS_INFO);
		if (null == info) {
			info = new UploadProgressInfo();
			// uploadInfo
			request.getSession().setAttribute(Commons.IMAGE_PROGRESS_INFO, info);
		}
	}

	public void update(long pBytesRead, long pContentLength, int pItems) {

		System.out.println(pBytesRead);

		info.setReadedBytes(pBytesRead);
		info.setCurrentItem(pItems);
		info.setTotalBytes(pContentLength);

	}

}
