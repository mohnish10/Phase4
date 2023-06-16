package com.mohnish.sportyshoes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class OrderService 
{

	@Autowired
	private OrderRepo repo;
	
	
	public List<Orders> getAllOrders()
	{
		
		return repo.findAll();
	}
	
	
	public Orders addOrder(Orders order)
	{
		
		return repo.save(order);
	}
	
	
	public Orders getOrderByShoeId(Integer shoeId)
	{
		
		if(repo.findById(shoeId).isPresent())
		{
			
			return repo.findById(shoeId).get();
			
		}
		else
		return null;	
	}
	
	
	
public List<Orders> findOrdersWithSorting(String field)
{
	
	return repo.findAll(Sort.by(Sort.Direction.DESC,field));
}


public Page<Orders> findOrdersWithPagination(int offset,int pageSize)
{
	
	Page<Orders> orders = repo.findAll(PageRequest.of(offset, pageSize));
	return orders;
}


public Page<Orders> findOrdersWithPaginationAndSorting(int offset,int pageSize,String field)
{
	
	Page<Orders> orders = repo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
	return orders;
}


	
	
	
	
	
	
	
	
	
	


}
