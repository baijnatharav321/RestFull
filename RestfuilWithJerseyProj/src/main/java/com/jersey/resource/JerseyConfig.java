package com.jersey.resource;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.rest.controller.EmployeeTestController;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(EmployeeTestController.class);
		packages("com.rest.jersey.ExceptionMapper");

	}

}
