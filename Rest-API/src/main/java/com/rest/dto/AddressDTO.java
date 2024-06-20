package com.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDTO {
	
	private Integer addressId;
	
	@NotNull(message="Please provide street")
	private String street;
	
	@NotNull(message="Please provide city")
	private String city;
}	
