package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateProductsPage {
	
WebDriver driver; // declaration initialized
	
	public  CreateProductsPage (WebDriver driver) // argument passed for constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "productName")
	private WebElement productNAmeBtn;
	
	@FindBy(xpath = "//select[@name='productCategory']")
	private WebElement selectCatgByDD;
	
	@FindBy(name="quantity")
	private WebElement quantityField;
	
	@FindBy(name = "price")
	private WebElement priceField;
	
	@FindBy(xpath = "//select[@name='vendorId']")
	private WebElement selectVendorDD;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addField;

	
	public WebElement getProductNAmeBtn() {
		return productNAmeBtn;
	}

	public WebElement getSelectCatgByDD() {
		return selectCatgByDD;
	}

	public WebElement getQuantityField() {
		return quantityField;
	}

	public WebElement getPriceField() {
		return priceField;
	}

	public WebElement getSelectVendorDD() {
		return selectVendorDD;
	}

	public WebElement getAddField() {
		return addField;
	}
	
	public void addProduct(String prodName,String Quantity,String price)
	{
		productNAmeBtn.sendKeys(prodName);
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.select(selectCatgByDD, 1);
		selectCatgByDD.click();
		quantityField.sendKeys(Quantity);
		priceField.sendKeys(price);
		wUtil.select(selectVendorDD, 2);
		selectVendorDD.click();
		addField.click();
	}
	
	

}
