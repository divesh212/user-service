package com.nagarro.nagp.msa2.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.msa2.userservice.entity.User;
import com.nagarro.nagp.msa2.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int id) {
		LOGGER.info("Get user request received for user id: {}", id);
		return userService.getUser(id);
	}

}
