package com.cognizant.dto;

import lombok.Data;

@Data
public class AccountDto {

	private long accountId;

	private long customerId;

	private String accountType;

	private float balance;
}