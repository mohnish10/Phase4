package com.mohnish.sportyshoes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.NoArgsConstructor;


@RestController
@NoArgsConstructor
public class OrderController 
{
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/order/shoes")
	public ResponseEntity<Object> addShoes(@RequestBody Orders order)
	{
		
		order = orderService.addOrder(order);
		if(order!=null)
		return new ResponseEntity<Object>(order,HttpStatus.CREATED);
		else
		return new ResponseEntity<Object>("Error while taking user",HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	
	
	@GetMapping("/api/admin/orders")
	public List<Orders> getAllOrders()
	{
		
		return orderService.getAllOrders();
	}

	
	
	@GetMapping("/api/admin/orders/{field}")
	private APIResponse<List<Orders>> getOrdersWithSort(@PathVariable String field)
	{
		
		List<Orders> allOrders = orderService.findOrdersWithSorting(field);
		return new APIResponse<>(allOrders.size(),allOrders);
	}
	
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	private APIResponse<Page<Orders>> getOrdersWithPagination(@PathVariable int offset, @PathVariable int pageSize)
	{
		
		Page<Orders> ordersWithPagination = orderService.findOrdersWithPagination(offset,pageSize);
		return new APIResponse<>(ordersWithPagination.getSize(),ordersWithPagination);
	}
	
	
	@GetMapping("/api/admin/orders/paginationAndSort/{offset}/{pageSize}/{field}")
	private APIResponse<Page<Orders>> getOrdersWithPaginationAndSort(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		
		Page<Orders> ordersWithPagination = orderService.findOrdersWithPaginationAndSorting(offset, pageSize, field);
		return new APIResponse<>(ordersWithPagination.getSize(),ordersWithPagination);
		
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

}
