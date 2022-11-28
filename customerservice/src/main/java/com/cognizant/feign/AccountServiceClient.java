package com.cognizant.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.dto.AccountDto;
import com.cognizant.dto.UserDto;
import com.cognizant.model.AccountCreationStatus;

//@FeignClient(name = "${feign.name-account-service}", url = "${feign.url-account-service}")
public interface AccountServiceClient {

	@GetMapping("/api/v1/account/customer/{customerId}")
	public List<UserDto> getCustomerAccounts(@PathVariable(value = "customerId") String customerId);

	@PostMapping("/api/v1/account")
	public AccountCreationStatus createAccount(@RequestBody AccountDto account,
			@PathVariable(value = "customerId") String customerId);
}
