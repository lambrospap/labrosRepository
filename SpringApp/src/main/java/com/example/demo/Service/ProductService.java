package com.example.demo.Service;

import com.example.demo.Repository.RestRepository;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

RestRepository ProductRepository;
static List<Product> products;

	@Autowired
	public ProductService(RestRepository productRepository) {
		ProductRepository = productRepository;
	}

	public List<Product> bestProductsBasedOnBudget(String budget){
		return products.stream().filter(price->Double.parseDouble(price.getPrice())<=Double.parseDouble(budget)).collect(Collectors.toList());
	}

	@PostConstruct
	private void loadProducts(){
		products= ProductRepository.findAll();
	}
}
