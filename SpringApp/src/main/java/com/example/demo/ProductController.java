package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
    RestRepository ProductRepository;
	
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
}
