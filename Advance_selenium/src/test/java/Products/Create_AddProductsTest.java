package Products;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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
import ObjectRepository.CreateProductsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;

// @Listeners(ListenerImp.class)
public class Create_AddProductsTest extends BaseClass_AS {
  
	//@Parameters("browser")
	@Test()
   
	public void addProductTest() throws IOException, InterruptedException {
		
		JavaUtility jutil=new JavaUtility();
		int randNum = jutil.getRandomNum(10000);
		
		ExcelFileUtility excelUtil=new ExcelFileUtility();
		String prodName = excelUtil.readingDataFromExcel("Product", 1, 2)+randNum;
		String quantity = excelUtil.readingDataFromExcel("Product", 1, 3);
		String price = excelUtil.readingDataFromExcel("Product", 1, 4);
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		Thread.sleep(2000);
		
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(4000);
		dp.getProductsLink().click();
		
		ProductPage pp = new ProductPage(driver);
		pp.getAddProductBtn().click();
		
		CreateProductsPage cpp = new CreateProductsPage(driver);
		cpp.addProduct(prodName, quantity, price);
		Thread.sleep(2000);
		
		String confMsg =pp.getConfMsg().getText();
		boolean status = confMsg.contains(prodName);
		//	Assert.assertEquals(status, true,"Product not added");
			Assert.assertTrue(status, " Product not added");
			Reporter.log("Product "+prodName+" added successfully",true);
			
		
		/*
		if(confMsg.contains(prodName))
		{
			Reporter.log("Product added successfully",true);
		}
		else
		{
			Reporter.log("Product not added",true);
		}
		*/
		Thread.sleep(5000);
		
	}

}

      