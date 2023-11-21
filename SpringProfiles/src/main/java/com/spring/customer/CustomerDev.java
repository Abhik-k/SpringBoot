package com.spring.customer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class CustomerDev {
	public static final Log LOGGER= LogFactory.getLog(CustomerProd.class);
	
	public CustomerDev() {
		System.out.println("Dev");
		LOGGER.info("CustomerDev bean is initialized");
	}
	
}
