package com.example.model.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.sql.Date;

@Data
public class CardEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	@Email
	private String email;
	private String title;
	private Date entry_time;
	private Integer id;
}
