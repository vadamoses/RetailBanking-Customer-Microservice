package com.cognizant.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountCreationStatus {

	@Id
	private String accountid;
	private String message;
}
