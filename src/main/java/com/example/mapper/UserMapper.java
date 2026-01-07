package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.entity.UserEntity;

@Mapper
public interface UserMapper {
	//ログイン機能実施
	UserEntity findByUsername(@Param("username") String username);

	void save(UserEntity user);
}
