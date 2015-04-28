package com.test.currencyfair.test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static com.jayway.restassured.path.json.JsonPath.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class CurrencyFairTest {

	@Test
	public void testSimplePost() {
		
		String json = "{\"userId\": \"134257\", \"currencyFrom\": \"USD\", \"currencyTo\": \"EUR\", \"amountSell\": 1000, \"amountBuy\": 747.10, \"rate\": 0.7471, \"timePlaced\" : \"24-JAN-15 10:27:44\", \"originatingCountry\" : \"BR\"}";
		given().body(json).with().contentType("application/json").then().expect().statusCode(200).when().post("/CurrencyFairTest/trade");
	}
	
	@Test
	public void testMultiplePosts() {
		
		String[] currencies = { "EUR", "USD", "BRL", "GBP", "JPY" };
		
		int numberPosts = getRandomNumber(1, 10);
		
		for (int i = 0; i < numberPosts; i++) {
			String json = "{\"userId\": \"" + getRandomNumber(100000, 999999) + "\", \"currencyFrom\": \"" + currencies[getRandomNumber(0,4)] + "\", \"currencyTo\": \"" + currencies[getRandomNumber(0,4)] + "\", \"amountSell\": \"" + getRandomNumber(100, 999999) + "\", \"amountBuy\": \"" + getRandomNumber(100, 999999) + "\", \"rate\": 0.7471, \"timePlaced\" : \"24-JAN-15 10:27:44\", \"originatingCountry\" : \"BR\"}";
			given().body(json).with().contentType("application/json").then().post("/CurrencyFairTest/trade");			
		}
		
		when().get("/CurrencyFairTest/allTradesJson").then().body("$", hasSize(greaterThanOrEqualTo(numberPosts)));
	}	

	private int getRandomNumber(int min, int max) {
	    return (int) Math.floor(Math.random() * (max - min + 1)) + min;
	}
	
	
}
