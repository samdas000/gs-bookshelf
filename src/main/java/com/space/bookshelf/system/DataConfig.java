package com.space.bookshelf.system;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan("com.space.bookshelf")
public class DataConfig 
{
	@Autowired
	private Environment env;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
    
	
	@Bean
	public DataSource dataSource() 
	{
		if("yes".equalsIgnoreCase(env.getProperty("server.local")))
		{
			System.out.println("H2 Database loaded");
			
		    return DataSourceBuilder
		        .create()
		        .username("sa")
		        .password("")
		        .url("jdbc:h2:~/test")
		        .driverClassName("org.h2.Driver")
		        .build();
		}
		else			
		{
			System.out.println("MySql Database loaded");
		    
			final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
	        dataSource.setUsername("guest_user");
	        dataSource.setPassword("guest_password");

	        return dataSource;
			
		}
		
	}
	
	//@Bean
	public DataSource dataSource2() 
	{
		if("yes".equalsIgnoreCase(env.getProperty("server.local")))
	    return DataSourceBuilder
	        .create()
	        .username("sa")
	        .password("")
	        .url("jdbc:h2:~/test")
	        .driverClassName("org.h2.Driver")
	        .build();
		else
			return null;
	}
	
	
	@RequestMapping("/setup/data")
	public String setupData() 
	{
		System.out.println("Inside getdata " + jdbcTemplate.getDataSource().toString());
		
		return "setting up tables";
	}
	
	
	
	

}
