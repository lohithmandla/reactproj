package com.restcalls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/saveProduct")
	public ProductModel saveProduct(@RequestBody ProductModel product) {
		return productService.saveProduct(product);	
	}
	@GetMapping("/getAll")
	public List<ProductModel> getAll(){
		return productService.getAll();
	}
	@PostMapping("/getProducts")
	public List<ProductModel> getProduct(@RequestBody List<ProductModel> products) {
		return productService.getProducts(products);	
	}
	@PutMapping("/update")
	public ProductModel updateProduct(@RequestBody ProductModel product) {
		return productService.saveProduct(product);	
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		return productService.deleteProduct(id);
	}
}
