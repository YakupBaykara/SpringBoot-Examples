package com.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.entity.Kisi;

@Repository
public interface KisiRepository extends JpaRepository<Kisi, Long>{

}
