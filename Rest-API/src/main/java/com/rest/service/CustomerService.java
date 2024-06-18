package com.rest.service;

import java.util.List;

import com.rest.dto.CustomerDTO;

public interface CustomerService {
	
//	getAllCustomer
//	getCustomerById
//	
//	addCustomer - return added customer id
//	updateCustomer 
//	deleteCustomer 
	
	public List<CustomerDTO> getAllCustomer();
	
	public CustomerDTO getCustomerById(Integer id) throws Exception;
	
	public Integer addCustomer(CustomerDTO customer);
	
	public void updateCustomer(Integer id, String email) throws Exception;
	
	public void deleteCustomer(Integer id)throws Exception;
}
