package com.cognizant.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.cognizant.dto.AccountDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_table")
public class Customer {
	@Id
	@Column(name = "customerid", length = 30, unique = true)
	private String customerid;

	@Column(name = "username", length = 30)
	@NotBlank
	private String username;

	@Column(name = "password")
	@NotBlank
	private String password;
	
	@Column(name = "address")
	@NotBlank
	private String address;
	
	@Column(name = "dateOfBirth")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	@Column(name = "pan", length = 10)
	@NotBlank
	private String pan;

	@Transient
	private List<AccountDto> customerAccounts = new ArrayList<>();
}
