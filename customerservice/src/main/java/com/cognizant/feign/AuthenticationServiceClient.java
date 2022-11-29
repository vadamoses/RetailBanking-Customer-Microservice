package com.cognizant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.AuthenticationResponse;

@FeignClient(name = "${feign.name-authentication-service}", url = "${feign.url-authentication-service}")
public interface AuthenticationServiceClient {

	@GetMapping("/validateToken")
	public AuthenticationResponse tokenValidation(@RequestHeader("Authorization") String token);

	@GetMapping("/role/{id}")
	public String getRole(@PathVariable("id") String id);
}
