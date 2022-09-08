package crudOperationsWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest {
	
	@Test
	public void DeleteProject() {
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_804");
		
		ValidatableResponse validaters = response.then();
		validaters.assertThat().statusCode(204);
		validaters.log().all();
		
	}
	
	
}
