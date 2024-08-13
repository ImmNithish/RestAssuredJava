package day2;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class HeadersValidations {
	
//	@Test ( priority = 0)
public void header()
{

	given()

			.when()
				.get("https://www.google.co.in/")
			
			.then()
				.header("Content-Type", "text/html; charset=ISO-8859-1")
				.header("Server", "gws")
				.header("Content-Encoding", "gzip");
		
//		/this method will verfiy the key and values of the headers are same... got the vales form put it in the postman  
}


 @Test (priority = 1) 
 public void logheader()
 {
	 given()

		.when()
			.get("https://www.google.co.in/")
		.then()
		.log().headers();
//		.log().cookies();
 }
	

}
