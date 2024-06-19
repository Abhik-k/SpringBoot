package com.rest.service;

import java.util.List;

import com.rest.dto.CustomerDTO;
import com.rest.exception.InfyBankException;

public interface CustomerService {
	
//	getAllCustomer
//	getCustomerById
//	
//	addCustomer - return added customer id
//	updateCustomer 
//	deleteCustomer 
	
	public List<CustomerDTO> getAllCustomer() throws InfyBankException;
	
	public CustomerDTO getCustomerById(Integer id) throws InfyBankException;
	
	public Integer addCustomer(CustomerDTO customer) throws InfyBankException;
	
	public void updateCustomer(Integer id, String email) throws InfyBankException;
	
	public void deleteCustomer(Integer id)throws InfyBankException;
}
