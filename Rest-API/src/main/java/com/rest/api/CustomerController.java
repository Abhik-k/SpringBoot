package com.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dto.CustomerDTO;
import com.rest.exception.InfyBankException;
import com.rest.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomer() throws InfyBankException{
		return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer customerId) throws InfyBankException{
		return new ResponseEntity<>(customerService.getCustomerById(customerId),HttpStatus.OK);
	}
	
	@PostMapping("/customers")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDTO customer)throws Exception{
		Integer customerId = customerService.addCustomer(customer);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;
		return new ResponseEntity<>(successMessage,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDTO customer) throws InfyBankException{
		customerService.updateCustomer(customerId, customer.getEmail());
		//Environment
		String updateMessage = environment.getProperty("API.UPDATE_SUCCESS") + customerId;
		return new ResponseEntity<String>(updateMessage,HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws InfyBankException{
		customerService.deleteCustomer(customerId);
		//Environment
		String deleteMessage = environment.getProperty("API.DELETE_SUCCESS") + customerId;
		return new ResponseEntity<String>(deleteMessage, HttpStatus.OK);
	}
	
	//ResponseStatusException
	/*
	 * @DeleteMapping(value = "/customers/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws InfyBankException {
		try {
			customerService.deleteCustomer(customerId);
			String successMessage = environment.getProperty("API.DELETE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}*/
	
	
}
