package com.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elasticsearch.entity.Kisi;

@Repository
public interface KisiRepository extends ElasticsearchRepository<Kisi, String>{

	@Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": \"?0\"}}]}}")
	List<Kisi> getByCustomQuery(String search);

	List<Kisi> findByAdLikeAndSoyadLike(String ad, String soyad);
}
