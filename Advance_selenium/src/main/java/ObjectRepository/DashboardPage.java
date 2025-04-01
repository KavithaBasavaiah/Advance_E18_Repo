package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage
{
	WebDriver driver; // declaration initialized
	
	public DashboardPage(WebDriver driver) // local variable argument passed for constructor
	{
		this.driver=driver; // assigning local value variable to global variable
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(xpath = "//*[name()='svg' and @role='img']")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logoutBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public void DashboardEle()
	{
		campaignsLink.click();
	}
	public void logout()
	{
		profileIcon.click();
		Actions action = new Actions(driver);
		action.moveToElement(logoutBtn).click();
	}
}
