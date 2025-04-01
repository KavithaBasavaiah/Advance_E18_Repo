package Login;

import java.io.FileInputStream;
// import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericBaseClassUtility.BaseClass_AS;
import GenericListenerUtility.ListenerImp;
import GenericUtility.PropertiesFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

// @Listeners(ListenerImp.class)
public class LoginTest extends BaseClass_AS{

	//@Parameters("browser")
	@Test(retryAnalyzer = GenericListenerUtility.RetryListenerImp.class)
 
	public void createLoginTest() throws InterruptedException, IOException
	{
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(4000);
		
		String actualURL=driver.getCurrentUrl();
		Assert.assertEquals(actualURL,expectedURL,"Validation failed");
		Reporter.log("Validation is passed",true);;
		/*if(actualURL.equals(expectedURL))
		{
			Reporter.log("Validation is pass",true);
		}
		else
		{
			Reporter.log("validation is failed",true);
		}
		*/
		
		//logout
		/*
		DashboardPage dp = new DashboardPage(driver);
		dp.logout();
        Thread.sleep(2000);
        driver.quit();
        */

	}
}
