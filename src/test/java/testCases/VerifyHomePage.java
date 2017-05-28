package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pageObjects.HomePage;

public class VerifyHomePage {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver = BrowserFactory.getBrowser("firefox");
		
		driver.get(DataProviderFactory.getConfig().getURL());
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void testHomePage()
	{
		
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getAppTitle();
		
		Assert.assertEquals(title, title);
		
		System.out.println(title);
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
