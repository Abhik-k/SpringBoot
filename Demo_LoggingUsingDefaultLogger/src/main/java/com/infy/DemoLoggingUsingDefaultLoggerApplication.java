package com.infy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.infy.bean.Customer;

@SpringBootApplication
public class DemoLoggingUsingDefaultLoggerApplication {

	public static void main(String[] args) {
		
	AbstractApplicationContext context = (AbstractApplicationContext)SpringApplication.run(DemoLoggingUsingDefaultLoggerApplication.class, args);
	
	Customer customer = context.getBean(Customer.class);
	
	String plan ="PREPAID";
	
	Log LOGGER =LogFactory.getLog(DemoLoggingUsingDefaultLoggerApplication.class);
	try {
		String msg=customer.register(plan);
		LOGGER.info(msg);
	}catch (Exception e) {
		LOGGER.info("Sorry! Some exception occured ! Please chek log file");
	}
	
	context.close();
	
	}
}
