package com.rest.dto;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {
	
	
	private Integer customerId;
	
//	@NotNull(message ="Please provide Customer name")
//	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*",message = "Name should contain only alphabets and space")
//	private String name;
	
	//Using ValidationMessages properties
	@NotNull(message ="{customer.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*",message = "{customer.name.invalid}")
	private String name;
	
	
	@Email(message = "Please provide valid email address")
	@NotNull(message ="Please provide email address")
	@NotEmpty
	private String email;
	
	@PastOrPresent(message = "Date of birth should be past or present date")
	private LocalDate dob;
	
	@NotNull
	@Valid 
	private AddressDTO addressDTO;
}
