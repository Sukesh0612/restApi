package crudOperationsWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ReadAllProjectTest {

	@Test
	public void Read() {

		//Request Body and Content
		 Response response = RestAssured.get("http://localhost:8084/projects");
		
		
		ValidatableResponse validaters = response.then();
		validaters.assertThat().statusCode(200);
		validaters.log().all();

	}

}
