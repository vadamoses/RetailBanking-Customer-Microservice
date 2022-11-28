package com.cognizant.dto;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@Id
	private long userId;

	private String userName;

	private String password;

	private String userToken;
	
	private String userRole;
}