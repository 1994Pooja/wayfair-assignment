package com.mayfair.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mayfair.products.entities.Product;
import com.mayfair.products.generated.model.ProductRequest;
import com.mayfair.products.generated.model.ProductResponse;
import com.mayfair.products.generated.model.ProductResponse.OffersEnum;

public class ObjectBuilderUtility {

	public static ProductRequest buildProductRequest() {
		ProductRequest productRequest = new ProductRequest();
		productRequest.setName("Sony TV");
		productRequest.setPrice(new BigDecimal(10000));
		return productRequest;
	}

	public static ProductResponse buildProductResponse() {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setId("1");
		productResponse.setName("Sony TV");
		productResponse.setPrice(new BigDecimal(10000));
		productResponse.setOffers(OffersEnum._1);
		productResponse.setBasketName("Default-Basket");

		return productResponse;

	}

	public static List<ProductResponse> buildProductResponseList() {
		List<ProductResponse> productResponseList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			ProductResponse productResponse = new ProductResponse();
			productResponse.setId("1");
			productResponse.setName("Sony TV");
			productResponse.setPrice(new BigDecimal(10000));
			productResponse.setOffers(OffersEnum._1);
			productResponse.setBasketName("Default-Basket");
			productResponseList.add(productResponse);
		}
		return productResponseList;

	}

	public static List<Product> createProductList() {
		List<Product> productList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Product product = new Product();
			product.setId("1");
			product.setName("Samsung TV");
			product.setPrice(new BigDecimal(1000));
			product.setOffer("Offer-1");
			product.setBasketName("Default_Basket");
			productList.add(product);
		}
		return productList;
	}
}
