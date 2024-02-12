package com.example.productcategory.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.productcategory.dto.ResponseDTO;
import com.example.productcategory.exception.CategoryNotFoundException;
import com.example.productcategory.exception.ProductNotFoundException;

@RestControllerAdvice
public class AllExceptionsHandler {
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public ResponseDTO productNotFoundException(ProductNotFoundException e)
	{
		return new ResponseDTO(404,"error",e.getMessage());
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public ResponseDTO nullPointerException(NullPointerException e)
	{
		return new ResponseDTO(404,"error",e.getMessage());
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public ResponseDTO categoryNotFoundException(CategoryNotFoundException e)
	{
		return new ResponseDTO(404,"error",e.getMessage());
	}

}
