package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.entity.ArticleEntity;

@Service
public interface ArticleService {
	void postArticle(ArticleEntity eintity);
	ArticleEntity getArticle(Integer id);
}
