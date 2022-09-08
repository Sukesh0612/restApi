package endToEnd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import genericUtilities.BaseAPIClass;
import genericUtilities.EndPointsLibrary;
import genericUtilities.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javaPojo.Post;

public class CRUDOperationInBothGUIAndAPI implements EndPointsLibrary{

	@Test
	public void tryCRUDOperationInBothGUIAndAPI() throws SQLException {

		BaseAPIClass baseApi = new BaseAPIClass();
		JavaUtility jlib = new JavaUtility();
		Post proj = new Post("SukeshK", "Project"+jlib.getRandomNumber(), "Created", 40);

		baseApi.dbConfig();

		//Post
		Response resp = given()
				.body(proj)
				.contentType(ContentType.JSON)
				.when()
				.post(createProject);

		//capturing project id
		String projId = resp.jsonPath().get("projectId");
		System.out.println("<======Project CREATED sucessfully======>");
		System.out.println(projId);
		resp.then().assertThat().statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();

		//=======================DataBase==============================================
		//Check in dataBase
		System.out.println("<=========Databse verification starts========>");
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from project");
		int count=0;
		while(result.next())
		{
			if(result.getString(1).contains(projId))
			{
				count++;
				break;
			}
		}
		if(count==0)
		{
			System.out.println("<==========Project is DELETED from Database===========>");
		}else
		{
			System.out.println("Project is Present In database");
		}


		//GUI verification
		System.out.println("<==========GUI verification starts==========>");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURI+":"+port);
		//entering details and loggingin
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		driver.findElement(By.xpath("//a[text()='Projects']")).click();

		List<WebElement> projectIdElement = driver.findElements(By.xpath("//td[1]"));


		boolean temp=true;
		int projectCount=0;
		for(WebElement projectId : projectIdElement)
		{
			String project = projectId.getText();
			if(project.equalsIgnoreCase(projId))
			{
				temp=false;
				break;
			}
			projectCount++;
		}
		if(temp==false)
		{
			System.out.println("project is Present in GUI");
		}else
		{
			System.out.println("Project is not Present inGUI");
		}
		System.out.println(projectCount);

		driver.close();

		given().delete(EndPointsLibrary.deleteProject+projId);
		System.out.println("Project Deleted in API");

		//=======================Data Base==============================================
		ResultSet newresult = statement.executeQuery("select * from project");
		int newcount=0;
		while(newresult.next())
		{
			if(newresult.getString(1).contains(projId))
			{
				newcount++;
				break;
			}
		}
		if(newcount==0)
		{
			System.out.println("<==========Project is DELETED from Database===========>");
		}else
		{
			System.out.println("Project is Present In database");
		}


		//=======================GUI==============================================


		WebDriver driver2 = new ChromeDriver();
		driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver2.manage().window().maximize();
		driver2.get(baseURI+":"+port);
		//entering details and loggingin
		driver2.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver2.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver2.findElement(By.xpath("//button[text()='Sign in']")).click();





		driver2.findElement(By.xpath("//a[text()='Projects']")).click();

		List<WebElement> projectIdElement2 = driver2.findElements(By.xpath("//td[1]"));


		boolean temp1=true;

		int projectCount1=0;

		for(WebElement projectId : projectIdElement2)
		{
			String project = projectId.getText();
			if(project.equalsIgnoreCase(projId))
			{
				temp1=false;
				break;
			}
			projectCount1++;
		}
		if(temp1==false)
		{
			System.out.println("project is Present in GUI");
		}else
		{
			System.out.println("Project is Deleted inGUI");
		}
		System.out.println(projectCount1);

		driver2.close();

	}

}
