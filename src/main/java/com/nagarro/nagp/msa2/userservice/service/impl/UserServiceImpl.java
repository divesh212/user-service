package com.nagarro.nagp.msa2.userservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.msa2.userservice.entity.User;
import com.nagarro.nagp.msa2.userservice.entity.UserDetails;
import com.nagarro.nagp.msa2.userservice.repository.UserRepository;
import com.nagarro.nagp.msa2.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserDetails getUser(int id) {
		User user = userRepository.getUser(id);
		if (null != user) {
			LOGGER.info("Returning user for user id:{} - {}", id, user);
			return user.getUserDetails();
		} else {
			LOGGER.info("No user found for user id: {}", id);
			return null;
		}
	}

}
