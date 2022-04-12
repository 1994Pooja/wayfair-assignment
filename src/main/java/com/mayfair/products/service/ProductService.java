package com.mayfair.products.service;

import java.util.List;

import com.mayfair.products.generated.model.ProductRequest;
import com.mayfair.products.generated.model.ProductResponse;

public interface ProductService {
	
		ProductResponse makeProduct(ProductRequest productRequest);
		List<ProductResponse> getAllProducts();

	}

