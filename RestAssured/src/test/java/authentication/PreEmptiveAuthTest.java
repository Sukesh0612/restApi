package authentication;

import static io.restassured.RestAssured.*;

public class PreEmptiveAuthTest {

	public void preEmptiveAuth() {
		
		baseURI="http://localhost";
		port=8084;
		
		
		
		given()
		.auth().preemptive()
		.basic("rmgyantra", "rmgy@9999")
		.when()
		.get("login").then().assertThat().statusCode(202)
		.log().all()
		;
		
	}
	
}
