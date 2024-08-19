package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/* This was created for only for user module to perform Create / update / delete / read  Api's 
 * 
 * */

public class UserEdnPoints {

	public static Response createUser( User payload) {

		Response  response=	
				given()
				.contentType(ContentType.JSON) // prerequist are found from the swagger in that headers are given and mentioned that content type
				.accept(ContentType.JSON)
				.body(payload)

				.when()
				.post(Routes.postURL);

		return response;


	}

	
	

	public static Response getUser( String username) {

		Response  response=	
				given()
				.pathParam("username",username)

				.when()
				.get(Routes.getURL);

		return response;


	}
	

	public static Response UpdateUser( User payload, String username) {

		Response  response=	
				given()
				.contentType(ContentType.JSON) // prerequist are found from the swagger in that headers are given and mentioned that content type
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username",username)

				.when()
				.put(Routes.updateURL);

		return response;

	}
	
			

	public static Response deleteUser( String username) {

		Response  response=	
				given().pathParam("username", username)

				.when()
				.delete(Routes.deleteURL);

		return response;


	}



}
