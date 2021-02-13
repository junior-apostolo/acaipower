package com.power.acai.service;

import java.util.List;

import com.power.acai.dto.UserDto;
import com.power.acai.model.User;


public interface UserService {
	 User save(UserDto user);
	    List<User> findAll();
	    User findOne(String username);
}
