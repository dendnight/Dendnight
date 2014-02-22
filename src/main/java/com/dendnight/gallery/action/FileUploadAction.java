package com.dendnight.gallery.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dendnight.gallery.extend.UploadInfo;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String id;
	private File[] upload;
	private String[] uploadFileContentType;
	private String[] uploadFileFileName;

	public String execute() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession(true);
			UploadInfo progressInfo = (UploadInfo) session.getAttribute(id);
			if (progressInfo != null) {
				progressInfo.setStatus(UploadInfo.STATUS_DONE);// set status
																// done.
				progressInfo.setBytesRead(progressInfo.getTotalSize());// set
																		// read
																		// as
																		// total
																		// size.
				session.setAttribute(id, progressInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String[] uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String[] getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String[] uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

}
