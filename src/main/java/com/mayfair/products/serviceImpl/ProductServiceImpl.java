
package com.mayfair.products.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mayfair.products.entities.Product;
import com.mayfair.products.mapper.ProductMapper;
import com.mayfair.products.models.ProductDetails;
import com.mayfair.products.repository.ProductRepository;
import com.mayfair.products.service.ProductService;
import com.mayfair.products.generated.model.ProductRequest;
import com.mayfair.products.generated.model.ProductResponse;
import com.mayfair.products.generated.model.ProductResponse.OffersEnum;

/**
 * This class exposes all the rest end points for
 * product service api.
 *
 * @author Pooja Arora
 * @version 1.0
 * @since 2022-04-10
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductMapper productMapper;
	public static final String DEFAULT_BASKET = "DEFAULT_BASKET";

	/**
	 * Responsible for making a new product.
	 *
	 * @param productRequest must not be {@literal null}.
	 * @return
	 */

	@Override
	public ProductResponse makeProduct(ProductRequest productRequest) {

		ProductDetails productDetails = ProductDetails.builder().offersType(OffersEnum._1).build();
		return productMapper.toDto(productRepository.save(Product.builder().id(new Product().getId())
				.price(productRequest.getPrice()).name(productRequest.getName())
				.offer(productDetails.getOffersType().name()).basketName(DEFAULT_BASKET).build()));
	}

	/**
	 * Returns all products.
	 *
	 * @return
	 */
	@Override
	public List<ProductResponse> getAllProducts() {

		return productMapper.toDto(productRepository.findAll());
	}

}