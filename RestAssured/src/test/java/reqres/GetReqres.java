package reqres;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class GetReqres {

	@Test
	public void getReqres() {
		
		baseURI="https://reqres.in";

		given()
		
		.when()
		.get("/api/users?page")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
}
