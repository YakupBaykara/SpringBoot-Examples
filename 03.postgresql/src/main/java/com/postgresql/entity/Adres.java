package com.postgresql.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "kisi_adres")
@Data
public class Adres implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_kisi_adres", allocationSize = 1)
	@GeneratedValue(generator = "seq_kisi_adres", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "adres", length = 500)
	private String adres;
	
	@Enumerated
	private AdresTip adresTip;
	
	@Column(name = "aktif")
	private Boolean aktif;
	
	@ManyToOne
	@JoinColumn(name = "kisiId")
	private Kisi kisi;
	
	public enum AdresTip{
		EV_ADRESI, IS_ADRESI, DIGER
	}
}
