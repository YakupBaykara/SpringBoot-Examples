package com.postgresql.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "kisi")
@Data
public class Kisi implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id()
	@SequenceGenerator(name = "seq_kisi", allocationSize = 1)
	@GeneratedValue(generator = "seq_kisi", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "ad", length = 500)
	private String ad;
	
	@Column(name = "soyad", length = 500)
	private String soyad;
	
	@OneToMany(mappedBy = "kisi")	
	private List<Adres> adresler;

}
