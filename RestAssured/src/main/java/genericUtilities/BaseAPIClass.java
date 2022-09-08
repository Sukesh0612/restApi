package genericUtilities;

import static io.restassured.RestAssured.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseAPIClass {

	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility  wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	
	
	@BeforeSuite
	public void dbConfig()
	{
		dLib.connectToDB("projects");
		baseURI="http://localhost";	
		port=8084;
	}
	
	@AfterSuite
	public void closeDBconfig()
	{
		dLib.closeDB();
	}
	
}
