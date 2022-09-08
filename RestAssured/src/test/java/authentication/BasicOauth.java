package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicOauth {

	@Test
	public void basicOauth() {
		
		baseURI="http://localhost";
		port=8084;
		
		
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("login").then().assertThat().statusCode(202)
		.log().all()
		;
		
		
	}
	
}
