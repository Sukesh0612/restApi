package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TimeValidationHamcrest {


	@Test
	public void dynamicResponse()
	{
		//pre requistes
		String expData = "TY_PROJ_1004";
		baseURI = "http://localhost";
		port = 8084;
		
		//Action
		 io.restassured.response.Response resp = when()
		                   .get("/projects");
		
		//Validation
		boolean flag = false;
		
		java.util.List<String> pIDs = resp.jsonPath().get("projectId");
		for(String projectID : pIDs)
		{
			if(projectID.equalsIgnoreCase(expData))
			{
				flag = true;
			}
		}
		
		Assert.assertTrue(flag);
		
		System.out.println("data verfied");
		
		resp.then().
		assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
	//	.contentType(Matcher<T>)
		.log().all();
	}

	
}
