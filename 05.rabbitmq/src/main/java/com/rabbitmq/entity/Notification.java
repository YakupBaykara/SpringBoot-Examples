package com.rabbitmq.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Notification implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date createDate;
	private Boolean seen;
	private String message;

}
