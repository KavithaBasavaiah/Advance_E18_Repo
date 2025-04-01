package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CampaignsPage {
	
	 WebDriver driver; // declaration initialized
		
		public  CampaignsPage(WebDriver driver) // argument passed for constructor
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement CreateCampaignBtn;
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement searchByDD;
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchField;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement confMsg;
	

	public WebElement getConfMsg() {
		return confMsg;
	}

	public WebElement getCreateCampaignBtn() {
		return CreateCampaignBtn;
	}

	public WebElement getSearchByDD() {
		return searchByDD;
	}

	public WebElement getSearchField() {
		return searchField;
	}	
}
