package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
    WebDriver driver; // declaration initialized
	
	public LoginPage(WebDriver driver) // argument passed for constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "username")
	private WebElement usernameField;
	
	@FindBy(id="inputPassword")
	private WebElement paswordField;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInBtn;
	
	@FindBy(linkText = "Forgot password?")
	private WebElement forgotPwdLink;
	
	@FindBy(linkText = "Create Account")
	private WebElement createAccLink;

	
	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPaswordField() {
		return paswordField;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getForgotPwdLink() {
		return forgotPwdLink;
	}

	public WebElement getCreateAccLink() {
		return createAccLink;
	}
	
	public void login(String uname,String pwd)
	{
		usernameField.sendKeys(uname);
		paswordField.sendKeys(pwd);
		signInBtn.click();
	}
	

}
