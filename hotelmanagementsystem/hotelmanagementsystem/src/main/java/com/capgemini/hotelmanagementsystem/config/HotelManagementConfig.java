package com.capgemini.hotelmanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

@Configuration
public class HotelManagementConfig {

	@Bean
	public LocalEntityManagerFactoryBean getHotelManagement() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("HotelMagagementSystemPersistanceUnit");
		return factoryBean;

	}// end of getHotelManagement()
}// end of class
