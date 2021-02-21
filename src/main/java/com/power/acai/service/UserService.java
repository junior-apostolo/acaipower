package com.power.acai.service;

import java.util.List;

import javax.validation.Valid;

import com.power.acai.dto.UserDto;
import com.power.acai.model.User;
import com.power.acai.util.exception.ObjectNotFoundException;


public interface UserService {
	 User save(UserDto user);
	    List<User> findAll();
	    User findOne(String username);
		void sendNewPassword(@Valid String email) throws ObjectNotFoundException;
}
