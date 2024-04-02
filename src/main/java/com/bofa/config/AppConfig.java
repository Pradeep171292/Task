package com.bofa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.bofa.service.CustomerService;
import com.bofa.service.CustomerServiceImpl;

@Configuration
@Import(EmployeeConfig.class)
public class AppConfig {

	@Bean("CustomerService")
	public CustomerService customerService() {
		return new CustomerServiceImpl();
	}
}
