package com.mayfair.products.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayfair.products.ObjectBuilderUtility;
import com.mayfair.products.generated.model.ProductRequest;
import com.mayfair.products.generated.model.ProductResponse;
import com.mayfair.products.mapper.ProductMapper;
import com.mayfair.products.service.ProductService;



@WebMvcTest(value = ProductController.class)
@ActiveProfiles("default")
@OverrideAutoConfiguration(enabled = true)
 class ProductControllerTests {

	
	@MockBean
	ProductService productsService;
	
	@MockBean
	ProductMapper productsMapper;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@Test
	@DisplayName("CreateProductsSuccessTest")
	void createProductsSuccessTest() throws Exception {
		ProductRequest productsRequest = ObjectBuilderUtility.buildProductRequest();
		ProductResponse productsResponse=ObjectBuilderUtility.buildProductResponse();
		
		when(productsService.makeProduct(productsRequest)).thenReturn(productsResponse);
		
		String url="/products";
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(url)
																	  .contentType(MediaType.APPLICATION_JSON_VALUE)
																	  .accept(MediaType.APPLICATION_JSON)
																	  .characterEncoding("UTF-8")
																	  .content(this.mapper.writeValueAsBytes(productsResponse));
	
		mockMvc.perform(builder).andExpect(status().isCreated());		
	}
	
	
	@Test
	@DisplayName("FindAllProductsSuccessTest")
	void findAllProductsSuccessTest() throws Exception  {
		List<ProductResponse> listOfProductsResponse=ObjectBuilderUtility.buildProductResponseList();
		
		when(productsService.getAllProducts()).thenReturn(listOfProductsResponse);
	
		String url="/products";
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(url)
																	  .contentType(MediaType.APPLICATION_JSON_VALUE)
																	  .accept(MediaType.APPLICATION_JSON)
																	  .characterEncoding("UTF-8")
																	  .content(this.mapper.writeValueAsBytes(listOfProductsResponse));

		mockMvc.perform(builder).andExpect(status().isOk());
	}
	
}