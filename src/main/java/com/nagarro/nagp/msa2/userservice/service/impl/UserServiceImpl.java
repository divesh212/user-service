package com.nagarro.nagp.msa2.userservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.msa2.userservice.entity.User;
import com.nagarro.nagp.msa2.userservice.entity.UserDetails;
import com.nagarro.nagp.msa2.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserDetails getUser(int id) {
		Optional<User> user = getAllUsers().stream().filter(u -> u.getId() == id).findFirst();
		if (user.isPresent()) {
			LOGGER.info("Returning user for user id:{} - {}", id, user.get());
			return user.get().getUserDetails();
		} else {
			LOGGER.info("No user found for user id: {}", id);
			return null;
		}
	}

	private List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User(1, new UserDetails("divesh1", "21", "divesh21@abc.com")));
		users.add(new User(2, new UserDetails("divesh2", "22", "divesh22@abc.com")));
		users.add(new User(3, new UserDetails("divesh3", "23", "divesh23@abc.com")));
		users.add(new User(4, new UserDetails("divesh4", "24", "divesh24@abc.com")));

		return users;
	}

}
