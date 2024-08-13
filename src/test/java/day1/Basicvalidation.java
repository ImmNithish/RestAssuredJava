package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Basicvalidation {

	@Test
	public void validation() {
		
		
			given() // this contains the content type , set cookies , set headers, add param, add auth  and pre requistic  
		
		
			// this contains only the url 
		
			.when()  
			.get("https://reqres.in/api/users?page=2")
		
	// here the validations take place 
			
		.then() 
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
	}

}
