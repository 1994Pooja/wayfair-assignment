package com.mayfair.products.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mayfair.products.entities.Product;
import com.mayfair.products.generated.model.ProductResponse;


@Mapper(componentModel = "spring")
public interface ProductMapper extends IEntityMapper<ProductResponse, Product> {
	

	@Mapping(target ="id", source="id")
	@Mapping(target ="name", source="name")
	@Mapping(target ="price", source="price")
	@Mapping(target ="offers", source="offer")
	@Mapping(target ="basketName", source="basketName")
	ProductResponse toDto(Product entity);
	
}