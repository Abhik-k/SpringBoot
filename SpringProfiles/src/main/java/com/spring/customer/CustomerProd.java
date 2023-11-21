package com.spring.customer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class CustomerProd {
	public static final Log LOGGER= LogFactory.getLog(CustomerProd.class);
	public CustomerProd() {
		System.out.println("Prod");
		LOGGER.info("CustomerProd bean is initialized");
	}
}
