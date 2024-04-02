package com.bofa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(("com.bofa.service"))
public class EmployeeConfig {

	@Bean
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    //MySQL database we are using
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/boa_schema?autoReconnect=true&useSSL=false");
	    dataSource.setUsername("root");
	    dataSource.setPassword("P@ssw0rd");
	    
	   
	    return dataSource;
	  }

	  @Bean
	  public JdbcTemplate jdbcTemplate() {
	    JdbcTemplate jdbcTemplate = new JdbcTemplate();
	    jdbcTemplate.setDataSource(dataSource());
	    return jdbcTemplate;
	  }
}
