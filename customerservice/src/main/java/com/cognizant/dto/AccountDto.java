package com.cognizant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

	private long accountId;

	private long customerId;

	private String accountType;

	private float balance;
}