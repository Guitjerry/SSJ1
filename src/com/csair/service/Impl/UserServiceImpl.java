package com.csair.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csair.entity.User;
import com.csair.repository.UserRepository;
import com.csair.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
	UserRepository repository;
	public UserRepository getRepository() {
		return repository;
	}
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

}
