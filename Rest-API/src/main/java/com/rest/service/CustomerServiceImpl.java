package com.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dto.CustomerDTO;
import com.rest.entity.Customer;
import com.rest.exception.InfyBankException;
import com.rest.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repository;
	
	@Override
	public List<CustomerDTO> getAllCustomer() throws InfyBankException{
		List<Customer> customers = repository.findAll();
		List<CustomerDTO> list = new ArrayList<>();
		customers.forEach(customer -> {
			CustomerDTO cust = new CustomerDTO();
			cust.setCustomerId(customer.getCustomerId());
			cust.setName(customer.getName());
			cust.setEmail(customer.getEmail());
			cust.setDob(customer.getDob());
			
			list.add(cust);
		});
		if (list.isEmpty())
			throw new InfyBankException("Service.CUSTOMERS_NOT_FOUND");
		return list;
	}

	@Override
	public CustomerDTO getCustomerById(Integer id) throws InfyBankException {
		
		Optional<Customer> optional = repository.findById(id);
		Customer customer = optional.orElseThrow(()-> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		
		CustomerDTO cust = new CustomerDTO();
		cust.setCustomerId(customer.getCustomerId());
		cust.setName(customer.getName());
		cust.setEmail(customer.getEmail());
		cust.setDob(customer.getDob());
		
		return cust;
	}

	@Override
	public Integer addCustomer(CustomerDTO customer) throws InfyBankException{
		
//		List<Customer> custum = repository.findByEmail(customer.getEmail());
//		System.out.println(custum);
		
//		if(custum.isEmpty()) {
		
		Customer cust= new Customer();
		
		cust.setCustomerId(customer.getCustomerId());
		cust.setName(customer.getName());
		cust.setEmail(customer.getEmail());
		cust.setDob(customer.getDob());
		
		Customer customerEntity = repository.save(cust);
		
		
		return customerEntity.getCustomerId();
//		}
//		
//		return null;
	}

	@Override
	public void updateCustomer(Integer id, String email) throws InfyBankException {
		
		Optional<Customer> optional = repository.findById(id);
		Customer customer = optional.orElseThrow(()-> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		customer.setEmail(email);
		repository.save(customer);
	}

	@Override
	public void deleteCustomer(Integer id) throws InfyBankException{
		Optional<Customer> optional = repository.findById(id);
		Customer customer = optional.orElseThrow(()-> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		
		repository.deleteById(customer.getCustomerId());
	}

}
