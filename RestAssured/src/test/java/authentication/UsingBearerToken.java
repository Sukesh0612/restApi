package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class UsingBearerToken {

	@Test
	public void usingBearerToken() {
		
		
		given()
		.auth().oauth2("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")
		
		.when()
		.get("https://github.com/user/repos")
		
		.then().assertThat().statusCode(200)
		.log().all()
		;
		
	}
	
}
