package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	 WebDriver driver; // declaration initialized
		
		public  ProductPage(WebDriver driver) // argument passed for constructor
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(xpath = "//span[text()='Add Product']")
		private WebElement addProductBtn;
		
		@FindBy(xpath = "//select[@class='form-control']")
		private WebElement searchPByDD;
		
		@FindBy(xpath = "//input[@type='text']")
		private WebElement searchPField;
		
		@FindBy(xpath = "//div[@role='alert']")
		private WebElement confMsg;

		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getAddProductBtn() {
			return addProductBtn;
		}

		public WebElement getSearchPByDD() {
			return searchPByDD;
		}

		public WebElement getSearchPField() {
			return searchPField;
		}

		public WebElement getConfMsg() {
			return confMsg;
		}
		
		
		
}
