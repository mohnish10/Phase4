package com.mohnish.sportyshoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ShoeService 
{
	
	@Autowired	
	ShoeRepository repo;
	
	
	public List<Shoes> getAllShoes()
	{
		
		return repo.findAll();
	}
	
	
	public Shoes addShoe(Shoes shoe)
	{
		
		return repo.save(shoe);
	}
	
	
	public Shoes getShoeById(Integer id)
	{
		
		if(repo.findById(id).isPresent())
		{
			
			return repo.findById(id).get();
			
		}
		else
		return null;	
	}
	
	
	public boolean deleteShoe(Integer id)
	{
		
		if(repo.findById(id).isPresent())
		{
			
			repo.deleteById(id);
			return true;
			
		}
		
		return false;
	}
	
	
	
	public Shoes updateShoes(Shoes shoes,Integer id)
	{
		
		if(repo.findById(id).isPresent())
		{
			
			Shoes old = repo.findById(id).get();
			old.setShoeId(shoes.getShoeId());
			old.setColor(shoes.getColor());
			old.setName(shoes.getName());
			old.setPrice(shoes.getPrice());
			old.setSize(shoes.getSize());
			
			return repo.save(old);
		}
		
		else
		return null;	
		
		
		
		
	}

}
