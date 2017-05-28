package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="(//a[text()='Sign In'])[1]") WebElement login;
	
	@FindBy(xpath="(//a[@class='cart_ic'])[1]") WebElement cart;
	
	@FindBy(xpath="//a[text()='Location']") WebElement location;
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void clickOnCart()
	{
		cart.click();
	}
	
	public void clickOnLocation()
	{
		location.click();
	}
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}

}
