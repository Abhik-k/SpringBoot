package com.infy.dto;


public class CustomerDTO {

	private Integer customerId;
	private String email;
	private String name;
	private AddressDTO addressDTO;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AddressDTO getAddressDTO() {
		return addressDTO;
	}
	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", email=" + email + ", name=" + name + ", addressDTO=" + addressDTO
				+ "]";
	}
	
	
	


	

	
}
