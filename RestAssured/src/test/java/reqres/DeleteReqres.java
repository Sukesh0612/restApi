package reqres;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class DeleteReqres {

	@Test
	public void deleteReqres() {
		
		baseURI="https://reqres.in";

		given()
		
		.when()
		.delete("/api/users/2")
		.then()
		.statusCode(204)
		.log().all();
		
	}
	
}
