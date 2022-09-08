package reqres;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class GetParticularProject {

	@Test
	public void getParticularReqres() {
		
		baseURI="https://reqres.in";

		given()
		
		.when()
		.get("/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
}
