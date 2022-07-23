package com.me.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
public class DownloadwithServlet extends HttpServlet {
	ServletConfig config = null;
    public DownloadwithServlet() {
        super();
     }
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建一个SmartUpload对象
		SmartUpload su = new SmartUpload();
		// 初始化
		su.initialize(config, request, response);
		// 设定contentDisposition为null以禁止浏览器自动打开文件，保证单击链接后是下载文件。
		// 若不设定，则下载的文件扩展名为.doc时，浏览器将自动用Word打开它；
		// 当扩展名为.pdf时，浏览器将用PDF阅读器打开它。
		su.setContentDisposition(null);
		// 下载文件
		try {
			su.downloadFile("/upload/休息一下.bmp");
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}
}
