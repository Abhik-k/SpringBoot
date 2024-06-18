package com.rest.api;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dto.CustomerDTO;
import com.rest.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
		return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer customerId) throws Exception{
		return new ResponseEntity<>(customerService.getCustomerById(customerId),HttpStatus.OK);
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Integer> addCustomer(@RequestBody CustomerDTO customer)throws Exception{
		Integer customerId = customerService.addCustomer(customer);
		return new ResponseEntity<>(customerId,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDTO customer) throws Exception{
		customerService.updateCustomer(customerId, customer.getEmail());
		//Environment
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws Exception{
		customerService.deleteCustomer(customerId);
		//Environment
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
}
