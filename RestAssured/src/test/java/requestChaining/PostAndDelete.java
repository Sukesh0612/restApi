package requestChaining;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import genericUtilities.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javaPojo.Post;


public class PostAndDelete {


	@Test
	public void requestChaining1()
	{
		//Step 1: create a project using POJO
		 JavaUtility jLib = new JavaUtility();
		Post pLib = new Post("Sukesh", "TYSS"+jLib.getRandomNumber(), "Completed", 24);
		baseURI = "http://localhost";
		port = 8084;
		
		Response resp = given()
		                  .body(pLib)
		                  .contentType(ContentType.JSON)
		                .when()
		                  .post("/addProject");
		
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
