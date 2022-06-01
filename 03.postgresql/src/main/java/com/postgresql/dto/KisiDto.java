package com.postgresql.dto;

import java.util.List;

import lombok.Data;

@Data
public class KisiDto {

	private Long id;
	private String ad;
	private String soyad;
	private List<String> adresler;
}
