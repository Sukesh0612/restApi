package authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class Oauth2 {


	@Test
	public void oauthAuthentication()
	{
		//Create a request to generate accesss token 
		Response resp = given()
				.formParam("client_id", "meat")
				.formParam("client_secret", "db8799ebbe40105e09b1cf3921325ed0")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "http://meat.com")
				.formParam("code", "authorization_code")

				.when()
				.post("http://coop.apps.symfonycasts.com/token");
		System.out.println("===============================");
		System.out.println("===============================");
		System.out.println(resp.asPrettyString());
		System.out.println("===============================");

		//Capture the access token from the response of the above request
		String token = resp.jsonPath().get("access_token");
		System.out.println("===============================");
		System.out.println(token);
		System.out.println("===============================");

		//Create another request and use the token to access the APIs
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3737)

		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")

		.then().log().all();


	}


}
