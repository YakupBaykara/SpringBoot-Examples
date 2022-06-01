package com.postgresql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.postgresql.dto.KisiDto;
import com.postgresql.entity.Adres;
import com.postgresql.entity.Kisi;
import com.postgresql.repository.AdresRepository;
import com.postgresql.repository.KisiRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {
	
	private final KisiRepository kisiRepository;
	private final AdresRepository adresRepository;

	@Override
	@Transactional
	public KisiDto save(KisiDto kisiDto) {
		
//		Assert.isNull(kisiDto.getAd(), "Ad alanı zorunludur!");
		
		Kisi kisi = new Kisi();
		kisi.setAd(kisiDto.getAd());
		kisi.setSoyad(kisiDto.getSoyad());
		final Kisi kisiDb = kisiRepository.save(kisi);
		
		List<Adres> liste = new ArrayList<>();
		
		kisiDto.getAdresler().forEach(item -> {
			Adres adres = new Adres();
			adres.setAdres(item);
			adres.setAdresTip(com.postgresql.entity.Adres.AdresTip.DIGER);
			adres.setAktif(true);
			adres.setKisi(kisiDb);
			liste.add(adres);
		});
		adresRepository.saveAll(liste);
		kisiDto.setId(kisiDb.getId());
		return kisiDto;
	}

	@Override
	public void delete(Long id) {		
	}

	@Override
	public List<KisiDto> getAll() {
		List<Kisi> kisiler = kisiRepository.findAll();
		List<KisiDto> kisiDtos = new ArrayList<>();
		
		kisiler.forEach(it ->{
			KisiDto kisiDto = new KisiDto();
			kisiDto.setId(it.getId());
			kisiDto.setAd(it.getAd());
			kisiDto.setSoyad(it.getSoyad());
			kisiDto.setAdresler(it.getAdresler().stream().map(Adres::getAdres).collect(Collectors.toList()));
			kisiDtos.add(kisiDto);
		});		
		return kisiDtos;
	}

	@Override
	public Page<KisiDto> getAll(Pageable pageable) {
		return null;
	}
	


}
