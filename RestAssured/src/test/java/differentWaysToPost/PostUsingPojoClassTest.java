package differentWaysToPost;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class PostUsingPojoClassTest {

	@Test
	public void PostUsingPojoClass() {

		javaPojo.Post post = new javaPojo.Post("Sukhi", "Ty1207", "onGoing", 5);

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
