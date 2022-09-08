package crudOperationWithBDD;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class DeleteProjectTest {
	@Test
	public void DeleteProject() {
		
		
		given()
		.delete("http://localhost:8084/projects/TY_PROJ_203")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}
	
}
