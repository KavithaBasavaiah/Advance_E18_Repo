package Contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import GenericUtility.WebDriverUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

// @Listeners(ListenerImp.class)
public class CreateContactsTest extends BaseClass_AS {

	//@Parameters("browser")
	@Test()
	
	public void createContactWithCampaignTest() throws IOException, InterruptedException {
		
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(10000);
		
		ExcelFileUtility exUtil= new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("DDT1",1,2) + randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT1",1,3);
		String organization = exUtil.readingDataFromExcel("Contact",1,2) + randomNum;
		String title = exUtil.readingDataFromExcel("Contact",1,3);
		String contactName = exUtil.readingDataFromExcel("Contact",1,4) + randomNum;
		String mobile = exUtil.readingDataFromExcel("Contact",1,5);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		Thread.sleep(2000);
		
		CampaignsPage cp =new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWithmandatoryFields(Campaign, targetSize);
		Thread.sleep(3000);

		WebElement contactLink = dp.getContactsLink();
		
		WebDriverUtility Wutil = new WebDriverUtility();
		Wutil.waitForElementToBeClickable(driver, contactLink,20);
		contactLink.click();
		Thread.sleep(5000);
		
		ContactsPage ccp1 = new ContactsPage(driver);
		WebElement createContactBtn = ccp1.getCreateContactBtn();
		Wutil.waitForElementToBeClickable(driver, createContactBtn,20);
		createContactBtn.click();
		Thread.sleep(3000);
        
        CreateContactPage cct = new CreateContactPage(driver);
        cct.createContactWithCampaign(organization, title, contactName, mobile,"selectCampaign" ,"create-contact", Campaign);
	    Thread.sleep(3000);
	    
	    String ConfirmationMsg = ccp1.getConfMsg().getText();
	    boolean status = ConfirmationMsg.contains(contactName);
			Assert.assertEquals(status, true,"Contact not added");
		//	Assert.assertTrue(status, " Contact not added");
			// or can use--- Assert.assertTrue(status);
			Reporter.log("contact "+contactName+" added successfully",true);

	    /*  
	    if(ConfirmationMsg.contains(contactName))
	        {
	        	Reporter.log("Contact added Successfully",true);
	        }
	        else
	        {
	        	Reporter.log("Contact not added",true);
	        }
	        */
	       Thread.sleep(5000);
	      
	}

}
