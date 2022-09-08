package crudOperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ReadParticularProjectTest {
	@Test
	public void Read() {
		given()
		.get("http://localhost:8084/projects/TY_PROJ_802")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}
}
