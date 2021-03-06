package com.dendnight.gallery.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.base.BaseAction;
import com.dendnight.base.Commons;
import com.dendnight.gallery.extend.UploadProgressInfo;
import com.dendnight.gallery.model.DataBase64;
import com.dendnight.gallery.model.Image;
import com.dendnight.gallery.model.Thumbnail;
import com.dendnight.gallery.service.DataBase64Service;
import com.dendnight.gallery.service.ImageService;
import com.dendnight.gallery.service.ThumbnailService;
import com.dendnight.utils.ImageUtils;
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

	Logger log = Logger.getLogger(UploadImageAction.class);

	@Autowired
	private ThumbnailService thumbnailService;

	@Autowired
	private DataBase64Service dataBase64Service;

	@Autowired
	private ImageService imageService;

	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;

	public String execute() {

		json = new HashMap<String, Object>();

		if (timeout) {
			json.put(T, 1);
			return JSON;
		}

		// 验证图片
		if (null == uploadFile || !Commons.IMAGETYPE.contains(uploadFileContentType)
				|| Commons.IMAGE_MAX_SIZE < uploadFile.length()) {
			errorProgressInfo();
			json.put(S, 0);
			json.put(M, "请上传符合要求的图片");
			return JSON;
		}

		// 缩略图
		String base64Str = "";
		try {
			// FIXME 200 宽度不变
			// 缩略图toBase64统一用“jpg”格式
			base64Str = "data:jpg;base64,"
					+ ImageUtils.encodeToString(Thumbnails.of(uploadFile).width(200).outputFormat("jpg")
							.asBufferedImage(), "jpg");
		} catch (IOException e) {
			log.warn(e);

			errorProgressInfo();
			json.put(S, 0);
			json.put(M, "上传失败");
			return JSON;
		}

		// 图片
		String md5 = Md5Utils.getMd5ByFile(uploadFile);

		Image imageOld = imageService.find(md5, info());
		if (null == imageOld) {
			int imgWidth = 0;// FIXME 图片属性
			int imgHeight = 0;
			String path = "";
			try {
				// 图片路径 FIXME
				// ServletActionContext.getServletContext().getRealPath("/images");
				String dateTime = new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
				String uuid = UUID.randomUUID().toString();

				path = "pictures/" + dateTime + uuid
						+ uploadFileFileName.substring(uploadFileFileName.lastIndexOf('.'));
				// 创建一个新 File 实例
				File imageFile = new File(Commons.IMAGE_ROOT + path);
				// 判断路径是否存在
				if (!imageFile.getParentFile().exists()) {
					// 如果不存在，则递归创建此路径
					imageFile.getParentFile().mkdirs();
				}

				// 将原文件保存到硬盘上,Struts2会帮我们自动删除临时文件
				FileUtils.copyFile(uploadFile, imageFile);
			} catch (IOException e) {
				log.warn(e);
				errorProgressInfo();

				json.put(S, 0);
				json.put(M, "上传失败");
				return JSON;
			}

			Image image = new Image();
			image.setFilePath(path);
			image.setHeight(imgHeight);

			image.setWidth(imgWidth);
			image.setFormat(uploadFileContentType);
			image.setFileSize(Integer.parseInt(uploadFile.length() + ""));// XXX

			image.setId(md5);

			// TODO 还有很多属性

			imageService.add(image, info());
		}
		DataBase64 dataBase64 = new DataBase64();
		dataBase64.setData(base64Str);
		int db64Id = dataBase64Service.add(dataBase64);

		Thumbnail thumbnail = new Thumbnail();
		thumbnail.setBase64Id(db64Id);
		thumbnail.setFilePath(null);// XXX 不用

		thumbnail.setImageId(md5);
		thumbnail.setPublish(1);
		thumbnailService.add(thumbnail, info());

		progressInfo();
		json.put(S, 1);
		json.put(M, "上传成功");

		return JSON;
	}

	/**
	 * 进度条信息
	 */
	private void progressInfo() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		UploadProgressInfo info = (UploadProgressInfo) session.getAttribute(Commons.IMAGE_PROGRESS_INFO);
		if (info != null) {
			info.setReadedBytes(info.getTotalBytes());
			session.setAttribute(Commons.IMAGE_PROGRESS_INFO, info);
		}
	}

	/**
	 * 失败了的进度条信息
	 */
	private void errorProgressInfo() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		UploadProgressInfo info = (UploadProgressInfo) session.getAttribute(Commons.IMAGE_PROGRESS_INFO);
		if (info != null) {
			info.setReadedBytes(0);
			session.setAttribute(Commons.IMAGE_PROGRESS_INFO, info);
		}
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
