package com.postgresql.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.postgresql.dto.KisiDto;

public interface KisiService {
	
	KisiDto save(KisiDto kisiDto);
	
	void delete(Long id);
	
	List<KisiDto> getAll();
	
	Page<KisiDto> getAll(Pageable pageable);

}
