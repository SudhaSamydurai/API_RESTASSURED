package com.sudha.api.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sudha.api.SetUp.SetUp;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCustomerAPI extends SetUp{
	
	@Test
	public void validateCreateCustomerAPI() {
		
		
		
		
		RequestSpecification request = setRequestSpec().formParam("email", "mailtosudhasamydurai@gmail.com")
//		.formParam("Description", "hello")
//		.formParam("account", 0)
		.log().all();
		
		Response response = request.post("customers");
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
