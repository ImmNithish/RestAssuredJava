package day4;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetAccestoken {
	
	
	
	
	
	@Test
	public void getToken(ITestContext context) {
		
//		https://accounts.localzoho.com/oauth/v2/token?
		
		String RefreshToken =
				
		given()
			.queryParam("refresh_token", "1000.1145a313103b25f022add0fa05165303.5446ff2999dc9cd68534855e65884ac5")
			.queryParam("client_id","1000.JUAWZCUD25HJVRFQRE992NG2GWF27C")
			.queryParam("client_secret","44dc4bfe13ef795f21402380eba3d66e8ba31d3020")
			.queryParam("redirect_uri","https://zakya.localzoho.com")
			.queryParam("grant_type","refresh_token")
			.pathParam("RefreshTokenGenerator","token")
			
			
		.when()	
			.post("https://accounts.localzoho.com/oauth/v2/{RefreshTokenGenerator}")
			.jsonPath().getString("access_token");
					
		
			System.out.println("generated Bearer token:" +RefreshToken);
	
			
//		 this is for  test level in xml
//		context.setAttribute("New_RefreshToken", RefreshToken);
		
		
//		this is for Suite level 
		context.getSuite().setAttribute("New_RefreshToken", RefreshToken);
		
		
		
		
		
		
	}

}
