package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {
	
WebDriver driver; // declaration initialized
	
	public  CreateCampaignsPage (WebDriver driver) // argument passed for constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "campaignName")
	private WebElement CampaignName;
	
	@FindBy(name = "targetSize")
	private WebElement TargetSize;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement ExpectedCloseDate;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaignBtn;
	
	public WebElement getCampaignName() {
		return CampaignName;
	}

	public WebElement getTargetSize() {
		return TargetSize;
	}

	public WebElement getExpectedCloseDate() {
		return ExpectedCloseDate;
	}

   public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}

    public void createCampaignWithmandatoryFields(String campName,String target)
    {
    	CampaignName.sendKeys(campName);
    	TargetSize.clear();
    	TargetSize.sendKeys(target);
    	createCampaignBtn.click();
    }
    public void createCampaignWithCloseDate(String campName,String target,String date)
    {
    	CampaignName.sendKeys(campName);
    	TargetSize.clear();
    	TargetSize.sendKeys(target);
    	ExpectedCloseDate.sendKeys(date);
    	createCampaignBtn.click();
    }
    

}
