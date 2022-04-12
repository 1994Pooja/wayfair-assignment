package com.mayfair.products.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;


@RestControllerAdvice
@Slf4j
public class ProductGlobalExceptionHandler{
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ApiError>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, WebRequest request) {
		log.error("MethodArgumentNotValidException : {} " , exception.getMessage());
		List<ApiError>errorList=new ArrayList<>();
		exception.getAllErrors().stream()
		.forEach(ex->{
			ApiError error=new ApiError(new Date(),ex.getDefaultMessage(),HttpStatus.BAD_REQUEST);
				errorList.add(error);
		});
		return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
	}
		
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ApiError> handleAll(Exception ex, WebRequest request) {
		ApiError apiError = new ApiError(new Date(),ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	    return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ApiError> globalHttpException(HttpClientErrorException e){
		log.error("HttpClientErrorException : " , e.getMessage());
		String errorMessage="";

		String[] m=e.getMessage().split(",");
		String [] mes=m[1].split(":");
		errorMessage=mes[1].replace("\"", "");
		ApiError apiError = new ApiError(new Date(),errorMessage,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}
	
}
