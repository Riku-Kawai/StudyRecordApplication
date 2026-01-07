package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.entity.CardEntity;

@Mapper
public interface CardMapper {
	List<CardEntity> getCardData();
}
