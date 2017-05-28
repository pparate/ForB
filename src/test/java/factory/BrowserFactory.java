package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName)
	{
		
		if (browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		if (browserName.equalsIgnoreCase("chrome"))
		{
			//DataProviderFactory.getConfig().getChromePath();
			ConfigDataProvider path = new ConfigDataProvider();
			System.setProperty("webdriver.chrome.driver", path.getChromePath());
			driver = new ChromeDriver();
		}
		if (browserName.equalsIgnoreCase("ie"))
		{
			//DataProviderFactory.getConfig().getIEPath();
			ConfigDataProvider path = new ConfigDataProvider();
			System.setProperty("webdriver.ie.driver", path.getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
