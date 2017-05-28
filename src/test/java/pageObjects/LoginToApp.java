package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginToApp {
	
	WebDriver driver;
	
	public LoginToApp(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id="email") WebElement username;
	
	@FindBy(id="password") WebElement password;
	
	@FindBy(xpath="//input[@value='Login']") WebElement loginButton;
	
	public void login(String username,String password)
	{
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		loginButton.click();
	}
}
