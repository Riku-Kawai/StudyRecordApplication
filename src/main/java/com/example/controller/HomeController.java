package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.entity.CardEntity;
import com.example.model.entity.UserEntity;
import com.example.service.HomeService;
import com.example.service.UserModuleService;

@RestController
@RequestMapping("/api/home")
@CrossOrigin
public class HomeController {

	@Autowired
	private HomeService service;

	@Autowired
	private UserModuleService userModuleService;

	/** ホームページ呼び出し処理*/
	@GetMapping
	public List<CardEntity> getHome() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		String username = (String) principal;
		UserEntity loginUser = userModuleService.
		getUserInfo(username);

		/* カード情報を取得する */
		List<CardEntity> response = service.getCard();
		return response;
	}
}
