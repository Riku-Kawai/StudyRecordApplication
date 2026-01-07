package com.example.service;

import com.example.model.entity.UserEntity;

public interface UserModuleService {
	
	UserEntity getUserInfo(String userName);

	void registerUser(UserEntity user);

}

