package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	 WebDriver driver; // declaration initialized
		
		public ContactsPage(WebDriver driver) // argument passed for constructor
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath = "//span[text()='Create Contact']")
		private WebElement createContactBtn;
		
		@FindBy(xpath = "//div[@role='alert']")
		private WebElement confMsg;

		public WebElement getConfMsg() {
			return confMsg;
		}

		public WebElement getCreateContactBtn() {
			return createContactBtn;
		}
		

}
