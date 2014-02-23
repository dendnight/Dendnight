package com.dendnight.gallery.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.base.BaseAction;
import com.dendnight.base.Commons;
import com.dendnight.gallery.model.Thumbnail;
import com.dendnight.gallery.service.DataBase64Service;
import com.dendnight.gallery.service.ThumbnailService;
import com.dendnight.utils.Md5Utils;

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

	private static final long serialVersionUID = 6374328329827914564L;

	@Autowired
	private ThumbnailService thumbnailService;

	@Autowired
	private DataBase64Service dataBase64Service;

	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;

	public String execute() {
		json = new HashMap<String, Object>();

		// 验证图片
		// 控制图片类型
		if (null == uploadFile || !Commons.IMAGETYPE.contains(uploadFileContentType)
				|| Commons.IMAGE_MAX_SIZE < uploadFile.length()) {
			json.put(S, 0);
			json.put(M, "请上传符合要求的图片");
			return JSON;
		}

		// try {
		// HttpServletRequest request = ServletActionContext.getRequest();
		// HttpSession session = request.getSession(true);
		// UploadInfo progressInfo = (UploadInfo)
		// session.getAttribute(Commons.IMG_PROGRESS_INFO);
		// if (progressInfo != null) {
		// progressInfo.setStatus(UploadInfo.STATUS_DONE);
		// progressInfo.setBytesRead(progressInfo.getTotalSize());
		// session.setAttribute(Commons.IMG_PROGRESS_INFO, progressInfo);
		// }
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// return INPUT;
		// }

		// 路径 FIXME
		// TODO 缩略图
		File thumbnailFile = null;
		String realPath = "/";// ServletActionContext.getServletContext().getRealPath("../../images");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String dateTime = sdf.format(date);

		realPath += dateTime;

		System.out.println(date.getTime());
		String imageFileName = UUID.randomUUID() + uploadFileFileName.substring(uploadFileFileName.lastIndexOf('.'));

		// TODO 新文件名
		System.out.println(imageFileName);

		// 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
		File imageFile = new File(new File(realPath), imageFileName);
		// 判断路径是否存在
		if (!imageFile.getParentFile().exists()) {
			// 如果不存在，则递归创建此路径
			imageFile.getParentFile().mkdirs();
		}

		System.out.println("原文件名" + uploadFileFileName);
		System.out.println("文件类型" + uploadFileContentType);
		System.out.println("图片路径：" + imageFile.getParentFile());
		System.out.println("图片MD5：" + Md5Utils.getMd5ByFile(uploadFile));
		// 缩略图
		try {
			Thumbnails.of(uploadFile).size(200, 300).toFile("c:/a380_200x300.jpg");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			// 将原文件保存到硬盘上,Struts2会帮我们自动删除临时文件
			FileUtils.copyFile(uploadFile, imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Thumbnail thumbnail = new Thumbnail();
		// thumbnail.set
		thumbnailService.add(thumbnail, info());
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
