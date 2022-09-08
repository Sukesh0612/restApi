package apiFramework;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import genericUtilities.JavaUtility;
import io.restassured.http.ContentType;


public class PostUsingLibrary {

	@Test
	public void PostUsingLibrary() {

		JavaUtility jLib = new JavaUtility();
		
		javaPojo.Post post = new javaPojo.Post("Sukhi", "Ty1207"+jLib.getRandomNumber(), "onGoing", 5);

		given()
		.contentType(ContentType.JSON)
		.body(post)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
	}

}
