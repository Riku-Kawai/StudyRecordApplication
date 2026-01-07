package com.example.auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.mapper.UserMapper;
import com.example.model.entity.UserEntity;

@Service
@CrossOrigin
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserMapper userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserEntity entity = userRepository.findByUsername(username);

			return new CustomUserDetails(entity.getUsername(), entity.getPassword() ,Collections.emptyList());
		} catch (Exception e) {
			throw new UsernameNotFoundException("ユーザーが見つかりません");
		}
	}
}
