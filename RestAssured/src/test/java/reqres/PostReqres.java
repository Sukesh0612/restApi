package reqres;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostReqres {

	@Test
	public void CreateProject() {
		baseURI="https://reqres.in";
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Sukesh");
		jobj.put("job", "leader");
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("/api/users")
		.then()
		.statusCode(201)
		.log().all();
		
	}
	
}
