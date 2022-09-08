package differentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONfileTest {


	@Test
	public void createProject()
	{
		//Step 1: create pre requisites
		File file = new File("./src/test/resources/emp.json");
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		 .body(file)
		 .contentType(ContentType.JSON)
		.when()                        //Step 2: perform Action
		 .post("/addProject")
		.then()                       //Step 3: Validation
		 .assertThat().statusCode(201)
		 .log().all();
	
	}
	
}
