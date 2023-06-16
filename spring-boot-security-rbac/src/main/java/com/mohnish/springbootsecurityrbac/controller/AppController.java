package com.mohnish.springbootsecurityrbac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mohnish.springbootsecurityrbac.entity.Product;
import com.mohnish.springbootsecurityrbac.service.ProductService;

@Controller
public class AppController 
{
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/")
	public String hello()
	{
		
		return "Welcome to Simple Spring Security Role Based Authorization control example with database";
		
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Object> addProduct(@RequestBody Product product)
	{
		
		Product data = productService.addProduct(product);
		if(data!=null)
		return new ResponseEntity<Object>(data,HttpStatus.CREATED);
		else
		return new ResponseEntity<Object>("Error while adding product",HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	
	@GetMapping("/products")
	public List<Product> getAllShoes()
	{
		
		return productService.listAll();
	}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable("id") Long id)
	{
		
		Product data = productService.get(id);
		
		if(data!=null)
		return new ResponseEntity<Object>(data,HttpStatus.OK);	
		else
		return new ResponseEntity<Object>("Product not found",HttpStatus.NOT_FOUND);	
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id)
	{
		
		
		if(productService.deleteProduct(id))
		{
			
			return new ResponseEntity<Object>("Product deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Object>("Product not found",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product,@PathVariable("id") Long id)
	{
		
		product = productService.updateProduct(product, id);
		
		if(product==null)
		return new ResponseEntity<Object>("Product is not available for update",HttpStatus.NOT_FOUND);	
		else
		return new ResponseEntity<Object>(product,HttpStatus.OK);	
			
	}
	
	
	
	
	
	

}
