package com.mayfair.products.models;

import java.math.BigDecimal;

import com.mayfair.products.generated.model.ProductResponse.OffersEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetails {
	
	private String id;
	private String name;
	private BigDecimal price;
	private OffersEnum offersType;
	private String basketName;
}
