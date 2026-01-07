package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.entity.ArticleEntity;
import com.example.service.ArticleService;

@RestController
@RequestMapping("/api/home")
@CrossOrigin
public class ArticleController {
	@Autowired
	private ArticleService service;

	@PostMapping("/newPost")
	public void postArticle(@RequestBody ArticleEntity entity) {
		service.postArticle(entity);
	}

	@GetMapping("/article")
	public ArticleEntity getRest(@RequestParam(value = "id") Integer id) {

		ArticleEntity getArticle = service.getArticle(id);
		System.out.println(getArticle);
		return getArticle;
	}
}
