package com.situ.struts.upload;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.situ.struts.pojo.User;

public class FileUpload extends ActionSupport {
	private User user;
	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public File getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		
		String path=ServletActionContext.getServletContext().getRealPath("/upload");
		
		File destFile = new File(path,fileUploadFileName);
		
		FileUtils.copyFile(fileUpload,destFile);
		
		return SUCCESS;
	}
}
