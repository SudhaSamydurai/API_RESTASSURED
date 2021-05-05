package com.sudha.api.SetUp;

import static io.restassured.RestAssured.given;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.sudha.api.Utilities.ConfigProperty;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class SetUp {
	
	public static ConfigProperty factory;
	@BeforeSuite
	public void beforeSuite() {
		factory = ConfigFactory.create(ConfigProperty.class);
		RestAssured.baseURI = factory.getBaseURI();
		RestAssured.basePath = factory.getBasePath();
	}
	
	@BeforeMethod
	public void beforeMethod() {
	}
	
	public RequestSpecification setRequestSpec() {
		RequestSpecification rspec = given().auth().basic(factory.getSecretKey(), "");
		return rspec;

	}

}
