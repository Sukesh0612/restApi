package reqres;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutReqres {

	@Test
	public void updateProject() {
		baseURI="https://reqres.in";
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Sukesh");
		jobj.put("job", "leader");
		
		given()
		.body(jobj)
		.when()
		.put("/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
}
