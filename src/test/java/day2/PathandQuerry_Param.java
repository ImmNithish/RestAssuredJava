package day2;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathandQuerry_Param {
	
//	"https://reqres.in/api/users?page=2&id=5"
	
	@Test
	public void param()
	{
		
		given()
				.pathParam("mypath", "users") // we have to give path param as own name
				.queryParam("page", 2) // we have to give querry param as given in the url
				.queryParam("id", 5)

		.when()
				.get("https://reqres.in/api/{mypath}") 
				// only path param we have to mention here in {} querry param will automatically detect

		.then()
				.statusCode(200).log().all();
	}

}
