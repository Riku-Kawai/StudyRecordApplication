package com.example.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.CardMapper;
import com.example.model.entity.CardEntity;
import com.example.service.HomeService;
@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private CardMapper mapper;

	@Override
	public List<CardEntity> getCard() {
		/* カード情報を取得する */
		List<CardEntity> responseCard = mapper.getCardData();

		return responseCard;
	}
}
