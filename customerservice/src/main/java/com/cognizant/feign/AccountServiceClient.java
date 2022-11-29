package com.cognizant.feign;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.dto.AccountDto;
import com.cognizant.model.AccountCreationStatus;

@FeignClient(name = "${feign.name-account-service}", url = "${feign.url-account-service}")
public interface AccountServiceClient {

	@GetMapping("account-service/getAccounts/{customerId}")
	public List<AccountDto> getCustomerAccount(@RequestHeader("Authorization") String token,
			@PathVariable long customerId);

	@PostMapping("account-service/createAccount/{customerId}")
	public AccountCreationStatus createAccount(@RequestHeader("Authorization") String token,
			@PathVariable long customerId, @Valid @RequestBody AccountDto account);
}
