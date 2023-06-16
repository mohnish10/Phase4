package com.mohnish.sportyshoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ShoeController 
{
	
	@Autowired
	ShoeService service;
	
	
	@GetMapping("/")
	public String hello()
	{
		
		return "Welcome to SportyShoes";
		
	}
	
	
	@PostMapping("/api/admin/shoes")
	public ResponseEntity<Object> addShoes(@RequestBody Shoes shoes)
	{
		
		Shoes data = service.addShoe(shoes);
		if(data!=null)
		return new ResponseEntity<Object>(data,HttpStatus.CREATED);
		else
		return new ResponseEntity<Object>("Error while adding user",HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	
	@GetMapping("/shoes")
	public List<Shoes> getAllShoes()
	{
		
		return service.getAllShoes();
	}
	
	
	@GetMapping("/shoes/{id}")
	public ResponseEntity<Object> getShoesById(@PathVariable("id") Integer id)
	{
		
		Shoes data = service.getShoeById(id);
		
		if(data!=null)
		return new ResponseEntity<Object>(data,HttpStatus.OK);	
		else
		return new ResponseEntity<Object>("Object not found",HttpStatus.NOT_FOUND);	
	}
	
	
	
	@DeleteMapping("/api/admin/shoes/{id}")
	public ResponseEntity<Object> deleteShoes(@PathVariable("id") Integer id)
	{
		
		
		if(service.deleteShoe(id))
		{
			
			return new ResponseEntity<Object>("Shoe deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Object>("Shoe not found",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/api/admin/shoes/{id}")
	public ResponseEntity<Object> updateShoes(@RequestBody Shoes shoe,@PathVariable("id") Integer id)
	{
		
		Shoes shoes = service.updateShoes(shoe, id);
		
		if(shoes==null)
		return new ResponseEntity<Object>("Shoe is not available for update",HttpStatus.NOT_FOUND);	
		else
		return new ResponseEntity<Object>(shoes,HttpStatus.OK);	
			
	}
	
	
	
	

}
