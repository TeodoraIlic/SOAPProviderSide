package com.teodora.ws.soap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.cxf.feature.Features;
import org.example.customerinformation.CustomerInformationInterface;
import org.example.customerinformation.GetCustomerDetails1;
import org.example.customerinformation.GetCustomerDetailsFault_Exception;
import org.example.customerinformation.GetCustomerDetailsResponse;
import org.example.customerinformation.GetCustomerDetailsResponse1;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerImpl implements CustomerInformationInterface {

	Map<Integer, GetCustomerDetailsResponse> customerOrders = new HashMap<>();
	int currentId;
	
	
	public CustomerImpl() {
		init();
	}
	
	public void init() {
		
		//List<GetCustomerDetails1> customers = new ArrayList<>();
		GetCustomerDetails1 customer1 = new GetCustomerDetails1();
		customer1.setId("1");
		
		GetCustomerDetailsResponse customer = new GetCustomerDetailsResponse();
		
		
		GetCustomerDetailsResponse1 customerDetails = new GetCustomerDetailsResponse1();
		customerDetails.setFirstName("Teodora");
		customerDetails.setLastName("Ilic");
		customerDetails.setCity("Belgrade");
		customerDetails.setAddress("Jastrebacka");
		customerDetails.setAge("24");
		customerDetails.setMartialStatus("no matrial status");
		customerDetails.setContactEmail("teodoraailic@gmail.com");
		customerDetails.setContactPhone("0656848366");
		
		customer.setGetCustomerDetailsResponse(customerDetails);
		
		//customers.add(customer1); 
		 
		
		customerOrders.put(Integer.valueOf(++currentId), customer) ;
		
		
		
	}
	
	@Override
	public GetCustomerDetailsResponse1 getCustomerDetails(GetCustomerDetails1 request)
			throws GetCustomerDetailsFault_Exception {
		
		String customerId = request.getId();
		/*sada iz mape vracamo customera sa tim id*/
		GetCustomerDetailsResponse customer1 = customerOrders.get(Integer.valueOf(customerId));
	
		/*da bi poslali njegove info u response prvo moramo da instanciramo objekat za response*/
		GetCustomerDetailsResponse1 response = new GetCustomerDetailsResponse1();
		
		
		response = customer1.getGetCustomerDetailsResponse();
		
		
		
		return response;
	}

}
