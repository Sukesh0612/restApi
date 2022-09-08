package differentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap {


	@Test
	public void createProject()
	{
		
		 baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: create pre requisites 
		HashMap map = new HashMap();
		map.put("createdBy", "Sukesh");
		map.put("projectName", "Pract100");
		map.put("status", "Created");
		map.put("teamSize", 4);
		
		given()
		 .body(map)
		 .contentType(ContentType.JSON)
		 
		.when()
		 .post("/addProject")
		 
		.then()
		 .assertThat().statusCode(201)
		 .log().all();
	
}
}
