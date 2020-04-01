package com.example.demo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFounEexception extends Exception {

	 private static final long serialVersionUID = 1L;
	 public ProductNotFounEexception(String message){
	     super(message);
	    }
	}
