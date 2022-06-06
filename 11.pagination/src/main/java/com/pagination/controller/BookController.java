package com.pagination.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.model.Book;
import com.pagination.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

	private final BookRepository bookRepository;
	
	@GetMapping
	public Page<Book> pagination(@RequestParam Integer page, @RequestParam Integer pageSize) {
		org.springframework.data.domain.Pageable pageable = PageRequest.of(page, pageSize);
		return bookRepository.findAll(pageable);
	}
	
    @GetMapping("/p")
    public Page<Book> pagination(Pageable pageable){
        // totalElements count query
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/s")
    public Slice<Book> slice(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}
