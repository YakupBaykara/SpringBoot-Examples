package com.apidoc.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Benim Pet nesnem", description = "Benim Pet")
public class Pet {
	
	@ApiModelProperty("Pet nesnesinin tekil ID alanı")
	private int id;
	
	@ApiModelProperty("Pet nesnesinin Ad alanı")
	private String name;
	
	@ApiModelProperty("Pet nesnesinin Tarih alanı")
	private Date date;
}
