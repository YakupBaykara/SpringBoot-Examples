package com.resttemplate.model;

import java.util.List;

import lombok.Data;

@Data
public class KisiDto {

	public Long id;
	public String ad;
	public String soyad;
	public List<String> adresler;
}
