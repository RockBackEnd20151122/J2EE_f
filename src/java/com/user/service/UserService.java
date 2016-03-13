package com.user.service;

import com.user.dto.UserDto;

public interface UserService {
	static final String CAN_LOGIN = "可以登录";
	static final String PASSWORS_IS_WRONG = "密码错误";
	static final String UESR_NAME_NOT_EXISTS = "用户名不存在";

	void addUser(UserDto userDto);

	String judgCanLogin(UserDto userDto);
}
