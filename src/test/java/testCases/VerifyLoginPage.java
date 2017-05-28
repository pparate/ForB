package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginToApp;

public class VerifyLoginPage {
	
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver = BrowserFactory.getBrowser("firefox");
		
		driver.get(DataProviderFactory.getConfig().getURL());
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyLoginFunctionality()
	{
		LoginToApp login = PageFactory.initElements(driver, LoginToApp.class);
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		home.clickOnLogin();
		
		login.login(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		
		Assert.assertEquals("Invalid Login", driver.findElement(By.xpath("//label[text()='Invalid Login']")).getText());
		
		System.out.println("Test Case Passed");
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}
}
