package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.entity.ArticleEntity;

@Mapper
public interface ArticleMapper {
	void postArticle(ArticleEntity entity);
	ArticleEntity getArticle(@Param("id") Integer id);
}
