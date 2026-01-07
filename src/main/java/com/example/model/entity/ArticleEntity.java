package com.example.model.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ArticleEntity {
	private Integer id;
	private String name;
	private Integer user_id;
	private String title;
	private String report;
	private Timestamp entry_time;
	private Timestamp update_time;

}
