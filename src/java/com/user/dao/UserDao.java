package com.user.dao;

import com.user.dto.UserDto;

public interface UserDao {
	void addUser(UserDto userDto);

	UserDto selectUserByUserName(String userName);
}
