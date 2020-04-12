package com.nagarro.nagp.msa2.userservice.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.nagp.msa2.userservice.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public User getUser(int id) {
		LOGGER.info("Fetching user for user id:{} from DB", id);
		return mongoTemplate.findOne(new Query().addCriteria(Criteria.where("id").is(id)), User.class);
	}

}
