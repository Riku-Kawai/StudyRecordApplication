package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.ArticleMapper;
import com.example.model.entity.ArticleEntity;
import com.example.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleMapper mapper;

	@Override
	public void postArticle(ArticleEntity entity) {
		mapper.postArticle(entity);
	}

	@Override
	public ArticleEntity getArticle(Integer id) {

		ArticleEntity getArticle = mapper.getArticle(id);
		return getArticle;
	}

}
