package com.user.service.impl;

import java.util.Date;

import com.user.dao.UserDao;
import com.user.dto.UserDto;
import com.user.service.UserService;
import com.util.BaseUtil;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	@Override
	public String judgCanLogin(UserDto userDto) {
		UserDto userDtoIndb = this.userDao.selectUserByUserName(userDto
				.getUserName());
		if (userDtoIndb == null) {
			return UESR_NAME_NOT_EXISTS;
		}
		if (!userDtoIndb.getPassword().equals(userDto.getPassword())) {
			return PASSWORS_IS_WRONG;
		}
		userDto.setHeadImage(userDtoIndb.getHeadImage()); 
		return CAN_LOGIN;
	}

	public void addUser(UserDto userDto) {
		userDto.setUserId(BaseUtil.getUUID());
		userDto.setUserStatus("01");
		userDto.setRegisterTime(new Date());
		userDto.setCreateBy(userDto.getUserName());
		userDto.setCreateTime(new Date());
		userDto.setUpdateBy(userDto.getUserName());
		userDto.setUpdateTime(new Date());
		this.userDao.addUser(userDto);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
