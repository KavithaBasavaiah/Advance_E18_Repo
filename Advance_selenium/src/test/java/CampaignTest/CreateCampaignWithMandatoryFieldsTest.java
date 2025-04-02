package CampaignTest;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

// @Listeners(ListenerImp.class)
public class CreateCampaignWithMandatoryFieldsTest extends BaseClass_AS{
	
	@Test()
	public void createCampaignTest()  throws InterruptedException, IOException  {
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		String actualURL=driver.getCurrentUrl();
		/*if(actualURL.equals(expectedURL))
		{
			System.out.println("Validation is pass");
		}
		else
		{
			System.out.println("validation is failed");
		} 
		*/
		
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(10000);
		
		ExcelFileUtility exUtil= new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("DDT1",1,2) + randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT1",1,3);
		
		String closeDate =jUtil.generateReqDate(30);
		
		System.out.println(Campaign);
		System.out.println(targetSize);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		Thread.sleep(3000);
		
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(3000);
		
		dp.getCampaignsLink().click();
		Thread.sleep(2000);
		
		CampaignsPage cp =new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWithCloseDate(Campaign, targetSize,closeDate);
		Thread.sleep(2000);
		
		String ConfMsg = cp.getConfMsg().getText();
		boolean status = ConfMsg.contains(Campaign);
	//	Assert.assertEquals(status, true,"Campaign not added");
		Assert.assertTrue(status, " Campaign not added");
		Reporter.log("campaign "+Campaign+" added successfully",true);
		
		Thread.sleep(4000);
		   
	}
	
	
	//@Parameters("browser")
	@Test()
	public void createCampaignWithCloseDateTest() throws IOException, InterruptedException {
		
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(10000);
		
		ExcelFileUtility exUtil= new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("DDT1",1,2) + randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT1",1,3);
		Thread.sleep(2000);
		String closeDate =jUtil.generateReqDate(30);
		
		System.out.println(closeDate);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		Thread.sleep(2000);
		
		CampaignsPage cp =new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWithCloseDate(Campaign, targetSize,closeDate);
		Thread.sleep(4000);
		
		String ConfMsg = cp.getConfMsg().getText();
		Thread.sleep(4000);
		boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true,"Campaign not added");
	//	Assert.assertTrue(status, " Campaign not added");
		Reporter.log("campaign "+Campaign+" added successfully",true);
		Thread.sleep(3000);
		/*
		if(ConfMsg.contains(Campaign))
		{
			Reporter.log("campaign added successfully",true);
		}
		else
		{
			Reporter.log("campaign not added successfully",true);
		}
		*/
		
	}

}
