package com.infy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

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

	}

	public void getCustomerDetails(Integer customerId) {
		String url = "http://localhost:8080/api/customers/{customerId}";

		WebClient webClient = WebClient.create();
		CustomerDTO customerDTO = webClient.get().uri(url, customerId).retrieve().bodyToMono(CustomerDTO.class).block();
		LOGGER.info(customerDTO);
		LOGGER.info("\n");
	}

}