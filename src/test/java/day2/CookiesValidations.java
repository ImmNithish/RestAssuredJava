package day2;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesValidations {

//	  TO PERFROM THE BELOW ACTION FIRST WE NEED TO GET THE RESPONSE AS A VARIABLE FROM THE when()

	@Test
	// to get all the cookies which you know the cookie name
	public void getcookies() {

		Response response = given()
				
				.when()
					.get("https://www.google.co.in/"); // we complete restAssured fucn here and
																				// store the value in a variable

//	 java part below
		// to get single cookie info

		/**
		 * String cookieValue = response.getCookie("AEC");
		 * 
		 * System.out.println("Cookies value ----> " +cookieValue);
		 * 
		 **/
//  to get All cookies information 

		Map<String, String> Morecookies = response.getCookies();
	

//	System.out.println(Morecookies.keySet()); // keyset is a method to get value of key in Map

//	once we know about the key we can pass in the loop
		for (String k : Morecookies.keySet()) {
			System.out.println(" cookie key is : " + k + "  cookie value is : " + response.getCookie(k));

		}

	}

}
