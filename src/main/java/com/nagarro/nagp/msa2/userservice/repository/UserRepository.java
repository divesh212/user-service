package com.nagarro.nagp.msa2.userservice.repository;

import com.nagarro.nagp.msa2.userservice.entity.User;

public interface UserRepository {
	User getUser(int id);
}
