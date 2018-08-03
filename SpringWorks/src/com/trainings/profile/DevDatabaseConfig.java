package com.trainings.profile;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


//dev - oracle,

@Configuration
@Profile("Development")
public class DevDatabaseConfig implements DatabaseConfig{

	@Override
	@Bean
	public DataSource createDataSource() {
		// TODO Auto-generated method stub
		System.out.println("Creating dev database instance");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		/**
		 * you can set parameters here
		 */
		return dataSource;
	}

}
