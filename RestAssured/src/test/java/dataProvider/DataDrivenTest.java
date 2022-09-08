package dataProvider;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import io.restassured.http.ContentType;
import javaPojo.ZabDataProviderPojo;

public class DataDrivenTest {

	ExcelUtility eLib = new ExcelUtility();
	@Test(dataProvider = "dataprovider")
	public void addProject(String createdBy,String projectName,String status,int teamSize) {
		
		
		
		ZabDataProviderPojo post = new ZabDataProviderPojo(createdBy, projectName, status, teamSize);
		
		given()
		.contentType(ContentType.JSON)
		.body(post)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat().statusCode(201)
		.log().all();
	}

	@DataProvider
	public Object[][] dataprovider() throws Throwable, Throwable{
		Random ran = new Random();
		int ranNum = ran.nextInt(100);
	
		Object[][] objArr = new Object[4][4];
		objArr[0][0]= eLib.getDataFromExcel("Sheet1", 1, 0);
		objArr[0][1]=eLib.getDataFromExcel("Sheet1", 1, 1)+ranNum;
		objArr[0][2]=eLib.getDataFromExcel("Sheet1", 1, 2);
		objArr[0][3]=Integer.parseInt (eLib.getDataFromExcel("Sheet1", 1, 3));
		
		objArr[1][0]=eLib.getDataFromExcel("Sheet1", 2, 0);
		objArr[1][1]=eLib.getDataFromExcel("Sheet1", 2, 1)+ranNum;
		objArr[1][2]=eLib.getDataFromExcel("Sheet1", 2, 2);
		objArr[1][3]=Integer.parseInt(eLib.getDataFromExcel("Sheet1", 2, 3));
		
		objArr[2][0]=eLib.getDataFromExcel("Sheet1", 3, 0);
		objArr[2][1]=eLib.getDataFromExcel("Sheet1", 3, 1)+ranNum;
		objArr[2][2]=eLib.getDataFromExcel("Sheet1", 3, 2);
		objArr[2][3]=Integer.parseInt(eLib.getDataFromExcel("Sheet1", 3, 3));
		
		objArr[3][0]=eLib.getDataFromExcel("Sheet1", 4, 0);
		objArr[3][1]=eLib.getDataFromExcel("Sheet1", 4, 1)+ranNum;
		objArr[3][2]=eLib.getDataFromExcel("Sheet1", 4, 2);
		objArr[3][3]=Integer.parseInt(eLib.getDataFromExcel("Sheet1", 4, 3));
		return objArr;	
	}
	
}
