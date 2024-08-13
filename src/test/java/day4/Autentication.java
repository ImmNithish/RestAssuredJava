package day4;


import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/*
 *  Authentication means validation of username and password 
 *  
 *  Authoraisation means Permission 
 *  
 *  RestAPi supports
->basic 
->Digest
->preemptive 
  
  // for the below Auth we have to create our own token 
  
-> Bearear Auth { token is taken form Github create token } 
-> Oauth 1.0
-> Oauthn 2.0 { it is advanced in this we have to pass only limited param unlike 1.0 we have pass more param }



 Basic and Digest in the UI wise same process but internally its algorithms are different  
*/


public class Autentication {

	
	@Test(priority = 1)
	public void basicAuthCheck()
	{ 
		
		
		given()
		.auth().basic("postman","password") // its a pre req so it should be given in the give() { pasing user name and passwrod as Param }
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
	.then()
	.statusCode(200)
	.body("authenticated", equalTo(true))
	.log().all();
		
	
	}
	
	@Test(priority = 2)	
	public void digestAuthCheck()
	{ 
		
		
		given()
		.auth().digest("postman","password") // its a pre req so it should be given in the give() { pasing user name and passwrod as Param }
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
	.then()
	.statusCode(200)
	.body("authenticated", equalTo(true))
	.log().all();
		
	
	}
	@Test(priority = 3)	
	public void preemtiveAuthCheck()
	{ 
		
		
		given()
		.auth().preemptive().basic("postman","password") // its a pre req so it should be given in the give() { pasing user name and passwrod as Param }
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
	.then()
	.statusCode(200)
	.body("authenticated", equalTo(true))
	.log().all();
	
	
	}
	
	@Test
	
	public void beareAuth() {
		
		
		// in the given part we have to provide the  Request headers part 
		
		
		given()
		.headers("Authorization","Bearer  ") // after bearee it is the token we generated form github
		
	
		.when()
			.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
	@Test
	
	public void OAuth() {
		
		
		given()
		.auth().oauth("consumerKey", "ConsumerSecret","accesToken", "SecretToken")
		
		.when()
		.get("url")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
@Test
	
	public void OAuth2() {
		
		
		given()
		.auth().oauth2("Emnter the token:" )
		
		.when()
		.get("url")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
