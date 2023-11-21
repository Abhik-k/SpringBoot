package com.infy.bean;

import org.springframework.stereotype.Component;

@Component("postpaid")
public class PostPaid implements Plan{

	@Override
	public boolean enrollPlan(String planName) {
		return planName=="PostPiad"?true:false;
	}
	
}
