package com.cg.addressbookapp.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Beans {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}