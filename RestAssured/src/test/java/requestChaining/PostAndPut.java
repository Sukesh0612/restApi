package requestChaining;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import genericUtilities.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javaPojo.Post;


public class PostAndPut {


	@Test
	public void requestChaining1()
	{
		//Step 1: create a project using POJO
		 JavaUtility jLib = new JavaUtility();
		Post pLib = new Post("Sukesh", "TYSS"+jLib.getRandomNumber(), "Completed", 24);
		Post pLib1 = new Post("UpdateSukesh", "TYSS"+jLib.getRandomNumber(), "Completed", 24);
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
		
		 .pathParam("pid", proId).body(pLib1).contentType(ContentType.JSON)
		.when()
		 .put("/projects/{pid}")
		
		.then()
		 .assertThat().statusCode(200).log().all();
		 
		
	}


	
}
