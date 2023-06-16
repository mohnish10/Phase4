package com.mohnish.springbootsecurityrbac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mohnish.springbootsecurityrbac.entity.Product;
import com.mohnish.springbootsecurityrbac.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {		
		return repo.findAll();
	}
	
	public Product addProduct(Product product)
	{
		
		return repo.save(product);
	}
	
	public Product get(Long id) {
		return repo.findById(id).get();
	}
	
	public boolean deleteProduct(Long id)
	{
		
		if(repo.findById(id).isPresent())
		{
			
			repo.deleteById(id);
			return true;
			
		}
		
		return false;
	}
	
	
	
	public Product updateProduct(Product product,Long id)
	{
		
		if(repo.findById(id).isPresent())
		{
			
			Product old = repo.findById(id).get();
			old.setId(old.getId());
			old.setBrand(old.getBrand());
			old.setMadein(old.getMadein());
			old.setName(old.getName());
			old.setPrice(old.getPrice());
			
			return repo.save(old);
		}
		
		else
		return null;	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
