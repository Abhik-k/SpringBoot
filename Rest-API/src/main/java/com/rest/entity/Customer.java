package com.rest.entity;

import java.time.LocalDate;

import com.rest.dto.CustomerDTO;

import jakarta.persistence.Column;

//import com.rest.dto.CustomerDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	
	private String name;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	private LocalDate dob;
	
	
	@Override
	public int hashCode() {

		return 31;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		if (this.getCustomerId() == null) {
			if (other.getCustomerId() != null)
				return false;
		} else if (!this.getCustomerId().equals(other.getCustomerId()))
			return false;
		return true;
	}
	
}
