package genericUtilities;

import io.restassured.response.Response;


/**
 * This class contains restassured specific reusable methods
 * @author Admin
 *
 */
public class RestAssuredLibrary {

	/**
	 * This method will give the json data through json path from response body
	 * @author Admin
	 *
	 */
	public String jSONData(Response response, String path) {

		String jsonData=response.jsonPath().get(path);
		return jsonData;

	}

}
