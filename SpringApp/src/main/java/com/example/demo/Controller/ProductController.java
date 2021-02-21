package com.example.demo.Controller;
import com.example.demo.Repository.RestRepository;
import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {

    RestRepository ProductRepository;
	ProductService productService;

	@Autowired
	public ProductController(RestRepository productRepository, ProductService productService) {
		ProductRepository = productRepository;
		this.productService = productService;
	}

	@GetMapping
    public List<Product> getAllProducts() {
        return ProductRepository.findAll();
    }
	  
	  @GetMapping(path="/customSearch")
	    public Product getProductById(@RequestParam(value = "ProductName", required=false, defaultValue="") String ProductName,@RequestParam(value = "Price", required=false,defaultValue="") String Price,@RequestParam(value = "ProductCode", required=false,defaultValue="") String ProductCode)  {
	     
		  return ProductRepository.findCustom(Price,ProductName,ProductCode);	    
	      
	  }  
	  @PostMapping(path="/newEntry")
	    public Product createProduct(@RequestBody Product bundle) {
	        return ProductRepository.save(bundle);
	    }
	  @DeleteMapping(path="/{ProductName}")
	  public boolean deleteProduct(@PathVariable String ProductName){  
		  try {
		  ProductRepository.delete(ProductRepository.findByEProductName(ProductName));
	      return true;
	      }catch(Exception e) {
	    	  System.out.println("Product does not exist");
	    	  return false;
	      }
	  }
	  @GetMapping(path="/budget/{Price}")
	  public List<Product> findBestProductsByBudget(@PathVariable String Price) {
		try {
			return productService.bestProductsBasedOnBudget(Price);
		}catch (Exception e){
			return null;
		}

	  }
}
