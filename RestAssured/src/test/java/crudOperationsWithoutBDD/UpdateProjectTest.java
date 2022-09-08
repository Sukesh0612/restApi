package crudOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {

	
	@Test
	public void UpdateProject() {
		
		//JSON Body Created
		 JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Sukesh");
		jobj.put("projectName", "Practice1");
		jobj.put("status", "onGoing");
		jobj.put("teamSize", 5);
		
		//Request Body and Content
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jobj);
		reqSpec.contentType(ContentType.JSON);
		
		//Validation of the Response
		
		Response resp = reqSpec.put("http://localhost:8084/projects/TY_PROJ_203");
		//ValidatableResponse validaters = resp.then();
		ValidatableResponse validaters = resp.then();
		validaters.assertThat().contentType(ContentType.JSON);
		validaters.assertThat().statusCode(200);
		validaters.log().all();
		
	}
	
}
