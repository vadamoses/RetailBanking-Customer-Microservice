package com.cognizant.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerCreationStatus {

	@Id
	private Long customerid;
	private String message;
}
