package com.API.Testing;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HttpGetMethodServerTesting {

	Response response;
	
	@BeforeTest
	public void getSetup() {
		//pass the URL
		response = RestAssured.get("http://localhost:3000/posts");
		
	}
	// Testing code
	@Test(priority=1)
	public void getStatuscode() {
		System.out.println("Status code : "+ response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void getResponseTime() {
		System.out.println("Response time : "+ response.getTime());
		Assert.assertTrue(response.getTime()< 500);
	}
	
	@Test(priority=3)
	public void getContentType() {
		System.out.println("Content type  : "+ response.getContentType());
		Assert.assertTrue(response.getContentType().contains("json"));
	}
	
	@Test
	public void getresponseBodyNotNull() {
		System.out.println("Response body is null or not  : "+ response.toString()!=null);
		Assert.assertTrue(response.toString() !=null);
	
	}
	
	
}
