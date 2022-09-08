package differentWaysToPost;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class AddProjectTestWithBDD {
	@Test
	public void create() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Sukesh");
		jobj.put("projectName", "pract");
		jobj.put("status", "onGoing");
		jobj.put("teamSize", 5);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
		
		
	}
}
