package com.infy.bean;

import org.springframework.stereotype.Component;

@Component("prepaid")
public class PrePaid implements Plan{

	@Override
	public boolean enrollPlan(String planName) {
		return (planName=="PREPAID")?true:false;
	}

}
