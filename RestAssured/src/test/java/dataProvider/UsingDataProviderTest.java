package dataProvider;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import io.restassured.http.ContentType;


public class UsingDataProviderTest extends ExcelUtility {

	ExcelUtility eLib = new ExcelUtility();
	
	
	@Test(dataProvider = "projects")
	public void PostUsingPojoClass(String createdBy, String projectName, String status,int teamSize) {

		javaPojo.Post post = new javaPojo.Post(createdBy, projectName, status,teamSize);

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
	
	@DataProvider
	public Object[][] projects() throws IOException, Throwable{
		int a=4;
		int b=4;
		Object[][] objArr=new Object[a][b];
		
		for (int i = 0; i < objArr.length; i++) {
		
			for (int j = 0; j < b; j++) {
				
				objArr[i][j]=eLib.getDataFromExcel("Sheet1", i, j);
				
			}
			
		}
		
		return objArr;

	}
	
	
}
