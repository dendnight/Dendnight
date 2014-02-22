package com.dendnight.gallery.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dendnight.gallery.extend.UploadInfo;
import com.opensymphony.xwork2.ActionSupport;

public class UploadProgressAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String id;
	public static int percent = 0;

	public String execute() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			if (id != null) {
				UploadInfo progressInfo = (UploadInfo) session.getAttribute(id);
				if (progressInfo != null) {
					response.setContentType("text/html;charset=UTF-8");
					write2Client(out, getInfo(progressInfo));// info
					return null;
				}
			}
			write2Client(out, "{status:\"done\"}");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInfo(UploadInfo info) {
		if (info != null) {
			StringBuffer sb = new StringBuffer("{status:\"" + info.getStatus() + "\",");
			sb.append("bytes_uploaded:\"" + info.getBytesRead() + "\",");
			sb.append("bytes_total:\"" + info.getTotalSize() + "\"");
			sb.append("}");
			return sb.toString();
		}
		return "{status:\"failed\"}";
	}

	public void write2Client(PrintWriter out, String html) {
		out.write(html);
		out.flush();
		out.close();
	}
}
