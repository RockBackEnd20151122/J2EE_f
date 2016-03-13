package com.user.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.user.dto.UserDto;
import com.user.service.UserService;
import com.util.FileManager;

public class UserAction extends ActionSupport {
	private UserDto userDto;
	private String message;
	private UserService userService;
	
	private List<File> files;
	// 提交过来的文件名字
	private List<String> filesFileName;
	// 文件的类型
	private List<String> fileContentType;

	private FileManager fileManager;

	public String login() {
		if (userDto.getUserName() == null
				|| userDto.getUserName().trim().equals("")) {
			this.message = "用户名为空";
			return ERROR;

		}
		if (userDto.getPassword() == null
				|| userDto.getPassword().trim().equals("")) {
			this.message = "密码为空";
			return ERROR;

		}
		this.message = this.userService.judgCanLogin(userDto);
		if (this.message.equals(UserService.CAN_LOGIN)) {
			ServletActionContext.getRequest().getSession()
					.setAttribute("userName", userDto.getUserName());
			ServletActionContext.getRequest().getSession()
					.setAttribute("loginTime", new Date());
			ServletActionContext.getRequest().getSession()
					.setAttribute("headImage", userDto.getHeadImage());
			return SUCCESS;
		}
		return ERROR;
	}

	public String addUser() {
		System.out.println("aaaa");
		try {
			List<String> fileNameList = this.fileManager.uploadFileList(files,
					filesFileName, fileContentType);
			this.userDto.setHeadImage(fileNameList.get(0));
			this.userService.addUser(userDto);
			this.message = "注册成功";
		} catch (Exception e) {
			Logger.getLogger("stdout").error(e.getCause());
			Logger.getLogger("FILE").error(e.getCause());
			this.message = "注册失败";
			return ERROR;
		}
		return SUCCESS;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<String> getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(List<String> filesFileName) {
		this.filesFileName = filesFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public FileManager getFileManager() {
		return fileManager;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

}
