package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StaticValidation {


	@Test
	public void staticResponseGet()
	{
		//prerequisites
		String expData = "TY_PROJ_001";
		baseURI = "http://localhost";
		port = 8084;
		
		//action
		io.restassured.response.Response resp = when().get("/projects");
		
		//validation
		String actData = resp.jsonPath().get("[0].projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("data verfied ");
		
		resp.then().log().all();
	}
	
}
