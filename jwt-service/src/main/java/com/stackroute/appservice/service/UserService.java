package com.stackroute.appservice.service;

import com.stackroute.appservice.domain.User;
import com.stackroute.appservice.exception.UserAlreadyExistException;
import com.stackroute.appservice.exception.UserNotFoundException;

public interface UserService {

	public User saveUser(User user)throws UserAlreadyExistException;
	public User findByIdAndPassword(String id, String password) throws UserNotFoundException;
}
