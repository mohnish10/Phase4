package com.mohnish.sportyshoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> 
{
	
	int recordCount;
	T response;

}
