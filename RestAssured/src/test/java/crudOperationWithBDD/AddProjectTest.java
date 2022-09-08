package crudOperationWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class AddProjectTest {
	@Test
	public void create() {
		
		String projName="Practice";
		int a=20;
		
		for (int i = 0; i < 10; i++) {
			
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Sukesh");
		jobj.put("projectName", projName+a);
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
		a++;
		System.out.println("Hi");
		}
		
		
	}
}
