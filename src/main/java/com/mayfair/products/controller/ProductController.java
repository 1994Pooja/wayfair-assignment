package com.mayfair.products.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mayfair.products.service.ProductService;
import com.mayfair.products.generated.api.ProductsApi;
import com.mayfair.products.generated.model.ProductRequest;
import com.mayfair.products.generated.model.ProductResponse;

@RestController
public class ProductController implements ProductsApi {

	@Autowired
	ProductService productService;

	@Override
	public ResponseEntity<ProductResponse> createProduct(@Valid ProductRequest productRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.makeProduct(productRequest));
	}

	@Override
	public ResponseEntity<List<ProductResponse>> getProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
	}

}
