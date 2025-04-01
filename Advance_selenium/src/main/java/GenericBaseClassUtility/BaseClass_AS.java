package GenericBaseClassUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import GenericUtility.DatabaseUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

public class BaseClass_AS {
	
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	DatabaseUtility dbUtil = new DatabaseUtility();
	PropertiesFileUtility pro = new PropertiesFileUtility();
	
	@BeforeSuite
	public void beforeSuite() throws SQLException
	{
		System.out.println("Established database connection");
	    dbUtil.getDBConnection("jdbc:mysql://localhost:3306/Ninza_1","root","k@vith@123456789Naveen");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Pre configuration setup");
	}
	@BeforeClass
	public void beforeClass() throws IOException
	{
		System.out.println("Launch the browser");
		String BROWSER = pro.readingDataFromPropFile("browser");
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else 
		{
			driver=new ChromeDriver();
		} 
		sdriver=driver;
	
	}
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		System.out.println("Login");
		String URL = pro.readingDataFromPropFile("url");
		String UN = pro.readingDataFromPropFile("uname");
		String PWD = pro.readingDataFromPropFile("pwd");
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(UN, PWD);
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException
	{
		System.out.println("Logout");
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		dp.logout();	
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException
	{
		System.out.println("Close the browser");
		Thread.sleep(2000);
        driver.quit();
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("Post configuration setup");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Close the database connection");
        dbUtil.closeDBConnection(); 
	}

}
