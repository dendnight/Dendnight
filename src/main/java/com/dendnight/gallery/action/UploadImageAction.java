package com.dendnight.gallery.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.base.BaseAction;
import com.dendnight.base.Commons;
import com.dendnight.gallery.extend.UploadInfo;

/**
 * 上传图片
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月23日 上午2:37:46  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller("UploadImageAction")
@Scope("prototype")
public class UploadImageAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;

	public String execute() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession(true);
			UploadInfo progressInfo = (UploadInfo) session.getAttribute(Commons.IMG_PROGRESS_INFO);
			if (progressInfo != null) {
				progressInfo.setStatus(UploadInfo.STATUS_DONE);
				progressInfo.setBytesRead(progressInfo.getTotalSize());
				session.setAttribute(Commons.IMG_PROGRESS_INFO, progressInfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		json = new HashMap<String, Object>();

		String realPath = ServletActionContext.getServletContext().getRealPath("../../images");
		SimpleDateFormat sdf = new SimpleDateFormat("/yyMM/ddHH");
		Date date = new Date();
		String dateTime = sdf.format(date);

		realPath += dateTime;

		System.out.println(uploadFileFileName);
		System.out.println(date.getTime());
		String newFileName = ("" + date.getTime()).substring(6)
				+ uploadFileFileName.substring(uploadFileFileName.lastIndexOf('.'));

		System.out.println(newFileName);
		System.out.println(uploadFileContentType);
		// 控制图片类型
		if (uploadFileContentType.equals("image/gif") || uploadFileContentType.equals("image/jpeg")
				|| uploadFileContentType.equals("image/png") || uploadFileContentType.equals("image/bmp")
				|| uploadFileContentType.equals("image/x-icon") || uploadFileContentType.equals("image/pjpeg")) {
			// 判断文件是否为空,并且文件不能大于2M
			if (uploadFile != null && uploadFile.length() < 2097152) {
				// 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
				File filePath = new File(new File(realPath), newFileName);
				// 判断路径是否存在
				if (!filePath.getParentFile().exists()) {
					// 如果不存在，则递归创建此路径
					filePath.getParentFile().mkdirs();
				}

				System.out.println(filePath.getParentFile());
				// 将文件保存到硬盘上,Struts2会帮我们自动删除临时文件
				try {
					FileUtils.copyFile(uploadFile, filePath);
				} catch (IOException e) {
					System.out.println("图片上传失败");
					e.printStackTrace();
				}
			}
		}
		json.put(S, 1);
		return JSON;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

}
