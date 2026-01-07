package com.example.service.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.model.entity.UserEntity;
import com.example.service.UserModuleService;

@Service
public class UserModuleServiceImpl implements UserModuleService {
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserEntity getUserInfo(String userName) {
		UserEntity userInfo = userMapper.findByUsername(userName);
		return userInfo;
	}

	@Override
	public void registerUser(UserEntity user) {
		// ユーザー名の重複チェック
		if (userMapper.findByUsername(user.getUsername()) != null) {
			throw new IllegalArgumentException("Username already exists.");
		}

		// パスワードのハッシュ化
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		// ユーザーをDBに保存
		userMapper.save(user);
	}
	
}
