package com.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagination.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
