package crudOperationWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class UpdateProjectTest {
	@Test
	public void create() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "SukeshUS");
		jobj.put("projectName", "Practice12");
		jobj.put("status", "onGoing");
		jobj.put("teamSize", 5);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_803")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200)
		.log().all();
		
		
		
	}
}
