package differentWaysToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTestWithoutBDD {

	@Test
	public void create() {
		
		//JSON Body Created
		 JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Sukesh");
		jobj.put("projectName", "Practice0");
		jobj.put("status", "onGoing");
		jobj.put("teamSize", 5);
		
		//Request Body and Content
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jobj);
		reqSpec.contentType(ContentType.JSON);
		
		//Validation of the Response
		
		Response resp = reqSpec.post("http://localhost:8084/addProject");
		//ValidatableResponse validaters = resp.then();
		ValidatableResponse validaters = resp.then();
		validaters.assertThat().contentType(ContentType.JSON);
		validaters.assertThat().statusCode(201);
		validaters.log().all();
		
		
	}
	
}
