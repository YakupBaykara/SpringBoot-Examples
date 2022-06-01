package com.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.entity.Adres;

@Repository
public interface AdresRepository extends JpaRepository<Adres, Long>{

}
