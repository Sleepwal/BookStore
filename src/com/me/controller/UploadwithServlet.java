package com.me.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet("/UploadwithServlet")
public class UploadwithServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig servletconfig;
    public UploadwithServlet() {
        super();
    }
 
	public void init(ServletConfig config) throws ServletException {
		this.servletconfig = config;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 1.实例化一个SmartUpload对象
		SmartUpload su = new SmartUpload(); 
	    // 2.初始化 SmartUpload对象
		try{
		    su.initialize(servletconfig, request, response); 
		}catch(ServletException el){
			el.printStackTrace();
		}
		// 3.设置文件上传的限制
		su.setAllowedFilesList("jpg, JPG, png, PNG, gif, GIF");
		//单个文件的最大字节数
		su.setMaxFileSize(3*1024*1024*1024); 
		// 文件的总最大字节数
		su.setTotalMaxFileSize(12*1024*1024*1024); 
		//4.使用upload上传
		try {
			su.upload();
		}catch(ServletException | SmartUploadException | IOException e2){
			e2.printStackTrace();
		}

		//5.文件的保存	
		Date curDate = new Date();
		long d = curDate.getTime();//long型
		//获取上传文件
		//获取全部上传文件
		Files files = su.getFiles();
		//获取指定位置的文件
		File file = files.getFile(0);
		//获取文件扩展名
		String extFile = file.getFileExt();
		String mainFile = String.valueOf(d);
		//文件上传到服务器端的upload目录下，文件以当前时间命名
//		String filename = "/client/images/ad/" + mainFile + "." + extFile;
		String filename="/client/"+mainFile+"."+extFile;
		try {
			file.saveAs(filename);	
			//获取服务器本地存放位置
			String fileDir = request.getRealPath("")+ '\\'+"upload";					
			System.out.println(" 文件上传成功，存放于服务器目录："+ fileDir);
		} catch(IOException | SmartUploadException e1){
			e1.printStackTrace();
		}
	}
}
