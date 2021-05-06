package com.understandingserialization;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;// Reambering is very important line 4 

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import files.ReUsableMethods;

public class Car {
	private String make;
	private String model;
	private int year;
	
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.setMake("Aston Martin");
		myCar.setModel("BD9");
		myCar.setYear(2004);
	
		System.out.println(myCar.getMake());
		System.out.println(myCar.getModel());
		System.out.println(myCar.getYear());
	}
	@Test
	public void testCarSerialization() {
					
		ValidatableResponse myCar = 
		given().
			contentType("application/json").
			//body(myCar).
		when().
			post("http://localhost:9876/carstub").
		then().
			assertThat().
			body(equalTo("Car has been stored"));
		
		System.out.println();
	}
	}

