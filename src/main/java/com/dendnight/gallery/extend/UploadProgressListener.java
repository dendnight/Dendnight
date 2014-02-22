package com.dendnight.gallery.extend;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.ProgressListener;

public class UploadProgressListener implements ProgressListener {

	private long megaBytes = -1;
	HttpServletRequest request = null;
	UploadInfo progressInfo = null;

	public UploadProgressListener(HttpServletRequest request) {
		this.request = request;
		String progressKey = (String)request.getParameter("id");
		progressInfo = (UploadInfo) request.getSession().getAttribute( progressKey);
		if (progressKey !=null && progressInfo == null) {
			progressInfo = new UploadInfo();	
			// uploadInfo
			request.getSession().setAttribute(progressKey, progressInfo);
		}
	}

	public void update(long pBytesRead, long pContentLength, int pItems) {

		long mBytes = pBytesRead / (16*1024);

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
