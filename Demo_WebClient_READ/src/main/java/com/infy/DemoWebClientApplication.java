package com.infy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import com.infy.dto.AddressDTO;
import com.infy.dto.CustomerDTO;

@SpringBootApplication
public class DemoWebClientApplication implements CommandLineRunner {

	private static final Logger LOGGER = LogManager.getLogger(DemoWebClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoWebClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 
		getCustomerDetails(2);
		getCustomerDetails(11);
		
//		CustomerDTO customer = new CustomerDTO();
//		customer.setCustomerId(10);
//		customer.setEmail("rajessadh@gmail.com");
//		customer.setName("Raj Aryan");
//		
//		AddressDTO address = new AddressDTO();
//		address.setAddressId(5);
//		address.setCity("Pune");
//		address.setStreet("Phase-1");
//		
//		customer.setAddressDTO(address);
		
//		addCustomer(customer);
		
//		updateCustomer(customer);
		
		deleteCustomer(11);
		
	}

	public void getCustomerDetails(Integer customerId) {
		String url = "http://localhost:8080/api/customers/{customerId}";

		WebClient webClient = WebClient.create();
		CustomerDTO customerDTO = webClient.get().uri(url, customerId).retrieve().bodyToMono(CustomerDTO.class).block();
		LOGGER.info(customerDTO);
		LOGGER.info("\n");
	}
	
//	public void addCustomer(CustomerDTO customer) {
//		String url="http://localhost:8080/api/customers";
//		WebClient webClient = WebClient.create();
//		
//		String response = webClient.post().uri(url).bodyValue(customer).retrieve().bodyToMono(String.class).block();
//		LOGGER.info(response);
//		LOGGER.info("\n");
//	}
	
//	public void updateCustomer(CustomerDTO customer) {
//		String url="http://localhost:8080/api/customers/{customerId}";
//		WebClient webClient = WebClient.create();
//		
//		String response = webClient.put()
//					.uri(url,customer.getCustomerId())
//					.bodyValue(customer)
//					.retrieve()
//					.bodyToMono(String.class)
//					.block();
//		
//		LOGGER.info(response);
//		LOGGER.info("\n");
//	}
	
	public void deleteCustomer(Integer customerId) {
		String url="http://localhost:8080/api/customers/{customerId}";
		WebClient webClient = WebClient.create();
		webClient.delete()
					.uri(url,customerId)
					.exchange() //equivalent to retrive method to receive response body but gives more control to access the response
					.subscribe(
							response->{
								if(response.statusCode().value()==200) {
									LOGGER.info("Customer deleted Successfully");
								}
								else {
									LOGGER.info("Failed to delete Customer");
								}
							});
					
	}

}