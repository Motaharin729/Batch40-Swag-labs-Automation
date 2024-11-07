package com.API.Testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpPatchServer {
	
	@Test
	public void getPatch() {
		
		// 1st add data ====> Create JsonObject type obj and addProperty() 
		JsonObject json = new JsonObject();
	
		json.addProperty("Zip Code ", "23401");
		json.addProperty("City", "Baltimore");
		
		// 2nd add data inside  the Body using RequestSpecification obj
		 RequestSpecification reqsf = RestAssured.given();  // RequestSpecification is an interface of restAssured
		 reqsf.header("Content-Type", "application/json");
		 reqsf.body(json.toString());  // passing data inside the body in json format
		 
		 // 3rd part ==> pass the url
		 Response  response = reqsf.patch("http://localhost:3000/posts/9c7d");
		 
		 // 4th => validation
		 System.out.println("Status code : "+ response.getStatusCode());
			Assert.assertEquals(response.getStatusCode(), 200);
			
		System.out.println("Response time : "+ response.getTime());
			Assert.assertTrue(response.getTime()< 500);
			
		System.out.println("Content type  : "+ response.getContentType());
			Assert.assertTrue(response.getContentType().contains("json"));

		System.out.println("Response body is null or not  : "+ response.toString()!=null);
		//Assert.assertTrue(response.toString() !=null);
		}
	

}
