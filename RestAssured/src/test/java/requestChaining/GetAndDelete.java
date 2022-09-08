package requestChaining;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class GetAndDelete {


	@Test
	public void requestChaining1()
	{

		baseURI = "http://localhost";
		port = 8084;

		Response resp = when().get("/projects/TY_PROJ_1004");


		//capture the project id
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();

		//Create a get request and pass proID as path parameter
		given()
		.pathParam("pid", proId)
		.when()
		.delete("/projects/{pid}")
		.then()
		.assertThat().statusCode(204).log().all();


	}



}
