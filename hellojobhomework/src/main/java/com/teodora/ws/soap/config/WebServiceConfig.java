package com.teodora.ws.soap.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.teodora.ws.soap.CustomerImpl;

@Configuration
public class WebServiceConfig {

	
	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new CustomerImpl());
		/*url gde hocemo da objavimo*/
		endpoint.publish("/customerordersservice");
		return endpoint;
	}
	
	
}
