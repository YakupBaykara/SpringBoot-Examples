package com.versioning.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.dto.ProductV1;
import com.versioning.dto.ProductV2;

@RestController
@RequestMapping("/api")
public class ProductController {

	
	// URI Versioning
	// http://localhost:8080/api/v1/product
	@GetMapping("/v1/product")
	public ResponseEntity<ProductV1> pathVersioningV1() {
		return ResponseEntity.of(Optional.of(new ProductV1("HP Laptop")));
	}
	
	// http://localhost:8080/api/v2/product
	@GetMapping("/v2/product")
	public ResponseEntity<ProductV2> pathVersioningV2() {
		return ResponseEntity.of(Optional.of(new ProductV2("HP Laptop", BigDecimal.TEN)));
	}
	
	//Parameter Versioning
	// http://localhost:8080/api/param/product?apiVersion=1
	@GetMapping(value = "/param/product", params = "apiVersion=1")
	public ResponseEntity<ProductV1> paramVersioningV1() {
		return ResponseEntity.of(Optional.of(new ProductV1("HP Laptop")));
	}
	
	// http://localhost:8080/api/param/product?apiVersion=2
	@GetMapping(value = "/param/product", params = "apiVersion=2")
	public ResponseEntity<ProductV2> paramVersioningV2() {
		return ResponseEntity.of(Optional.of(new ProductV2("HP Laptop", BigDecimal.TEN)));
	}
	
	// Header Versioning
	// http://localhost:8080/api/header/product
	@GetMapping(value = "/header/product", headers = "X-API-VERSION=1")
	public ResponseEntity<ProductV1> headerVersioningV1() {
		return ResponseEntity.of(Optional.of(new ProductV1("HP Laptop")));
	}
	
	// http://localhost:8080/api/header/product
	@GetMapping(value = "/header/product", headers = "X-API-VERSION=2")
	public ResponseEntity<ProductV2> headerVersioningV2() {
		return ResponseEntity.of(Optional.of(new ProductV2("HP Laptop", BigDecimal.TEN)));
	}
}
