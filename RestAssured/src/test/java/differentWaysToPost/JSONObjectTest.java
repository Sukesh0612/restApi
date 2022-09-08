package differentWaysToPost;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import javaPojo.JsonObject;

public class JSONObjectTest {

	@Test
	public void JSONObject() {
		JsonObject jsonObj = new JsonObject();
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.jsonObject())
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
		
		
	}
	
}
