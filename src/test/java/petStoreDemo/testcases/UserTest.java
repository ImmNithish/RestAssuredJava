package api.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoints.UserEdnPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest {

	Faker fakerobj ;
	User payload;

	@BeforeClass
	public void setUsersPayload() {
		fakerobj = new Faker();
		payload = new User();

		payload.setId(fakerobj.idNumber().hashCode());
		payload.setFirstName(fakerobj.name().firstName());
		payload.setLastName(fakerobj.name().lastName());
		payload.setUsername(fakerobj.name().username());
		payload.setEmail(fakerobj.internet().safeEmailAddress());
		payload.setPassword(fakerobj.internet().password(5,10));
		payload.setPhone(fakerobj.phoneNumber().cellPhone());
	}

	@Test( priority = 1)
	public void verifyUserCreation() {

		Response response = UserEdnPoints.createUser(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200); // testNg Assert verification

	}
	
	@Test( priority = 2)
public void verifyGetUser() {
		Response userResponse = UserEdnPoints.getUser(this.payload.getUsername());
		userResponse.then().log().body();
//		userResponse.then().log().all().statusCode(200);		
		userResponse.then().assertThat().statusCode(200); // Rest Assured code to verify the status codee
		
		
	}


	@Test( priority = 3)
	public void verifyUpdateUser() {
//		 updating the palyload 
		
//		payload.setId(fakerobj.idNumber().hashCode());
		payload.setFirstName(fakerobj.name().firstName());
		payload.setLastName(fakerobj.name().lastName());
		
		Response response = UserEdnPoints.UpdateUser(payload,this.payload.getUsername());
		response.then().log().body().statusCode(200);
		
//		checking the data after the updation
		
		Response afterupdateResponse = UserEdnPoints.getUser(this.payload.getUsername());
		afterupdateResponse.then().log().body();
		afterupdateResponse.then().assertThat().statusCode(200); // Rest Assured code to verify the status codee
		
	}
	
	@Test( priority = 4)

	public void VerifyDeleteUser()
	{
		Response deleteUserResponse = UserEdnPoints.deleteUser(this.payload.getUsername());
		deleteUserResponse.then().log().all().statusCode(200);
		
		
		
	}
}
